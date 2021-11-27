package br.com.fut8.controller;

import br.com.fut8.controller.DTO.JogadorRequest;
import br.com.fut8.controller.DTO.jogadorResponse;
import br.com.fut8.model.Jogador;
import br.com.fut8.repository.JogadorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "Jogadores")
@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    JogadorRepository jogadorRepository;

    @Transactional
    @ApiOperation(value = "Cadastrar", nickname = "cadastrar")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public jogadorResponse cadastrar(@RequestBody @Valid JogadorRequest request) {
        Jogador jogador = request.toModel();
        jogadorRepository.save(jogador);

        return new jogadorResponse(jogador) ;
    }

    @ApiOperation(value = "Listar", nickname = "listarTodas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<jogadorResponse> listar() {
        List<Jogador> jogadores = jogadorRepository.findAll();
        List<jogadorResponse> jogadoresResponse = new ArrayList<>();
        if (jogadores.isEmpty()) {
            return jogadoresResponse;
        }
        jogadoresResponse = new ArrayList<jogadorResponse>();
        for (int i = 0; i < jogadores.size(); i++) {
            jogadoresResponse.add(new jogadorResponse(jogadores.get(i)));

        }
        return jogadoresResponse;
    }

    @ApiOperation(value = "Listar por id", nickname = "listarPorId")
    @GetMapping("/{id}")
    public jogadorResponse buscarPorId(@PathVariable Long id) {
        Jogador jogadorEncontrado = jogadorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Jogador não encontrado no banco de dados"));;

        return new jogadorResponse(jogadorEncontrado);
    }

    @ApiOperation(value = "Listar por documento", nickname = "listarPorDocumentos")
    @GetMapping("/documento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public jogadorResponse buscarPorDocumento(@PathVariable String id) {
        Jogador jogadorEncontrado = jogadorRepository.findByCPF(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Jogador não encontrado no banco de dados"));
        return new jogadorResponse(jogadorEncontrado);
    }
}
