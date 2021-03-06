package it.academy.util;

import it.academy.pojos.Address;
import it.academy.pojos.Person;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

@FixMethodOrder
public class HibernateUtilTest extends BaseTest {


    @Test
    public void save() {
        cleanInsert("PersonTest.xml");
        Person person=new Person(null, 32, "Andrei", "TestSave",new Address("testStreet","testCity","TestCode"));
        Integer save = HibernateUtil.savePerson(person);
        assertNotNull(save);
        System.out.println(save);
        deleteDataset();

    }

    @Test
    public void find() {
        cleanInsert("PersonTest.xml");
//        Person person=new Person(2, 32, "Andrei", "TestFind");
//        Integer save = HibernateUtil.save(person);
        Person personLoad = HibernateUtil.findPerson(1);
        String actual = personLoad.getSurname();
        assertEquals("Ivanova",actual);
        deleteDataset();
    }

    @Test
    public void delete() {
        cleanInsert("PersonTest.xml");
//        Person person=new Person(null, 32, "Andrei", "TestDelete");
//        Integer save = HibernateUtil.save(person);
        HibernateUtil.deletePerson(1);
        Person personLoad = HibernateUtil.findPerson(1);
        assertNull(personLoad);
        deleteDataset();
    }

    @Test
    public void updateAge() {
        cleanInsert("PersonTest.xml");
//        Person person=new Person(null, 32, "Andrei", "TestAge");
//        Integer save = HibernateUtil.save(person);
//        Person personLoad = HibernateUtil.find(save);
        HibernateUtil.updateAge(1,777);
        Integer newAge = HibernateUtil.findPerson(1).getAge();
        assertEquals(777l, (long)newAge);
        deleteDataset();
    }

    @Test
    public void updateName() {
        cleanInsert("PersonTest.xml");
//        Person person=new Person(null, 32, "Andrei", "Tru");
//        Integer save = HibernateUtil.save(person);
//        Person personLoad = HibernateUtil.find(save);
        HibernateUtil.updateName(1,"TestName");
        String newName = HibernateUtil.findPerson(1).getName();
        assertEquals("TestName", newName);
        deleteDataset();
    }

    @Test
    public void updateSurname() {
        cleanInsert("PersonTest.xml");
//        Person person=new Person(null, 32, "Andrei", "Tru");
//        Integer save = HibernateUtil.save(person);
//        Person personLoad = HibernateUtil.find(save);
        HibernateUtil.updateSurname(1,"TestSurname");
        String newSurname = HibernateUtil.findPerson(1).getSurname();
        assertEquals("TestSurname", newSurname);
        deleteDataset();
    }

}