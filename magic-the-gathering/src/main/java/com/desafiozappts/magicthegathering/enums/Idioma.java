package com.desafiozappts.magicthegathering.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Idioma {

    ingles ("Ingles"),
    portugues ("Portugues"),
    japones ("Japones");

    private final String descricao;

}
