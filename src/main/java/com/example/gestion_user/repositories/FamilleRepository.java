package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille,Integer> {
}
