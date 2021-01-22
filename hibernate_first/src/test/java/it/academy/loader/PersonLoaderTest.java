package it.academy.loader;

import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
@FixMethodOrder
public class PersonLoaderTest extends TestCase {
    private SessionFactory factory;

    @Before
    public void setUp() throws Exception {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.test.xml")
                        .build();
        factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public void testSave() {
        Person person=new Person(null, 25, "Yuli", "Slabko");
        Session session=HibernateUtil.getSession();
        Transaction transaction = null;
        Serializable id;
        try {
            transaction = session.beginTransaction();
            id=session.save(person);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }

        //Then
        assertNotNull(id);


    }

    public void testDelete() {
        Session session=HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Person person=session.get(Person.class, 1);
            session.delete(person);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
        assertNull(session.get(Person.class, 1L));
        session.close();
    }

    public void testFind() {

    }

    @After
    public void tearDown() throws Exception {
        factory.close();
    }
}