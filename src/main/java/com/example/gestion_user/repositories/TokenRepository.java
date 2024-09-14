package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Long> {
    Optional<Token> findByToken(String token);
    void deleteByToken(String token);
}
