package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Integer>{
    Optional<Article> findByCodeArticle(String codeArticle);

}
