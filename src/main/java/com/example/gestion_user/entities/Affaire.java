package com.example.gestion_user.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Affaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAffaire")

    private Integer idAffaire;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateCreation;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateCloture;
    private String titre;
    private String description;
    private String etat;
    private String reference;
    @Enumerated(EnumType.STRING)
    private Phase phase;


    @ManyToOne
    private Tribunal tribunal;

    /*@JsonIgnore
    @OneToMany(mappedBy="affaire", cascade = CascadeType.ALL)
    private Set<Dossier> Dossiers ;*/

    @JsonIgnore
    @OneToMany(mappedBy = "affaire", cascade = CascadeType.ALL)
    private Set<Honoraire> Honoraires;

}
