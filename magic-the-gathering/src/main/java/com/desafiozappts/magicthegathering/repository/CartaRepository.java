package com.desafiozappts.magicthegathering.repository;

import com.desafiozappts.magicthegathering.entity.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CartaRepository extends JpaRepository<Carta, Integer> {


    @Query(value = "SELECT tb_cartas.id, tb_cartas.nome, tb_cartas.edicao, tb_cartas.idioma, tb_cartas.foil, tb_cartas.valor, " +
            "tb_cartas.quantidade, tb_jogadores.jogador_nome FROM tb_cartas INNER JOIN tb_jogadores " +
            "on jogador_cpf = tb_jogadores.cpf", nativeQuery = true)
    List<ListaCartas> listarCartas();

}
