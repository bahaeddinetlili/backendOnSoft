package com.example.gestion_user.services;

import com.example.gestion_user.entities.Client;

import java.util.List;

public interface ClientService {
    Client save(Client client);

    Client findById(Integer id);

    List<Client> findAll();

    void delete(Integer id);
}
