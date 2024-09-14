package com.example.gestion_user.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Famille implements Serializable{


    @Id
    @GeneratedValue
    private Integer Id;

    private  String Libelle;
/*
    @OneToMany(mappedBy = "famille", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();


 */
}
