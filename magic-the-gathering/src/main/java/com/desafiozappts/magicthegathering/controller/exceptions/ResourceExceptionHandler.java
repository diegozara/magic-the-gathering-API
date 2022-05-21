package com.desafiozappts.magicthegathering.controller.exceptions;

import com.desafiozappts.magicthegathering.exception.CartaNaoCadastradaException;
import com.desafiozappts.magicthegathering.exception.CpfCadastrado;
import com.desafiozappts.magicthegathering.exception.JogadorNaoCadastradoException;
import com.desafiozappts.magicthegathering.exception.SolicitacaoNegada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(CartaNaoCadastradaException.class)
    public ResponseEntity<ErroPadrao> cartaNaoCadastradaException (CartaNaoCadastradaException e, HttpServletRequest request){

        ErroPadrao erro = new ErroPadrao();

        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setErro("Carta não cadastrada");
        erro.setErro(e.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(SolicitacaoNegada.class)
    public ResponseEntity<ErroPadrao> solicitacaoNegada (SolicitacaoNegada e, HttpServletRequest request){

        ErroPadrao erro = new ErroPadrao();

        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setErro("Solicitação Negada");
        erro.setErro(e.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(JogadorNaoCadastradoException.class)
    public ResponseEntity<ErroPadrao> jogadorNaoCadastradoException (JogadorNaoCadastradoException e, HttpServletRequest request){

        ErroPadrao erro = new ErroPadrao();

        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.NOT_FOUND.value());
        erro.setErro("Jogador não Cadastrado");
        erro.setErro(e.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(CpfCadastrado.class)
    public ResponseEntity<ErroPadrao> cpfCadastrado (CpfCadastrado e, HttpServletRequest request){

        ErroPadrao erro = new ErroPadrao();

        erro.setTimestamp(Instant.now());
        erro.setStatus(HttpStatus.BAD_REQUEST.value());
        erro.setErro("CPF já Cadastrado");
        erro.setErro(e.getMessage());
        erro.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }


}
