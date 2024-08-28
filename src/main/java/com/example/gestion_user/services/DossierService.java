package com.example.gestion_user.services;

import com.example.gestion_user.entities.Dossier;

import java.util.List;

public interface DossierService {

    public List<Dossier> getAllDossiers();
    public void ajouterDossier(Dossier dossier);
    public Dossier retrieveDossier (Integer idDossier);
    public List<String> getNomsDossiers();
    public Dossier getDossierById(Integer idDossier);
    public Dossier updateDossier(Integer idDossier, Dossier dossier);
    public void deleteDossier(Integer idDossier);
    //public void affecterDossierACourrier(String nomDossier, String numeroCourrier);
   // public List<byte[]> getPdfsForDossier(Integer idDossier);


}
