package com.example.gestion_user.controllers;

import com.example.gestion_user.entities.Famille;
import com.example.gestion_user.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familles")
public class FamilleController {

    @Autowired
    private FamilleService familleService;

    // Créer une nouvelle famille
    @PostMapping("/create")
    public ResponseEntity<Famille> createFamille(@RequestBody Famille famille) {
        Famille newFamille = familleService.createFamille(famille);
        return ResponseEntity.ok(newFamille);
    }

    // Mettre à jour une famille existante
    @PutMapping("/update/{id}")
    public ResponseEntity<Famille> updateFamille(
            @PathVariable("id") Integer id,
            @RequestBody Famille famille) {
        Famille updatedFamille = familleService.updateFamille(id, famille);
        return ResponseEntity.ok(updatedFamille);
    }

    // Supprimer une famille
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFamille(@PathVariable("id") Integer id) {
        familleService.deleteFamille(id);
        return ResponseEntity.noContent().build();
    }

    // Récupérer une famille par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Famille> getFamilleById(@PathVariable("id") Integer id) {
        Famille famille = familleService.getFamilleById(id);
        return ResponseEntity.ok(famille);
    }

    // Récupérer toutes les familles
    @GetMapping("/all")
    public ResponseEntity<List<Famille>> getAllFamilles() {
        List<Famille> familles = familleService.getAllFamilles();
        return ResponseEntity.ok(familles);
    }

}