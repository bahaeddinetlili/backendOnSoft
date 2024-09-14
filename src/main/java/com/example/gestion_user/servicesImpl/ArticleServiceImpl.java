package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Article;
import com.example.gestion_user.entities.Category;
import com.example.gestion_user.entities.Famille;
import com.example.gestion_user.repositories.ArticleRepository;
import com.example.gestion_user.repositories.CategoryRepository;
import com.example.gestion_user.repositories.FamilleRepository;
import com.example.gestion_user.services.ArticleService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private FamilleRepository familleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Article save(Article article) {
        BigDecimal prixUnitaireHt = article.getPrixUnitaireHt();
        BigDecimal tauxTva = article.getTauxTva();
        if (prixUnitaireHt != null && tauxTva != null) {
            BigDecimal prixUnitaireTtc = prixUnitaireHt.multiply(BigDecimal.valueOf(1 + tauxTva.doubleValue() * 0.01));
            article.setPrixUnitaireTtc(prixUnitaireTtc);
        }
        return articleRepository.save(article);
    }


    @Override
    public Article updateArticle(Integer id, Article article) {
        return articleRepository.findById(id)
                .map(existingArticle -> {
                    existingArticle.setCodeArticle(article.getCodeArticle());
                    existingArticle.setDesignation(article.getDesignation());
                    existingArticle.setPrixUnitaireHt(article.getPrixUnitaireHt());
                    existingArticle.setTauxTva(article.getTauxTva());
                    existingArticle.setPrixUnitaireTtc(article.getPrixUnitaireTtc());
                    existingArticle.setDescription(article.getDescription());
                    existingArticle.setImageData(article.getImageData());

                    // Update category
                    if (article.getCategory() != null) {
                        Category category = categoryRepository.findById(article.getCategory().getId())
                                .orElseThrow(() -> new RuntimeException("Category not found with id " + article.getCategory().getId()));
                        existingArticle.setCategory(category);
                    }

                    return articleRepository.save(existingArticle);
                })
                .orElseThrow(() -> new RuntimeException("Article not found with id " + id));
    }

    @Override
    public Article findById(Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    @Override
    public Optional<Article> findByCodeArticle(String codeArticle) {
        return articleRepository.findByCodeArticle(codeArticle);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void saveImage(Long articleId, MultipartFile file) throws IOException {
        Optional<Article> articleOptional = articleRepository.findById(articleId.intValue());
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            article.setImageData(file.getBytes());
            articleRepository.save(article);
        } else {
            throw new IOException("Article not found");
        }
    }

    @Override
    public byte[] generateQRCodeForArticle(Integer id) throws Exception {
        Article article = articleRepository.findById(id).orElse(null);
        if (article == null) {
            throw new Exception("Article not found");
        }

        String qrCodeContent = "Code Article: " + article.getCodeArticle() +
                "\nDesignation: " + article.getDescription() +
                "\nPrix Unitaire HT: " + article.getPrixUnitaireHt() +
                "\nTaux TVA: " + article.getTauxTva() +
                "\nPrix Unitaire TTC: " + article.getPrixUnitaireTtc();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, 250, 250);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", baos);

        return baos.toByteArray();
    }
}
