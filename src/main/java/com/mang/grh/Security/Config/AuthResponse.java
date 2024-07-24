package com.mang.grh.Security.config;

import lombok.Data;

@Data
public class AuthResponse {
    private String Status;
    private String Message;
    private String token;
}
