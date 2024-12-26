package com.herick.forumHub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public TopicoModel criarTopico(DadosCadastroTopico dados) {
        var topico = new TopicoModel(dados);
        return topicoRepository.save(topico);

    }
}
