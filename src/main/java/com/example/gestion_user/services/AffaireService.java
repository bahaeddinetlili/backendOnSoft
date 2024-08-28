package com.example.gestion_user.services;

import com.example.gestion_user.entities.Affaire;

import java.util.List;

public interface AffaireService {

    Affaire addAffaire (Affaire affaire) ;

    //public Affaire addAffaire(Affaire affaire, Integer idTribunal);

    List<Affaire> retrieveAllAffaires() ;

    Affaire updateAffaire (Affaire affaire) ;

    void removeAffaire (Integer idAffaire) ;

    Affaire retrieveAffaire (Integer idAffaire);

    public List<Affaire> searchAffaireByTitre(String titreAffaire);

}
