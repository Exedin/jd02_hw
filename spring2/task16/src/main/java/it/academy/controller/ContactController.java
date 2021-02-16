package it.academy.controller;
import it.academy.Sevice.ContactService;
import it.academy.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@SessionAttributes
public class ContactController {
    public static final Logger log =
            Logger.getLogger(ContactController.class.getName());
    @Autowired
    ContactService contactService;
    @RequestMapping(value = "/addContact")
    public String addContact(@ModelAttribute Contact contact) {
        log.info(String.format("New contact: %s", contact));
        contactService.addContact(contact);
        //write the code here to add contact
        return "contactAdded";
    }

    @RequestMapping("/contact")
    public String showContacts(Model m) {

        return "contact";
    }
}