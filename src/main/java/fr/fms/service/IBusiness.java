package fr.fms.service;

import fr.fms.entities.Category;
import fr.fms.entities.Contact;

import java.util.List;

public interface IBusiness {

    Category saveCategory(Category category);

    List<Category> getCategories();

    /*
     * @author mehdioui ayyoub
     * @return list of contacts
     **/
    List<Contact> getContacts();
}
