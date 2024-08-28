package com.example.gestion_user.services;

import com.example.gestion_user.entities.Honoraire;

import java.util.List;

public interface HonoraireService {

    Honoraire addHonoraire(Honoraire honoraire) ;

    List<Honoraire> retrieveAllHonoraires() ;

    Honoraire updateHonoraire (Honoraire honoraire) ;

    void removeHonoraire (Integer idHonoraire) ;

    Honoraire retrieveHonoraire (Integer idHonoraire);

    public void addHonoraireAndAffectToAffaire(Honoraire honoraire, Integer idAffaire);

    public byte[] generateQRCodeForHonoraire(Integer idHonoraire) throws Exception;
}
