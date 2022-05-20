package com.desafiozappts.magicthegathering.service;


import com.desafiozappts.magicthegathering.controller.JogadorController;
import com.desafiozappts.magicthegathering.entity.Jogador;
import com.desafiozappts.magicthegathering.exception.CartaNaoCadastradaException;
import com.desafiozappts.magicthegathering.exception.JogadorNaoCadastradoException;
import com.desafiozappts.magicthegathering.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private JogadorRepository jogadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public List<Jogador> listarJogadores (){

        return jogadorRepository.findAll();
    }

    public Jogador inserJogador (Jogador jogador){

        return jogadorRepository.save(jogador);
    }

    public Jogador atualizarJogador (String cpf, Jogador jogador) throws JogadorNaoCadastradoException {

        jogadorRepository.findById(cpf).orElseThrow(() -> new JogadorNaoCadastradoException());
        jogador.setCpf(cpf);

        return jogadorRepository.save(jogador);
    }

/*
    public void excluirJogador (Integer cpf) throws JogadorNaoCadastradoException {

        verificarExistenciaJogador(cpf);
        jogadorRepository.deleteById(cpf);

    }
*/

    public Jogador verificarExistenciaJogador (String cpf) throws JogadorNaoCadastradoException {

        return jogadorRepository.findById(cpf)
                .orElseThrow(()-> new JogadorNaoCadastradoException());
    }
}
