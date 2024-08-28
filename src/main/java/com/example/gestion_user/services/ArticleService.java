package com.example.gestion_user.services;

import com.example.gestion_user.entities.Article;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ArticleService {

    Article save(Article article);

    Article updateArticle(Integer id, Article article);


    Article findById(Integer id);

    Optional<Article> findByCodeArticle(String codeArticle);

    List<Article> findAll();

    void delete(Integer id);

    void saveImage(Long articleId, MultipartFile file) throws IOException;

    public byte[] generateQRCodeForArticle(Integer id) throws Exception;

}
