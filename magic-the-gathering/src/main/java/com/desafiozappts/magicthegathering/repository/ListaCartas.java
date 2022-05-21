package com.desafiozappts.magicthegathering.repository;

import io.swagger.annotations.ApiOperation;

@ApiOperation(value = "Interface de projeção do JPA, utilizada para não retornar o CPF dos jogadores na lista de cartas")
public interface ListaCartas {

    Integer getid();
    String getnome();
    String getedicao();
    String getidioma();
    String getfoil();
    Double getvalor();
    Integer getquantidade();

    String getjogador_nome();

}
