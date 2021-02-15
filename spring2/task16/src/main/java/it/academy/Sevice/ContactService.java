package it.academy.Sevice;

import it.academy.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactService {
    private List<Contact> contactList;

    public void addContact(Contact contact){
        contactList.add(contact);
        System.out.println(contactList);
    }


}
