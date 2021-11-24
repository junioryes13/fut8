package br.com.fut8.controller;

import br.com.fut8.model.Jogador;
import br.com.fut8.repository.JogadorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import br.com.fut8.controller.DTO.jogadorResponse;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "Jogadores")
@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    JogadorRepository jogadorRepository;

    @ApiOperation(value = "Cadastrar" , nickname = "cadastrar")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public jogadorResponse cadastrar(@RequestBody @Valid JogadorRequest request) {
        Jogador jogador = request.toModel();
        jogadorRepository.save(jogador);

        return new jogadorResponse(jogador) ;
    }

    @ApiOperation(value = "Listar" , nickname = "listarTodas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<jogadorResponse> listar(@RequestBody @Valid JogadorRequest request) {
        List<Jogador> jogadores = (List<Jogador>) jogadorRepository.findAll();
        List<jogadorResponse> jogadoresResponse = new ArrayList<jogadorResponse>();
        for (int i = 0; i >= jogadores.size(); i++) {
            jogadoresResponse.add(new jogadorResponse(jogadores.get(i)));
        }
        return jogadoresResponse;
    }

    @ApiOperation(value = "Listar por id" , nickname = "listarPorId")
    @GetMapping("/{codigo}")
    public jogadorResponse buscarPorId(@PathVariable Long id) {
        Jogador jogadorEncontrado = jogadorRepository.findById(id).orElseThrow();

        return new jogadorResponse(jogadorEncontrado);
    }

    @ApiOperation(value = "Listar por documento" , nickname = "listarPorDocumentos")
    @GetMapping("/{documento}")
    @ResponseStatus(HttpStatus.OK)
    public jogadorResponse buscarPorDocumento(@RequestBody @Valid Long id) {
        Jogador jogadorEncontrado = jogadorRepository.findByDocumento(id).orElseThrow();

        return new jogadorResponse(jogadorEncontrado);
    }
}
