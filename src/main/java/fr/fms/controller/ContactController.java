package fr.fms.controller;

import fr.fms.entities.Contact;
import fr.fms.service.ImplBusiness;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/contacts/category/{id}")
    public  List<Contact> findByCategory(@PathVariable Long id) {
        return implIBusiness.getContactByCategory(id);
    }

}
