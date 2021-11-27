package br.com.fut8.controller.DTO;

import br.com.fut8.annotations.isUnique;
import br.com.fut8.model.Jogador;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

public class JogadorRequest {


    @NotBlank
    private String nome;

    @NotBlank
    @CPF
    @isUnique(fieldName = "CPF", domainClass = Jogador.class, message = "CPF já cadastrado no banco de dados")
    private String CPF;

    @NotBlank
    @Email
    @isUnique(fieldName = "email", domainClass = Jogador.class, message = "Email já cadastrado no banco de dados")
    private String email;

    @NotBlank
    private String senha;

    @Past
    @NotNull
    private LocalDateTime dataNasc;


    public JogadorRequest(String nome, String documento, String email, String senha, LocalDateTime dataNasc) {
        this.nome = nome;
        this.CPF = documento;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
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

    public Jogador toModel() {
        return new Jogador(this.nome,this.CPF,this.email,this.senha,this.dataNasc);
    }
}
