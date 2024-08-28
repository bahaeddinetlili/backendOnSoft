package com.example.gestion_user.controllers;


import com.example.gestion_user.entities.Honoraire;
import com.example.gestion_user.services.HonoraireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Honoraire")
public class HonoraireController {

    @Autowired
    HonoraireService honoraireService ;

    @GetMapping("/retrieve-all-honoraires")
    public List<Honoraire> getHonoraire() {
        List<Honoraire> listHonoraires = honoraireService.retrieveAllHonoraires();
        return listHonoraires;
    }
    @GetMapping("/retrieve-honoraire/{honoraire-id}")
    public Honoraire retrieveHonoraire(@PathVariable("honoraire-id") Integer honoraireId){
        return honoraireService.retrieveHonoraire(honoraireId);
    }
    @PostMapping("/add-honoraire")
    public Honoraire addHonoraire(@RequestBody Honoraire a){
        Honoraire honoraire = honoraireService.addHonoraire(a);
        return honoraire;
    }

    @PutMapping("/update-honoraire")
    public Honoraire updateHonoraire(@RequestBody Honoraire a){
        Honoraire honoraire = honoraireService.updateHonoraire(a);
        return honoraire ;
    }

    @DeleteMapping("/remove-honoraire/{honoraire-id}")
    public void removeHonoraire(@PathVariable("honoraire-id")Integer honoraireId) {
        honoraireService.removeHonoraire(honoraireId);
    }

    @PostMapping("/addHonnoraireAndAffectToAffaire/{affaire-id}")
    public void addHonnoraireAndAffectToAffaire (@RequestBody Honoraire honoraire , @PathVariable("affaire-id") Integer idAffaire ){
        honoraireService.addHonoraireAndAffectToAffaire(honoraire, idAffaire);

    }

    @GetMapping("generateQRCodeForHonoraire/{id-honoraire}")
    public ResponseEntity<byte[]> generateQRCodeForHonoraire(@PathVariable("id-honoraire") Integer idHonoraire) {
        try {
            byte[] qrCode = honoraireService.generateQRCodeForHonoraire(idHonoraire);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
