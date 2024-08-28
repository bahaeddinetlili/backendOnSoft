package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Tribunal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TribunalRepository extends JpaRepository<Tribunal, Integer> {
}
