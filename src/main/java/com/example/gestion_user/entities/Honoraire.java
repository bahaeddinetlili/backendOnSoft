package com.example.gestion_user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Honoraire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHonoraire")

    private Integer idHonoraire ;
    private float montant ;
    private LocalDate date ;
    private String titre ;
    private String type ;
    private String reste ;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Affaire affaire ;



}
