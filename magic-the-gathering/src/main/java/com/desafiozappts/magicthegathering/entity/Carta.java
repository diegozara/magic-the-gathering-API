package com.desafiozappts.magicthegathering.entity;

import com.desafiozappts.magicthegathering.enums.Idioma;
import lombok.*;

import javax.persistence.*;

@Entity
@Table (name = "TB_CARTAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private String nome;

    @Column (nullable = false)
    private String edicao;

    @Enumerated (EnumType.STRING)
    private Idioma idioma;

    @Column (nullable = false)
    private String foil;

    @Column (nullable = false)
    private Double valor;

    @Column (nullable = false)
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogador_cpf")
    private Jogador jogador;

}
