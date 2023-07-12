package fr.fms.repositories;

import fr.fms.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository  extends JpaRepository<Contact,Long> {
}
