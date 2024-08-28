package com.example.gestion_user.controllers;


import com.example.gestion_user.entities.Article;
import com.example.gestion_user.services.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    // Save an article
    @PostMapping("/add-article")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        Article savedArticle = articleService.save(article);
        return new ResponseEntity<>(savedArticle, HttpStatus.CREATED);
    }
/*
    // Find an article by ID
    @GetMapping("/retrieve-article/{idArticle}")
    public ResponseEntity<Article> getArticleById(@PathVariable Integer id) {
        Article article = articleService.findById(id);
        return article != null ? new ResponseEntity<>(article, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

*/


    @GetMapping("/retrieve-all-articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.findAll();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }


    // Delete an article by ID
    @DeleteMapping("/remove-article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Integer id) {
        articleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Save image for an article
    @PostMapping("/{id}/image")
    public ResponseEntity<Void> uploadArticleImage(@PathVariable Integer id, @RequestParam("file") MultipartFile file) {
        try {
            articleService.saveImage(Long.valueOf(id), file);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/retrieve-article/{idArticle}")
    public ResponseEntity<Article> retrieveArticle(@PathVariable Integer idArticle) {
        try {
            Article article = articleService.findById(idArticle);
            return article != null ? new ResponseEntity<>(article, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update-article/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Integer id, @RequestBody Article article) {
        try {
            Article updatedArticle = articleService.updateArticle(id, article);
            return new ResponseEntity<>(updatedArticle, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // Generate QR code for an article
    @GetMapping("/generateQRCodeForArticle/{id}")
    public ResponseEntity<byte[]> generateQRCodeForArticle(@PathVariable Integer id) {
        try {
            byte[] qrCode = articleService.generateQRCodeForArticle(id);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
