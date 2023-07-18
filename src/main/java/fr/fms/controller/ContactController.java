package fr.fms.controller;

import fr.fms.entities.Contact;
import fr.fms.service.ImplBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@Slf4j
public class ContactController {

    @Autowired
    private ImplBusiness implIBusiness;


    @GetMapping("/contacts")
    public List<Contact> allTrainings() {
        return implIBusiness.getContacts();
    }


    @GetMapping("/contacts/category/{id}")
    public List<Contact> findByCategory(@PathVariable Long id) {
        return implIBusiness.getContactByCategory(id);
    }


    @GetMapping("/contacts/search/{keyword}")
    public List<Contact> searchByKeyword(@PathVariable String keyword) {
        try {
            return implIBusiness.getContactByKeyword(keyword);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    @PostMapping("/addContact")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact){
        Contact con = implIBusiness.saveContact(contact);
        if(Objects.isNull(contact)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contact.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

}
