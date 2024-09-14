package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Famille;
import com.example.gestion_user.repositories.FamilleRepository;
import com.example.gestion_user.services.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FamilleServiceImpl implements FamilleService {

    @Autowired
    private FamilleRepository familleRepository;

    @Override
    public Famille createFamille(Famille famille) {
        return familleRepository.save(famille);
    }

    @Override
    public Famille updateFamille(Integer id, Famille famille) {
        Optional<Famille> existingFamille = familleRepository.findById(id);
        if (existingFamille.isPresent()) {
            Famille updatedFamille = existingFamille.get();
            updatedFamille.setLibelle(famille.getLibelle());
            return familleRepository.save(updatedFamille);
        } else {
            throw new RuntimeException("Famille not found with ID: " + id);
        }
    }

    @Override
    public void deleteFamille(Integer id) {
        familleRepository.deleteById(id);
    }

    @Override
    public Famille getFamilleById(Integer id) {
        return familleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Famille not found with ID: " + id));
    }

    @Override
    public List<Famille> getAllFamilles() {
        return familleRepository.findAll();
    }
}
