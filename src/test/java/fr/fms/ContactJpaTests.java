package fr.fms;

import fr.fms.entities.Contact;
import fr.fms.repositories.ContactRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class ContactJpaTests {
    @Autowired
    ContactRepository contactRepository;
    @Test
    void should_find_all_contacts(){
        contactRepository.save(new Contact(null, "babar", "éléphant", "elephant@gmail.com", "5 rue de l'Inde", "0603020504", null, null));
        Iterable<Contact> contacts = contactRepository.findAll();
        assertThat(contacts).isNotEmpty();
    }
}
