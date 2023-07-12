package fr.fms.controller;

import fr.fms.entities.Contact;
import fr.fms.service.ImplBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private ImplBusiness implIBusiness;


    @GetMapping("/contacts")
    public List<Contact> allTrainings() {
        return implIBusiness.getContacts();
    }


}
