package com.desafiozappts.magicthegathering.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfCadastrado extends Throwable {

    public CpfCadastrado(){
        super("CPF ja cadastrado");
    }

}
