package com.root.task_management.security.jwt;

import lombok.Data;

@Data
public class AuthResponse {

    private String jwtToken;
    private String username;

    public AuthResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }
}
