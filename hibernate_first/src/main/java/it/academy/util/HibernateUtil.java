package it.academy.util;

import it.academy.pojos.Address;
import it.academy.pojos.Company;
import it.academy.pojos.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public HibernateUtil() {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        sessionFactory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();
    }
    public HibernateUtil(String xml) {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure(xml)
                        .build();
        sessionFactory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();
    }


    public static Session getSession(){
        return sessionFactory.openSession();
    }
    public static Integer savePerson(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Serializable save;
        try {
            tx = session.beginTransaction();
            save = session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return (Integer) save;
    }
    public static Serializable saveCompany(Company company) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Serializable save;
        try {
            tx = session.beginTransaction();
            save = session.save(company);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
        return save;
    }

    public static Person findPerson(Integer id) {
        Session session = HibernateUtil.getSession();
        Person loadPerson = session.get(Person.class, id);
        session.close();
        return loadPerson;
    }
//    public static Company findCompany(Integer id) {
//        Session session = HibernateUtil.getSession();
//        Company loadCompany = session.get(Company.class, id);
//        session.close();
//        return loadCompany;
//    }
    public static void deletePerson(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            session.delete(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
//    public static void deleteCompany(Integer id) {
//        Session session = HibernateUtil.getSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            Person person = session.get(Person.class, id);
//            session.delete(person);
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            throw e;
//        } finally {
//            session.close();
//        }
//    }
    public static void deletePerson() {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Person person=new Person(1, 32, "Andrei", "TestSave",
                new Address("testStreet","testCity","TestCode"));
        Serializable save;
        try {
            tx = session.beginTransaction();
            save = session.save(person);
            Person personLoad = session.get(Person.class, save);
            session.delete(personLoad);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    public static void updateAge(Integer id, Integer age) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            person.setAge(age);
            session.flush();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    public static void updateName(Integer id, String name) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            person.setName(name);
            session.flush();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    public static void updateSurname(Integer id, String name) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person person = session.get(Person.class, id);
            person.setSurname(name);
            session.flush();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
