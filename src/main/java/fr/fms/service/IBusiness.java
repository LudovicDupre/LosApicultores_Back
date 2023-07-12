package fr.fms.service;

import fr.fms.entities.Category;

import java.util.List;

public interface IBusiness {
    Category saveCategory(Category category);

    List<Category> getCategories();
}
