package com.herick.forumHub.domain.topico;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity(name = "topicos")
public class TopicoModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String titulo;
    private String mensagem;
    private LocalDate dataCriacao;
    private EstadoTopico status;
    private UUID autor; // TODO - Alterar para o tipo autor e fazer o Embedded
    private UUID curso; // TODO - Alterar para o tipo curso e fazer o Embedded

}
