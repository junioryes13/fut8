package br.com.fut8.controller;

import br.com.fut8.model.Jogador;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

public class JogadorRequest {


    @NotBlank
    private String nome;

    @NotBlank
    private String documento;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

    @Past
    private LocalDateTime dataNasc;


    public JogadorRequest(String nome, String documento, String email, String senha, LocalDateTime dataNasc) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataNasc() {
        return dataNasc;
    }

    public Jogador toModel() {
        return new Jogador(this.nome,this.documento,this.email,this.senha,this.dataNasc);
    }
}
