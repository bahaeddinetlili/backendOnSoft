package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Integer> {
    @Query("SELECT d.nomDossier FROM Dossier d")
    List<String> findAllNomDossiers();
    Dossier findByNomDossier(String nomDossier);
    /*@Query("SELECT c.pdfContent FROM Courrier c WHERE c.dossier.idDossier = :idDossier")
    List<byte[]> findPdfsByDossierId(@Param("idDossier") Integer idDossier);*/


}
