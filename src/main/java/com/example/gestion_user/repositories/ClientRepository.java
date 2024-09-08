package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
