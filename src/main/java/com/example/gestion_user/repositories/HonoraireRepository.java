package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Honoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HonoraireRepository extends JpaRepository <Honoraire, Integer> {
}
