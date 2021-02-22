package com.domowka.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDTO {
    private String username;
    private String password;

    public LoginDTO(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

}
