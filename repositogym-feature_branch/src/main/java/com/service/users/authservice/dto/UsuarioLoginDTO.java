package com.service.users.authservice.dto;

public class UsuarioLoginDTO {

  
    private String email;

    
    private String password;

    
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
