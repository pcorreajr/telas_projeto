package com.example.telas_projeto;

import java.util.Date;

public class DadosLogin {
    private int seqLogin;
    private String login;
    private String senha;
    private String loginAlteracao;
    private String loginCadastro;
    private Date dtaCriacao;
    private Date dtaAlteracao;

    public DadosLogin(int seqLogin, String login, String senha, String loginAlteracao, String loginCadastro, Date dtaCriacao, Date dtaAlteracao) {
        this.seqLogin = seqLogin;
        this.login = login;
        this.senha = senha;
        this.loginAlteracao = loginAlteracao;
        this.loginCadastro = loginCadastro;
        this.dtaCriacao = dtaCriacao;
        this.dtaAlteracao = dtaAlteracao;
    }

    public int getSeqLogin() {
        return seqLogin;
    }

    public void setSeqLogin(int seqLogin) {
        this.seqLogin = seqLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLoginAlteracao() {
        return loginAlteracao;
    }

    public void setLoginAlteracao(String loginAlteracao) {
        this.loginAlteracao = loginAlteracao;
    }

    public String getLoginCadastro() {
        return loginCadastro;
    }

    public void setLoginCadastro(String loginCadastro) {
        this.loginCadastro = loginCadastro;
    }

    public Date getDtaCriacao() {
        return dtaCriacao;
    }

    public void setDtaCriacao(Date dtaCriacao) {
        this.dtaCriacao = dtaCriacao;
    }

    public Date getDtaAlteracao() {
        return dtaAlteracao;
    }

    public void setDtaAlteracao(Date dtaAlteracao) {
        this.dtaAlteracao = dtaAlteracao;
    }
}
