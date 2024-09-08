package com.example.gestion_user.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String profileImage;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private String role; //ADMIN, MANAGER
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;
    private Instant tokenExpirationTime;
    private String resetToken;

    // Getter and Setter for resetToken
    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    // Getter and Setter for tokenExpirationTime
    public Instant getTokenExpirationTime() {
        return tokenExpirationTime;
    }

    public void setTokenExpirationTime(Instant tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }





}
