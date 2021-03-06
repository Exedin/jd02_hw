package it.academy.util;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseTest {

    private final static Logger log = Logger.getLogger(BaseTest.class.getName());

    private IDatabaseConnection connection;
    private IDataSet dataSet;

    private SessionFactory factory;

    @Before
    public void setUp() throws Exception {
        HibernateUtil hibernateUtil = new HibernateUtil("hibernate.cfg.test.xml");
    }

    @After
    public void tearDown() throws Exception {
        HibernateUtil.getSessionFactory().close();
    }


    public void cleanInsert(String resourceName) {
        try {
            if (connection == null) {
                connection = new MySqlConnection(
                        MySqlDataSource.getTestConnection(),
                        "jpadb_test");
            }
            dataSet = new FlatXmlDataSetBuilder().build(BaseTest.class
                    .getResourceAsStream(resourceName));
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        } catch (SQLException | DatabaseUnitException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void deleteDataset() {
        try {
            DatabaseOperation.DELETE.execute(connection, dataSet);
            connection.close();
        } catch (SQLException | DatabaseUnitException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}

class MySqlDataSource {

    private final static Logger log = Logger.getLogger(MySqlDataSource.class.getName());
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(MySqlDataSource.class
                    .getResourceAsStream("/hibernate_test.ds.properties"));
            Class.forName(properties.getProperty("jdbc.drivers"));
        } catch (ClassNotFoundException | IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static Connection getTestConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties
        );
    }

}
