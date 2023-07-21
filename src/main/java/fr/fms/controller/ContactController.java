package fr.fms.controller;

import fr.fms.entities.Contact;
import fr.fms.service.ImplBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
@Slf4j
public class ContactController {

    @Autowired
    private ImplBusiness implIBusiness;

    /**
     * Méthode en GET permettant d'afficher une liste de contacts
     * @return la liste de contacts
     */
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> allContacts() {
        System.out.println("test passage");
        List<Contact> contacts = implIBusiness.getContacts();
        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
    }

    /**
     * méthode en GET permettant de sélectionner une catégorie pour la recheche de contacts
     * @param id l'identifiant de la catégorie choisie
     * @return renvoie la  atégorie choisie
     */
    @GetMapping("/contacts/category/{id}")
    public List<Contact> findByCategory(@PathVariable Long id) {
        return implIBusiness.getContactByCategory(id);
    }

    /**
     * méthode en DELETE permettant de supprimer un contact
     * @param id l'identifiant du contact à supprimer
     */
    @DeleteMapping("/contacts/{id}")
    public void deleteById(@PathVariable Long id) {
        System.out.println("------------------->" + id);
        implIBusiness.deleteContact(id);
    }

    /**
     * méthode en GET permettant la recherche d'un contact par mot clé (chaine de caractère)
     * @param keyword la chaine de caractère à trouver
     * @return renvoie une liste de contacts contenant la chaine de caractères recherchée.
     */
    @GetMapping("/contacts/search/{keyword}")
    public List<Contact> searchByKeyword(@PathVariable String keyword) {
        try {
            return implIBusiness.getContactByKeyword(keyword);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * émthode en POST permettant d'enregistrer un nouvel utilisateur
     * @param contact l'Object utilisateur à enregistrer
     * @return renvoie vers la page
     */
    @PostMapping("/addContact")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        Contact c = implIBusiness.saveContact(contact);
        if(Objects.isNull(c)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    /**
     * méthopde en POST permettant de modifier les informations d'un contact
     * @param contact le contact à modifier
     * @return renvoie vers la page
     */
//    @PostMapping("/contacts")
//    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact) {
//        Contact con = implIBusiness.saveContact(contact);
//        if(Objects.isNull(con)) { return ResponseEntity.noContent().build(); }
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(contact.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
}
