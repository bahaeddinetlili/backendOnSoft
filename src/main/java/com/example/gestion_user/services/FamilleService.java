package com.example.gestion_user.services;

import com.example.gestion_user.entities.Famille;

import java.util.List;

public interface FamilleService {
    Famille createFamille(Famille famille);
    Famille updateFamille(Integer id, Famille famille);
    void deleteFamille(Integer id);
    Famille getFamilleById(Integer id);
    List<Famille> getAllFamilles();
}
