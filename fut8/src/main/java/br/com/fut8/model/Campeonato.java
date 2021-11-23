package br.com.fut8.model;

import javax.validation.constraints.Max;
import java.time.LocalDateTime;
import java.util.List;

public class Campeonato {

    private String nome;

    @Max(20)
    private List<Time>times;


    private int rodadas;

    private LocalDateTime dataCriação;

    private int rodadaAtual;

    public Campeonato(List<Time> times, int rodadas) {
        this.times = times;
        this.rodadas = rodadas;
    }
}
