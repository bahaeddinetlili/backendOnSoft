package com.example.gestion_user.entities;


import static com.example.gestion_user.entities.Authority.*;

public enum Role {
    ROLE_ADMIN(ADMIN_AUTHORITIES),
    ROLE_CLIENT(CLIENT_AUTHORITIES),
    ROLE_MANAGER(MANAGER_AUTHORITIES);


    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
