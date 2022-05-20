package com.desafiozappts.magicthegathering.controller;


import com.desafiozappts.magicthegathering.entity.Carta;
import com.desafiozappts.magicthegathering.exception.CartaNaoCadastradaException;
import com.desafiozappts.magicthegathering.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cartas")
public class CartaCrontroller {

    private CartaService cartaService;

    @Autowired
    public CartaCrontroller(CartaService cartaService) {
        this.cartaService = cartaService;
    }


    @GetMapping("/valor")
    public List<Carta> listarCartasOrdemPreco () {

       return cartaService.listarCartasOrdemPreco();
    }

    @GetMapping ("/nome")
    public List<Carta> listarCartasOrdemAlfabetica (){

        return cartaService.listarCartasOrdemAlfabetica();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carta inserir (@RequestBody @Validated Carta carta) {
        return cartaService.inserir(carta);
    }

    @PutMapping ("/{id}")
    public Carta atualizar (@PathVariable Integer id, @RequestBody @Validated Carta carta) throws CartaNaoCadastradaException {
        return cartaService.atualizar(id,carta);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCarta (@PathVariable Integer id) throws CartaNaoCadastradaException {
        cartaService.excluirCarta(id);
    }
}
