package com.desafiozappts.magicthegathering.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JogadorNaoCadastradoException extends Throwable {

    public JogadorNaoCadastradoException(){
        super("Jogador nao cadastrado");
    }

}
