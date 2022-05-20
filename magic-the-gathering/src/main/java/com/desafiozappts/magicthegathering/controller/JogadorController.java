package com.desafiozappts.magicthegathering.controller;


import com.desafiozappts.magicthegathering.entity.Jogador;
import com.desafiozappts.magicthegathering.exception.JogadorNaoCadastradoException;
import com.desafiozappts.magicthegathering.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jogadores")
public class JogadorController {

    private JogadorService jogadorService;

    @Autowired
    private JogadorController(JogadorService jogadorService){this.jogadorService = jogadorService;}

    @GetMapping
    public List<Jogador> listarJogadores (){

        return jogadorService.listarJogadores();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogador inserirJogador (@RequestBody @Validated Jogador jogador){

        return jogadorService.inserJogador(jogador);
    }

    @PutMapping ("/{cpf}")
    public Jogador atualizarJogador (@PathVariable String cpf ,@RequestBody @Validated Jogador jogador) throws JogadorNaoCadastradoException {
        return jogadorService.atualizarJogador(cpf,jogador);
    }

}
