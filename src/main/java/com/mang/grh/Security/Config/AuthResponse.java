package com.mang.grh.Security.config;

import lombok.Data;

import java.util.List;

@Data
public class AuthResponse {
    private String Status;
    private String Message;
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private List<String> roles;
}
