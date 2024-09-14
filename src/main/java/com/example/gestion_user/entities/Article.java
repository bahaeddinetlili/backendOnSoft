package com.example.gestion_user.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name = "designation")
    private String Designation;


    @Column(name = "prixunitaireht")
    private BigDecimal prixUnitaireHt;


    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @Lob
    @Column(name = "description")
    private String description;



    @Lob // Use this annotation for large objects
    @Column(name = "imagedata")
    private byte[] imageData;

/*
    @ManyToOne
    @JoinColumn(name = "famille_id")
    private Famille famille;
*/
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
