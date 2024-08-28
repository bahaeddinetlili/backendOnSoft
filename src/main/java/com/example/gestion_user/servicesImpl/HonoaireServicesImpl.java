package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Affaire;
import com.example.gestion_user.entities.Honoraire;
import com.example.gestion_user.repositories.AffaireRepository;
import com.example.gestion_user.repositories.HonoraireRepository;
import com.example.gestion_user.services.HonoraireService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@AllArgsConstructor
@Service
public class HonoaireServicesImpl implements HonoraireService {

    @Autowired
    HonoraireRepository honoraireRepository ;

    @Autowired
    AffaireRepository affaireRepository ;

    @Override
    public Honoraire addHonoraire(Honoraire honoraire) {
        return honoraireRepository.save(honoraire);
    }

    @Override
    public List<Honoraire> retrieveAllHonoraires() {
        return honoraireRepository.findAll();
    }

    @Override
    public Honoraire updateHonoraire(Honoraire honoraire) {
        return honoraireRepository.save(honoraire);
    }

    @Override
    public void removeHonoraire(Integer idHonoraire) {
        honoraireRepository.deleteById(idHonoraire);

    }

    @Override
    public Honoraire retrieveHonoraire(Integer idHonoraire) {
        return honoraireRepository.findById(idHonoraire).get() ;
    }

    @Override
    public void addHonoraireAndAffectToAffaire(Honoraire honoraire, Integer idAffaire) {
        Affaire affaire = affaireRepository.findById(idAffaire).orElse(null);
        honoraire.setAffaire(affaire);
        honoraireRepository.save(honoraire);

    }

    public byte[] generateQRCodeForHonoraire(Integer idHonoraire) throws Exception {
        Honoraire honoraire = honoraireRepository.findById(idHonoraire).orElse(null);
        if (honoraire == null) {
            throw new Exception("Honoraire not found");
        }

        // Création du contenu du QR code
        String qrCodeContent =
                "\nHonoraire : "
                        + "\nMontant: " + honoraire.getMontant()
                        + "\nDate: " + honoraire.getDate()
                        + "\nTitre: " + honoraire.getTitre()
                        + "\nType: " + honoraire.getType()
                        + "\nReste: " + honoraire.getReste();

        // Génération du QR code
        //Ecrire les données d'image générées dans un tableau de bytes.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //Encodage des données
        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, 250, 250);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", baos);
        //convertire le contenu de l'objet en tableau de byes
        return baos.toByteArray();
    }
}
