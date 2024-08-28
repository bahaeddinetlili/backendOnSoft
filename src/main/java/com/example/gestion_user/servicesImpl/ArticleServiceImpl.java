package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Article;
import com.example.gestion_user.repositories.ArticleRepository;
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
import java.util.List;
import java.util.Optional;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;


    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


   @Override
    public Article save(Article article) {
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
                    if (article.getImageData() != null) {
                        existingArticle.setImageData(article.getImageData());
                    }
                    return articleRepository.save(existingArticle);
                })
                .orElseThrow(() -> new RuntimeException("Article not found with id " + id));
    }

    @Override
    public Article findById(Integer id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null); // or throw a custom exception

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

        // Create the content of the QR code
        String qrCodeContent =
                "Code Article: " + article.getCodeArticle() +
                        "\nDesignation: " + article.getDesignation() +
                        "\nPrix Unitaire HT: " + article.getPrixUnitaireHt() +
                        "\nTaux TVA: " + article.getTauxTva() +
                        "\nPrix Unitaire TTC: " + article.getPrixUnitaireTtc();

        // Generate the QR code
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, 250, 250);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", baos);

        // Convert the generated image data into a byte array
        return baos.toByteArray();
    }
}
