package com.desafiozappts.magicthegathering.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErroPadrao {

    private Instant timestamp;
    private Integer status;
    private String erro;
    private String menssagem;
    private String path;
}
