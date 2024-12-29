package com.herick.forumHub.domain.topico;

import java.time.LocalDate;

public record DadosTopicoRegistrado(
        Long id,
        String titulo,
        String mensagem,
        LocalDate dataCriacao,
        EstadoTopico status,
        Long autor,
        Long curso
) {
    public DadosTopicoRegistrado(TopicoModel topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }

}
