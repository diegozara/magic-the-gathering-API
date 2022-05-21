package com.desafiozappts.magicthegathering.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_JOGADORES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Jogador {

    @Id
    @CPF(message = "CPF invalido")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String jogadorNome;

}


