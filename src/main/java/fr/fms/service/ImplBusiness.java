package fr.fms.service;

import fr.fms.entities.Category;
import fr.fms.entities.Contact;
import fr.fms.repositories.CategoryRepository;
import fr.fms.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplBusiness implements IBusiness {

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
        return contactRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> readCategory(Long id) {
        return categoryRepository.findById(id);

    }

    @Override
    public List<Contact> getContactByCategory(Long id) {
        return contactRepository.findByCategoryId(id);
    }

    @Override
    public List<Contact> getContactByKeyword(String keyword) {
        return contactRepository.findBylastNameContains(keyword);
    }

    @Override
    public void deleteContact(Long id) { contactRepository.deleteById(id);

    }
}
