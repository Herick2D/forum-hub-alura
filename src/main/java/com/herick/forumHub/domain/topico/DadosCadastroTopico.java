package com.herick.forumHub.domain.topico;

import java.time.LocalDate;

public record DadosCadastroTopico(
        String titulo,
        String mensagem,
        LocalDate dataCriacao,
        EstadoTopico status,
        Long autor,
        Long curso
) {}
