package fr.fms.repositories;

import fr.fms.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByCategoryId(Long id);

    List<Contact> findAllByOrderByLastNameAsc();

    List<Contact> findBylastNameContains(String keyword);
}
