package br.com.fut8.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @FutureOrPresent
    private LocalDateTime dataCriacao;

    public Jogador(String nome, String documento, String email, String senha, LocalDateTime dataNasc) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
}
