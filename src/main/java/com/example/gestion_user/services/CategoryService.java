package com.example.gestion_user.services;

import com.example.gestion_user.entities.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);
    Category updateCategory(Integer id, Category category);
    void deleteCategory(Integer id);
    Category getCategoryById(Integer id);
    List<Category> getAllCategories();
}
