package com.example.gestion_user.repositories;

import com.example.gestion_user.entities.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken,Integer> {
    PasswordResetToken findByToken(String token);
    void deleteByToken(String token); // Add this line


}
