package com.herick.forumHub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public DadosTopicoRegistrado criarTopico(DadosCadastroTopico dados) {
        var topico = new TopicoModel(dados);
        topicoRepository.save(topico);
        return new DadosTopicoRegistrado(topico);
    }


    public Page<DadosListagemTopico> listarTodosTopicos(Pageable paginacao) {
        return topicoRepository.findAllTopicosByDataCriacao(paginacao).map(DadosListagemTopico::new);
    }

    public DadosTopicoRegistrado buscarTopicoPorId(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return new DadosTopicoRegistrado(topico);
    }
}
