package it.academy.util;

import it.academy.pojos.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

//    private HibernateUtil hibernateUtil=new HibernateUtil();
    private static EntityManagerFactory emFactory;
    private static SessionFactory sessionFactory;

    static {
        emFactory= Persistence.createEntityManagerFactory("it.academy");
    }
    static {
        try {
            Configuration configuration= new Configuration().configure();
            configuration.addAnnotatedClass(Person.class);
            configuration.addResource("hibernate.cfg.xml");
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    public  static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }
    public  static  void close (){
        emFactory.close();
    }

    public static Session getSession (){
        return sessionFactory.openSession();
    }
    private HibernateUtil() {
//        try {
//            Configuration configuration= new Configuration().configure();
//            configuration.addAnnotatedClass(Person.class);
//            configuration.addResource("hibernate.cfg.test.xml");
//            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
//                    applySettings(configuration.getProperties());
//            sessionFactory = configuration.buildSessionFactory(builder.build());
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
    }
}
