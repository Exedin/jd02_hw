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

    @RequestMapping(value = "/contact/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
        //write the code here to add contact
        return "redirect:contact.html";
    }

    @RequestMapping("/contact")
    public String showContacts(Model m) {

        return "contact";
    }
}