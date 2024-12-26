package com.herick.forumHub.domain.topico;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TopicoService {

    private TopicoRepository topicoRepository;


    public TopicoModel criarTopico(TopicoModel topico) {
        return topicoRepository.save(topico);

    }
}
