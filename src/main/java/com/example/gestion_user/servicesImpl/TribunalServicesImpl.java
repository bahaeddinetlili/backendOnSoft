package com.example.gestion_user.servicesImpl;

import com.example.gestion_user.entities.Tribunal;
import com.example.gestion_user.repositories.TribunalRepository;
import com.example.gestion_user.services.TribunalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TribunalServicesImpl implements TribunalService {


    @Autowired
    TribunalRepository tribunalRepository ;


    @Override
    public Tribunal addTribunal(Tribunal tribunal) {
        return tribunalRepository.save(tribunal);
    }

    @Override
    public List<Tribunal> retrieveAllTribunaux() {
        return tribunalRepository.findAll();
    }
}
