package com.herick.forumHub.domain.topico;

import java.time.LocalDate;

public record DadosListagemTopico(
        String titulo,
        String mensagem,
        LocalDate dataCriacao,
        EstadoTopico status,
        Long autor,
        Long curso
) {
    public DadosListagemTopico(TopicoModel topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
