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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tribunal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTribunal")
    private Integer idTribunal ;

    private String nom;
    private String adresse;
    private String gouvernorat;
    private String ville;
    private Long telephone;
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToMany(mappedBy = "tribunal", cascade = CascadeType.ALL)
    private List<Affaire> affaires = new ArrayList<>();
}
