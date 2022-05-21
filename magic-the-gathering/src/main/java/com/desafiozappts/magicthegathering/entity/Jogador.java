package com.desafiozappts.magicthegathering.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

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

  /*  @OneToMany (cascade = CascadeType.ALL, mappedBy = "jogador")
    private List<Carta> carta;*/

}


