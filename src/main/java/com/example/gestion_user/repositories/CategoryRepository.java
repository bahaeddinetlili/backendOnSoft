package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
