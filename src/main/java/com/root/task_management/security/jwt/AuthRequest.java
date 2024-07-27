package com.root.task_management.security.jwt;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;

}
