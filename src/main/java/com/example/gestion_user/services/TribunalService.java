package com.example.gestion_user.services;

import com.example.gestion_user.entities.Tribunal;

import java.util.List;

public interface TribunalService {

    Tribunal addTribunal(Tribunal tribunal) ;
    List<Tribunal> retrieveAllTribunaux() ;

}
