package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Affaire;
import com.example.gestion_user.entities.Tribunal;
import com.example.gestion_user.repositories.AffaireRepository;
import com.example.gestion_user.repositories.TribunalRepository;
import com.example.gestion_user.services.AffaireService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AffaireServicesImpl implements AffaireService {

    @Autowired
    AffaireRepository affaireRepository ;

    @Autowired
    TribunalRepository tribunalRepository ;

   @Override
    public Affaire addAffaire(Affaire affaire) {
        return affaireRepository.save(affaire) ;
    }
   /* public Affaire addAffaire(Affaire affaire, Integer idTribunal) {
        Tribunal tribunal = tribunalRepository.findById(idTribunal).orElse(null);
        if (tribunal != null) {
            affaire.setTribunal(tribunal);
            tribunal.getAffaires().add(affaire);
            affaireRepository.save(affaire);
            tribunalRepository.save(tribunal);
            return affaire;
        }
        return null;
    }*/
    @Override
    public List<Affaire> retrieveAllAffaires() {
        return affaireRepository.findAll();
    }

    @Override
    public Affaire updateAffaire(Affaire affaire) {
        return affaireRepository.save(affaire);
    }

    @Override
    public void removeAffaire(Integer idAffaire) {
        affaireRepository.deleteById(idAffaire);
    }

    @Override
    public Affaire retrieveAffaire(Integer idAffaire) {
        return affaireRepository.findById(idAffaire).get() ;
    }

    @Override
    public List<Affaire> searchAffaireByTitre(String titreAffaire) {
        return affaireRepository.findByTitre(titreAffaire);
    }
}
