package br.com.fut8.model;

import br.com.fut8.annotations.isUnique;
import br.com.fut8.util.Encrypt;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    private String CPF;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;

    @Past
    @NotNull
    private LocalDateTime dataNasc;

    private LocalDateTime dataCriacao;

    public Jogador(String nome, String documento, String email, String senha, LocalDateTime dataNasc) {
        this.nome = nome;
        this.CPF = documento;
        this.email = email;
        this.senha = Encrypt.encrypt(documento);
        this.dataNasc = dataNasc;
        this.dataCriacao = LocalDateTime.now();
    }

    @Deprecated
    public Jogador() {
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

    public String getCPF() {
        return CPF;
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
