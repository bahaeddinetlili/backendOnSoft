package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.*;
import com.example.gestion_user.repositories.DossierRepository;
import com.example.gestion_user.repositories.UserRepository;
import com.example.gestion_user.services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DossierServiceImpl implements DossierService {

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private UserRepository userRepository;




    @Override
    public List<Dossier> getAllDossiers() {
        return dossierRepository.findAll();
    }

    @Override
    public void ajouterDossier(Dossier dossier) {
        //Session
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Utilisateur non trouvé: " + username);
        }

        dossier.setEtatDossier(EtatDossier.NON_ARCHIVE);
        dossier.setUser(user);
        dossierRepository.save(dossier);
    }

    @Override
    public Dossier retrieveDossier(Integer idDossier) {
        return dossierRepository.findById(idDossier).orElse(null);
    }

    @Override
    public List<String> getNomsDossiers() {
        return dossierRepository.findAllNomDossiers();
    }

    @Override
    public Dossier getDossierById(Integer idDossier) {
        Dossier dossier = dossierRepository.findById(idDossier).orElse(null);
        return dossier;
    }

    @Override
    public Dossier updateDossier(Integer idDossier, Dossier dossier) {

        Dossier dossier1 = dossierRepository.findById(idDossier).orElse(null);

        dossier1.setNomDossier(dossier.getNomDossier());
        dossier1.setEtatDossier(dossier.getEtatDossier());

        return dossierRepository.save(dossier1);
    }

    @Override
    public void deleteDossier(Integer idDossier) {
        dossierRepository.deleteById(idDossier);
    }

    /*@Override
    public void affecterDossierACourrier(String nomDossier, String numeroCourrier) {
        Dossier dossier = dossierRepository.findByNomDossier(nomDossier);
        Courrier courrier = courrierRepository.findByNumeroCourrier(numeroCourrier);

            courrier.setDossier(dossier);
            courrierRepository.save(courrier);
    }*/

    /*@Override
    public List<byte[]> getPdfsForDossier(Integer idDossier) {
        return dossierRepository.findPdfsByDossierId(idDossier);
    }*/


}
