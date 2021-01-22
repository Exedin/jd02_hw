package it.academy.loader;

import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;

public class PersonLoader {
    public static void main(String[] args) throws Exception {
        Person person = new Person(null, 35, "Yuli", "Slabko");
        EntityManager em= HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        HibernateUtil.close();

        save();
    }
    public   void delete (){
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
    }

    public static   void save (){
        Person person=new Person(null, 25, "Yuli", "Slabko");
        Session session=HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
    public void find(){
        Session session=HibernateUtil.getSession();
        Person person=session.get(Person.class, 2);
    }

}
