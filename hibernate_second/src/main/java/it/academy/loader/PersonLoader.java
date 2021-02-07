package it.academy.loader;

import it.academy.pojos.Employeer;
import it.academy.pojos.Person;
import it.academy.pojos.Student;
import it.academy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Scanner;


public class PersonLoader {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Serializable save;
        Person person = new Person(1,"Andrey","Tru");
        Person employeer=new Employeer("BEtolit", 1000.0);
        Student student=new Student("StroyFaculty", 10.0);
        employeer.setId(2);
        employeer.setName("andd");
        employeer.setSurname("trrrr");
        student.setName("Stttt");
        student.setSurname("bbbb");



        try {
            tx = session.beginTransaction();
            save = session.save(person);
            save = session.save(employeer);
            save = session.save(student);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }


//
//        System.out.println("Welcome to person loader. " +
//                "\nEnter \"help\" to show comand list.");
//        Scanner sc=new Scanner(System.in);
//        while (true){
//            String s = sc.nextLine();
//            if (s.equals("help")){
//                System.out.println("end - to finish app;" +
//                        "\nadd - to create Person in database;" +
//                        "\ndelete - to delete Person in database;"+
//                        "\nage - to update age Person in database;"+
//                        "\nname - to update name Person in database;"+
//                        "\nsurname - to update surname Person in database;"+
//                        "\nfind - to find Person in database.");
//            }
//            if(s.equals("add")){
//                System.out.println("Enter age Person:");
//                String age = sc.next();
//                System.out.println("Enter name Person:");
//                String name = sc.next();
//                System.out.println("Enter surname Person:");
//                String surname = sc.next();
//                Person person=new Person(null, Integer.parseInt(age), name, surname);
//                final Integer save = HibernateUtil.save(person);
//                System.out.println("Person was added with id="+save);
//            }
//            if (s.equals("find")){
//                System.out.println("Enter id Person to find:");
//                String id = sc.next();
//                Person loadPerson = HibernateUtil.find(Integer.parseInt(id));
//                if (loadPerson==null){
//                    System.out.println("This Person is not exist");
//                }
//                else System.out.println(loadPerson);
//            }
//            if (s.equals("delete")){
//                System.out.println("Enter id Person to delete:");
//                String id = sc.next();
//                Person loadPerson = HibernateUtil.find(Integer.parseInt(id));
//                if (loadPerson==null){
//                    System.out.println("This Person is not exist");
//                }
//                else {
//                    HibernateUtil.delete(Integer.parseInt(id));
//                    System.out.println("Person id="+id+" was delete");}
//            }
//            if (s.equals("age")){
//                System.out.println("Enter id Person to update age:");
//                String id = sc.next();
//                System.out.println("Enter age Person:");
//                String age = sc.next();
//                Person loadPerson = HibernateUtil.find(Integer.parseInt(id));
//                if (loadPerson==null){
//                    System.out.println("This Person is not exist");
//                }
//                else {
//                HibernateUtil.updateAge(Integer.parseInt(id), Integer.parseInt(age));
//                    System.out.println("age person was update");}
//            }
//            if (s.equals("name")){
//                System.out.println("Enter id Person to update name:");
//                String id = sc.next();
//                System.out.println("Enter name Person:");
//                String name = sc.next();
//                Person loadPerson = HibernateUtil.find(Integer.parseInt(id));
//                if (loadPerson==null){
//                    System.out.println("This Person is not exist");
//                }
//                else {
//                    HibernateUtil.updateName(Integer.parseInt(id), name);
//                    System.out.println("Name person was update");}
//            }
//            if (s.equals("surname")){
//                System.out.println("Enter id Person to update surname:");
//                String id = sc.next();
//                System.out.println("Enter surname Person:");
//                String surname = sc.next();
//                Person loadPerson = HibernateUtil.find(Integer.parseInt(id));
//                if (loadPerson==null){
//                    System.out.println("This Person is not exist");
//                }
//                else {
//                    HibernateUtil.updateSurname(Integer.parseInt(id), surname);
//                    System.out.println("Surname person was update");}
//            }
//            if (s.equals("end")){
//                break;
//            }
//        }
    }

}
