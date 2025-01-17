package com.herick.forumHub.domain.topico;

import java.time.LocalDate;

public record DadosCadastroTopico(
        String titulo,
        String mensagem,
        LocalDate dataCriacao,
        EstadoTopico status,
        Long autor,
        Long curso
) {
    public DadosCadastroTopico(String titulo, String mensagem, EstadoTopico status, Long autor, Long curso) {
        this(titulo, mensagem, LocalDate.now(), status, autor, curso);
    }
}
