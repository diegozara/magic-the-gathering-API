package com.desafiozappts.magicthegathering.controller;


import com.desafiozappts.magicthegathering.entity.Carta;
import com.desafiozappts.magicthegathering.exception.CartaNaoCadastradaException;
import com.desafiozappts.magicthegathering.exception.JogadorNaoCadastradoException;
import com.desafiozappts.magicthegathering.exception.SolicitacaoNegada;
import com.desafiozappts.magicthegathering.repository.ListaCartas;
import com.desafiozappts.magicthegathering.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cartas")
public class CartaController {

    private CartaService cartaService;

    @Autowired
    public CartaController(CartaService cartaService) {
        this.cartaService = cartaService;
    }

    @GetMapping
    public List<ListaCartas> listarTodasCartas (){

        return cartaService.listarTodasCartas();
    }


    @GetMapping("/valor")
    public List<ListaCartas> listarCartasOrdemPreco () throws CartaNaoCadastradaException {

       return cartaService.listarCartasOrdemPreco();
    }

    @GetMapping ("/nome")
    public List<ListaCartas> listarCartasOrdemAlfabetica () throws CartaNaoCadastradaException {

        return cartaService.listarCartasOrdemAlfabetica();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carta inserir (@RequestBody @Validated Carta carta) throws JogadorNaoCadastradoException {
        return cartaService.inserir(carta);
    }

    @PutMapping ("/{cpf}/{id}")
    public Carta atualizar (@PathVariable String cpf, @PathVariable Integer id, @RequestBody @Validated Carta carta) throws CartaNaoCadastradaException, JogadorNaoCadastradoException, SolicitacaoNegada {
        return cartaService.atualizar(cpf,id,carta);
    }

    @DeleteMapping ("/{cpf}/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCarta (@PathVariable String cpf, @PathVariable Integer id) throws CartaNaoCadastradaException, SolicitacaoNegada {
        cartaService.excluirCarta(cpf,id);
    }
}
