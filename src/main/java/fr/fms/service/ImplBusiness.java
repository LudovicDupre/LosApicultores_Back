package fr.fms.service;

import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import fr.fms.repositories.CategoryRepository;
import fr.fms.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplBusiness implements IBusiness{

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ContactRepository contactRepository;


    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }
}
