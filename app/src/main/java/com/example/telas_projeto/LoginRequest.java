package com.example.telas_projeto;

public class LoginRequest {
    private String nomeUsuario;
    private String senha;

    public LoginRequest(String username, String password) {
        this.nomeUsuario = username;
        this.senha = password;
    }

    public String getUsername() {
        return nomeUsuario;
    }

    public String getPassword() {
        return senha;
    }
}
