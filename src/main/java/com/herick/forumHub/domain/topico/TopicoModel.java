package com.herick.forumHub.domain.topico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.time.LocalDate;



@Entity(name = "topicos")
@AllArgsConstructor
@NoArgsConstructor
public class TopicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDate dataCriacao;
    private EstadoTopico status;
    private Long autor; // TODO - Alterar para o tipo autor e fazer o Embedded
    private Long curso; // TODO - Alterar para o tipo curso e fazer o Embedded

    public TopicoModel(DadosCadastroTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDate.now();
        this.status = dados.status();
        this.autor = dados.autor();
        this.curso = dados.curso();
    }

}
