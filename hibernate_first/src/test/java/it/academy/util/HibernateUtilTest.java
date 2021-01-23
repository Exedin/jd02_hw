package it.academy.util;

import it.academy.pojos.Person;
import org.hibernate.SessionFactory;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

@FixMethodOrder
public class HibernateUtilTest {

    private SessionFactory factory;

    @Before
    public void setUp() throws Exception {
        HibernateUtil hibernateUtil = new HibernateUtil("hibernate.cfg.test.xml");
    }

    @Test
    public void save() {
        Person person=new Person(1, 32, "Andrei", "TestSave");
        Integer save = HibernateUtil.save(person);
        assertNotNull(save);

    }

    @Test
    public void find() {

        Person person=new Person(2, 32, "Andrei", "TestFind");
        Integer save = HibernateUtil.save(person);
        Person personLoad = HibernateUtil.find(save);
        String actual = personLoad.getSurname();
        assertEquals("TestFind",actual);

    }

    @Test
    public void delete() {
        Person person=new Person(null, 32, "Andrei", "TestDelete");
        Integer save = HibernateUtil.save(person);
        HibernateUtil.delete(save);
        Person personLoad = HibernateUtil.find(save);
        assertNull(personLoad);

    }

    @Test
    public void updateAge() {
        Person person=new Person(null, 32, "Andrei", "TestAge");
        Integer save = HibernateUtil.save(person);
        Person personLoad = HibernateUtil.find(save);
        HibernateUtil.updateAge(personLoad.getId(),777);
        Integer newAge = HibernateUtil.find(save).getAge();
        assertEquals(777l, (long)newAge);
    }

    @Test
    public void updateName() {
        Person person=new Person(null, 32, "Andrei", "Tru");
        Integer save = HibernateUtil.save(person);
        Person personLoad = HibernateUtil.find(save);
        HibernateUtil.updateName(personLoad.getId(),"TestName");
        String newName = HibernateUtil.find(save).getName();
        assertEquals("TestName", newName);
    }

    @Test
    public void updateSurname() {
        Person person=new Person(null, 32, "Andrei", "Tru");
        Integer save = HibernateUtil.save(person);
        Person personLoad = HibernateUtil.find(save);
        HibernateUtil.updateSurname(personLoad.getId(),"TestSurname");
        String newSurname = HibernateUtil.find(save).getSurname();
        assertEquals("TestSurname", newSurname);
    }


    @After
    public void tearDown() throws Exception {
        HibernateUtil.getSessionFactory().close();
    }
}