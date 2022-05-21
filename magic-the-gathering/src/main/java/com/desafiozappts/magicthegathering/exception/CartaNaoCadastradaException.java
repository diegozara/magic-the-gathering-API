package com.desafiozappts.magicthegathering.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartaNaoCadastradaException extends Throwable {

    public CartaNaoCadastradaException (Integer id){
        super("Carta nao cadastrada com id: "+ id);
    }

    public CartaNaoCadastradaException (){
        super("Nenhuma Carta cadastrada, por favor cadastre uma carta e tente novamente");
    }

}
