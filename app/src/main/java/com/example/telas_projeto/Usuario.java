package com.example.telas_projeto;
public class Usuario {
    private int id;
    private String name;
    private String password;

    public Usuario(int usuarioId, String nomeUsuario, String senha) {
        this.id = usuarioId;
        this.name = nomeUsuario;
        this.password = senha;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSenha() {
        return password;
    }

}
