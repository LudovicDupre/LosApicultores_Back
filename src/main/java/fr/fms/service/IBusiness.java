package fr.fms.service;

import fr.fms.entities.Category;
import fr.fms.entities.Contact;

import java.util.List;
import java.util.Optional;

public interface IBusiness {
    Category saveCategory(Category category);

    List<Category> getCategories();

    /*
     * @author mehdioui ayyoub
     * @return list of contacts
     **/
    List<Contact> getContacts();

    void deleteCategory(Long id);

    Optional<Category> readCategory(Long id);

    List<Contact> getContactByCategory(Long id);

    List<Contact> getContactByKeyword(String keyword);
}
