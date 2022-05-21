package com.desafiozappts.magicthegathering.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SolicitacaoNegada extends Throwable {

    public SolicitacaoNegada(){
        super("Solicitação negada, Voce não é o proprietário da carta");
    }

}
