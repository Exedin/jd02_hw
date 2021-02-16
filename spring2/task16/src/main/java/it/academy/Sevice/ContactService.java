package it.academy.Sevice;

import it.academy.controller.ContactController;
import it.academy.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Service
public class ContactService {
    private List<Contact> contactList=new ArrayList<>();

    public static final Logger log =
            Logger.getLogger(ContactService.class.getName());
    @Autowired
    public void addContact(Contact contact){
        contactList.add(contact);
        log.info(String.format("Contact list: %s", contactList));
    }


}
