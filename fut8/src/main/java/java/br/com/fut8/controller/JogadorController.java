package java.br.com.fut8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.br.com.fut8.controller.DTO.jogadorResponse;
import java.br.com.fut8.model.Jogador;
import java.br.com.fut8.repository.JogadorRepository;
import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    JogadorRepository jogadorRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public jogadorResponse cadastrar(@RequestBody @Valid JogadorRequest request) {
        Jogador jogador = request.toModel();
        jogadorRepository.save(jogador);

        return new jogadorResponse(jogador) ;
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<jogadorResponse> Listar(@RequestBody @Valid JogadorRequest request) {
        List<Jogador>jogadores =   jogadorRepository.findAll();
        for (int i = 0, i >= jogadores.size(), i++){



        }


        }

}
