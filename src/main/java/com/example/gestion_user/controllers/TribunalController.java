package com.example.gestion_user.controllers;

import com.example.gestion_user.entities.Tribunal;
import com.example.gestion_user.services.TribunalService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Tribunal")
public class TribunalController {

    @Autowired
    TribunalService tribunalService ;

    @GetMapping("/retrieve-all-tribunaux")
    public List<Tribunal> getTribunaux() {
        List<Tribunal> listTribunaux = tribunalService.retrieveAllTribunaux();
        return listTribunaux;
    }

    @PostMapping("/add-tribunal")
    public Tribunal addTribunal(@RequestBody Tribunal t){
        Tribunal tribunal = tribunalService.addTribunal(t);
        return tribunal;
    }
}
