package com.desafiozappts.magicthegathering.repository;

import com.desafiozappts.magicthegathering.entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartaRepository extends JpaRepository<Carta, Integer> {
}
