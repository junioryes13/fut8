package br.com.fut8.controller.DTO;

import br.com.fut8.model.Jogador;

import java.time.LocalDateTime;

public class jogadorResponse {

    private String nome;
    private String email;
    private LocalDateTime dataCriação;


    public jogadorResponse(Jogador jogador) {
        this.nome = jogador.getNome();
        this.email = jogador.getEmail();
        this.dataCriação = jogador.getDataCriacao();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataCriação() {
        return dataCriação;
    }
}
