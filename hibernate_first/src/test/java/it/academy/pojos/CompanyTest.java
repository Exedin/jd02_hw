package it.academy.pojos;

import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import java.io.Serializable;

public class CompanyTest extends BaseTest{


    @Test
    public void create(){
        cleanInsert("CompanyTest.xml");
        Session session = HibernateUtil.getSession();

        Company company =new Company(null, "TestCompany1","testBank1","123",
                new Address("testStreet1","testCity1","TestCode1"));
        Transaction tx = null;
        Serializable id;
        try {
            tx = session.beginTransaction();
            //do some work
            id = session.save(company);
            session.save(company);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        System.out.println(id);
        assertNotNull(id);
        deleteDataset();
    }

}
