package com.example.gestion_user.controllers;

import com.example.gestion_user.entities.Category;
import com.example.gestion_user.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category newCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(newCategory);
    }

    // Mettre à jour une catégorie existante
    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(
            @PathVariable("id") Integer id,
            @RequestBody Category category) {
        Category updatedCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updatedCategory);
    }

    // Supprimer une catégorie
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    // Récupérer une catégorie par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    // Récupérer toutes les catégories
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
}
