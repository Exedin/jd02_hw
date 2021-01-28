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

public class CompanyTest {


    @Test
    public void create(){

        Company company =new Company(null, "TestCompany","testBank","123ad123",
                new Address("testStreet","testCity","TestCode"));
        HibernateUtil hibernateUtil=new HibernateUtil("hibernate.cfg.test.xml");
        Session session = HibernateUtil.getSessionFactory().openSession();
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
    }

}
