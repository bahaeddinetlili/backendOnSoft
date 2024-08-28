package com.example.gestion_user.controllers;

import com.example.gestion_user.entities.Affaire;
import com.example.gestion_user.services.AffaireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Affaire")
public class AffaireController {

    @Autowired
    AffaireService affaireService ;

    @GetMapping("/retrieve-all-affaires")
    public List<Affaire> getAffaire() {
        List<Affaire> listAffaires = affaireService.retrieveAllAffaires();
        return listAffaires;
    }

    @GetMapping("/retrieve-affaire/{affaire-id}")
    public Affaire retrieveAffaire(@PathVariable("affaire-id") Integer affaireId){
        return affaireService.retrieveAffaire(affaireId);
    }

    @PostMapping("/add-affaire")
    public Affaire addAffaire(@RequestBody Affaire affaire) {
        return affaireService.addAffaire(affaire);

    }


    @PutMapping("/update-affaire")
    public Affaire updateAffaire(@RequestBody Affaire a){
        Affaire affaire = affaireService.updateAffaire(a);
        return affaire ;
    }

    @DeleteMapping("/remove-affaire/{affaire-id}")
    public void removeAffaire(@PathVariable("affaire-id") Integer affaireId) {
        affaireService.removeAffaire(affaireId);
    }

    @GetMapping("search-affaire-by-titre/{titreAffaire}")
    public ResponseEntity<List<Affaire>> searchAffaireByTitre(@PathVariable String titreAffaire) {
        List<Affaire> affaires = affaireService.searchAffaireByTitre(titreAffaire);
        return ResponseEntity.ok().body(affaires);
    }

}
