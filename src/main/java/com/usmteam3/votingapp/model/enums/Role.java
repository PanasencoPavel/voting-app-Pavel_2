package com.usmteam3.votingapp.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum  Role implements GrantedAuthority {

    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
