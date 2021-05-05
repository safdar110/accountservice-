package com.itechneer.rasservproj.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
//    @NotBlank
//    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
