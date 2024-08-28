package com.example.gestion_user.controllers;

import com.example.gestion_user.entities.Dossier;
import com.example.gestion_user.services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class DossierController {

    @Autowired
    DossierService dossierService;

    @GetMapping("/list-dossiers")
    public ResponseEntity<List<Dossier>> getDepartsExternes() {
        List<Dossier> dossiers = dossierService.getAllDossiers();
        return ResponseEntity.ok(dossiers);
    }

    @PostMapping("/ajouter-dossier")
    public void ajouterDossier(@RequestBody Dossier dossier) {
        dossierService.ajouterDossier(dossier);
    }

    @GetMapping("/retrieve-dossier/{id-dossier}")
    public Dossier retrieveDossier(@PathVariable("id-dossier") Integer idDossier) {
        return dossierService.retrieveDossier(idDossier);
    }

    @GetMapping("/get-noms-dossiers")
    public List<String> listeDesNomsDossiers() {
        return dossierService.getNomsDossiers();
    }

    @GetMapping("/getDossierById/{id-dossier}")
    public Dossier getDossierById(@PathVariable("id-dossier") Integer idDossier) {
        return dossierService.getDossierById(idDossier);
    }

    @PutMapping("/update-dossier/{id-dossier}")
    public Dossier updateDossier(@PathVariable("id-dossier") Integer idDossier, @RequestBody Dossier dossier) {
        return dossierService.updateDossier(idDossier, dossier);
    }

    @DeleteMapping("/delete-dossier/{id-dossier}")
    public void deleteDossier(@PathVariable("id-dossier") Integer idDossier) {
        dossierService.deleteDossier(idDossier);
    }

    /*@PutMapping("/affect-dossier-courrier/{nom-dossier}/{numero-courrier}")
    public void affecterDossierACourrier(@PathVariable("nom-dossier") String nomDossier,
                                         @PathVariable("numero-courrier") String numeroCourrier){
        dossierService.affecterDossierACourrier(nomDossier,numeroCourrier);
    }*/

   /* @GetMapping("/getPdfs/{id-dossier}")
    public ResponseEntity<List<byte[]>> getPdfsByDossierId(@PathVariable("id-dossier") Integer idDossier) {
        List<byte[]> pdfs = dossierService.getPdfsForDossier(idDossier);
        return ResponseEntity.ok(pdfs);
    }*/


}
