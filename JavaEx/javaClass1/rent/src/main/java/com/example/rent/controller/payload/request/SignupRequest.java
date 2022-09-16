package com.example.rent.controller.payload.request;

import java.util.Set;

public class SignupRequest {
    private String username;
    private String password;
    private String email;
    Set<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getRole() {
        return roles;
    }

    public void setRole(Set<String> roles) {
        this.roles = roles;
    }
}
