package com.desafiozappts.magicthegathering.repository;

import com.desafiozappts.magicthegathering.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JogadorRepository extends JpaRepository<Jogador, String> {
}
