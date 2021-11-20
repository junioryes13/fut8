package java.br.com.fut8.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class Time {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private List<Jogador> jogadores;

    private int saldoDeGols;

    private int golsSofridos;

    private int golsMarcados;
    
    int pontos;

    public Time(String nome, List<Jogador> jogadores) {
        this.nome = nome;
        this.jogadores = jogadores;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public int getSaldoDeGols() {
        return saldoDeGols;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }
}
