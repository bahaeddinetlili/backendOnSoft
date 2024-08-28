package com.example.gestion_user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dossier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDossier;
    private String nomDossier;
    @Enumerated(EnumType.STRING)
    private EtatDossier etatDossier;

   /* @JsonIgnore
    @OneToMany(mappedBy = "dossier", cascade = CascadeType.ALL)
    private List<Courrier> courriers;*/

    @JsonIgnore
    @ManyToOne
    private User user;



}
