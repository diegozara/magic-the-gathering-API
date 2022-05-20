package com.desafiozappts.magicthegathering.entity;

import lombok.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Table(name = "TB_JOGADOR")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Jogador {

    @Id
    @CPF(message = "CPF invalido")
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String Nome;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "jogador")
    private List<Carta> carta;

}


