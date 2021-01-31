package it.academy.loader;

import it.academy.pojos.Company;
import it.academy.pojos.Person;
import it.academy.util.HibernateUtil;

import java.io.Serializable;
import java.util.Scanner;


public class PersonLoader {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        System.out.println("Welcome to person loader. " +
                "\nEnter \"help\" to show comand list.");
        Scanner sc=new Scanner(System.in);
        while (true){
            String s = sc.nextLine();
            if (s.equals("help")){
                System.out.println("end - to finish app;" +
                        "\naddPerson - to create Person in database;" +
                        "\ndeletePerson - to delete Person in database;"+
                        "\nfindPerson - to find Person in databas;"+
                        "\naddCompany - to create Company in database;" +
//                        "\ndeleteCompany - to delete Company in database;"+
//                        "\nfindCompany - to find Company in databas;"+
                        "\nage - to update age Person in database;"+
                        "\nname - to update name Person in database;"+
                        "\nsurname - to update surname Person in database.");

            }
            if(s.equals("addPerson")){
                System.out.println("Enter age Person:");
                String age = sc.next();
                System.out.println("Enter name Person:");
                String name = sc.next();
                System.out.println("Enter surname Person:");
                String surname = sc.next();
                Person person=new Person(null, Integer.parseInt(age), name, surname,null);
                final Integer save = HibernateUtil.savePerson(person);
                System.out.println("Person was added with id="+save);
            }
            if(s.equals("addCompany")){
                System.out.println("Enter name Company:");
                String name = sc.next();
                System.out.println("Enter bank of Company:");
                String bank = sc.next();
                System.out.println("Enter bank account of Company:");
                String bankAccount = sc.next();
                Company company=new Company(null, name, bank, bankAccount,null);
                final Serializable save = HibernateUtil.saveCompany(company);
                System.out.println("Person was added with id="+save);
            }

            if (s.equals("findPerson")){
                System.out.println("Enter id Person to find:");
                String id = sc.next();
                Person loadPerson = HibernateUtil.findPerson(Integer.parseInt(id));
                if (loadPerson==null){
                    System.out.println("This Person is not exist");
                }
                else System.out.println(loadPerson);
            }
//            if (s.equals("findCompany")){
//                System.out.println("Enter id Company to find:");
//                String id = sc.next();
//                Company loadCompany = HibernateUtil.findCompany(Integer.parseInt(id));
//                if (loadCompany==null){
//                    System.out.println("This Company is not exist");
//                }
//                else System.out.println(loadCompany);
//            }
            if (s.equals("deletePerson")){
                System.out.println("Enter id Person to delete:");
                String id = sc.next();
                Person loadPerson = HibernateUtil.findPerson(Integer.parseInt(id));
                if (loadPerson==null){
                    System.out.println("This Person is not exist");
                }
                else {
                    HibernateUtil.deletePerson(Integer.parseInt(id));
                    System.out.println("Person id="+id+" was delete");}
            }
//            if (s.equals("deleteCompany")){
//                System.out.println("Enter id Company to delete:");
//                String id = sc.next();
//                Person loadPerson = HibernateUtil.findPerson(Integer.parseInt(id));
//                if (loadPerson==null){
//                    System.out.println("This Company is not exist");
//                }
//                else {
//                    HibernateUtil.deletePerson(Integer.parseInt(id));
//                    System.out.println("Company id="+id+" was delete");}
//            }
            if (s.equals("age")){
                System.out.println("Enter id Person to update age:");
                String id = sc.next();
                System.out.println("Enter age Person:");
                String age = sc.next();
                Person loadPerson = HibernateUtil.findPerson(Integer.parseInt(id));
                if (loadPerson==null){
                    System.out.println("This Person is not exist");
                }
                else {
                HibernateUtil.updateAge(Integer.parseInt(id), Integer.parseInt(age));
                    System.out.println("age person was update");}
            }
            if (s.equals("name")){
                System.out.println("Enter id Person to update name:");
                String id = sc.next();
                System.out.println("Enter name Person:");
                String name = sc.next();
                Person loadPerson = HibernateUtil.findPerson(Integer.parseInt(id));
                if (loadPerson==null){
                    System.out.println("This Person is not exist");
                }
                else {
                    HibernateUtil.updateName(Integer.parseInt(id), name);
                    System.out.println("Name person was update");}
            }
            if (s.equals("surname")){
                System.out.println("Enter id Person to update surname:");
                String id = sc.next();
                System.out.println("Enter surname Person:");
                String surname = sc.next();
                Person loadPerson = HibernateUtil.findPerson(Integer.parseInt(id));
                if (loadPerson==null){
                    System.out.println("This Person is not exist");
                }
                else {
                    HibernateUtil.updateSurname(Integer.parseInt(id), surname);
                    System.out.println("Surname person was update");}
            }
            if (s.equals("end")){
                break;
            }
        }
    }

}
