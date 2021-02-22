package com.domowka.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class LoginResponseDTO {
    private UUID userId;
    private String token;
    private String refreshToken;
    public LoginResponseDTO(UUID userId, String token, String refreshToken) {
        this.userId = userId;
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
