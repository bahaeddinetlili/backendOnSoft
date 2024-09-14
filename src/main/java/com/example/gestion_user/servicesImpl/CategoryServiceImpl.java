package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Category;
import com.example.gestion_user.repositories.CategoryRepository;
import com.example.gestion_user.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Integer id, Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category updatedCategory = existingCategory.get();
            updatedCategory.setCode(category.getCode());
            updatedCategory.setLibelle(category.getLibelle());
            return categoryRepository.save(updatedCategory);
        } else {
            throw new RuntimeException("Category not found with ID: " + id);
        }
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
