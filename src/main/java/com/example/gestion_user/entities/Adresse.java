package com.example.gestion_user.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class Adresse implements Serializable {




    @Column(name = "ville")
    private String ville;

    @Column(name = "codepostale")
    private String codepostale;

    @Column(name = "pays")
    private String pays;


}
