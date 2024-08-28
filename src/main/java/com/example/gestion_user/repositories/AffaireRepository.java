package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Affaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AffaireRepository extends JpaRepository <Affaire, Integer> {

    List<Affaire> findByTitre(String titreAffaire);
}
