package fr.fms.service;

import fr.fms.entities.Category;

import java.util.List;
import java.util.Optional;

public interface IBusiness {
    Category saveCategory(Category category);

    List<Category> getCategories();

    void deleteCategory(Long id);

    Optional<Category> readCategory(Long id);
}
