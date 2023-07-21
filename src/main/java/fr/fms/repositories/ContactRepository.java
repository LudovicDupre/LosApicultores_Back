package fr.fms.repositories;

import fr.fms.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    /**
     * méthode permettant de récupérer une catégorie
     * @param id l'identifiant de la catégorie à récupérer
     * @return renvoie la catégorie récupérée
     */
    List<Contact> findByCategoryId(Long id);

    /**
     * méthode permettant de récupérer une liste de contacts par ordre alpahbétique
     * @return renvoie une liste de contacts par ordre alphabétique
     */
    List<Contact> findAllByOrderByLastNameAsc();

    /**
     * méthode permettant de récupérer une listre de contacts par recherche avec mot clé
     * @param keyword la chaine de caractère à trouver
     * @return renvoie une liste de contacts contenant la chaine de caractère à rechercher
     */
    List<Contact> findBylastNameContains(String keyword);
}
