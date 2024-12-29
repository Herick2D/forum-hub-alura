package com.herick.forumHub.controller;

import com.herick.forumHub.domain.topico.DadosCadastroTopico;
import com.herick.forumHub.domain.topico.DadosListagemTopico;
import com.herick.forumHub.domain.topico.DadosTopicoRegistrado;
import com.herick.forumHub.domain.topico.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/topicos", "/topico"})
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosTopicoRegistrado> criarTopico(@RequestBody DadosCadastroTopico dados) { // TODO - Alterar o retorno para uma DTO
        var topicoSalvo = topicoService.criarTopico(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listarTodosTopicos(@PageableDefault(size = 10)Pageable paginacao) {
        var topicos = topicoService.listarTodosTopicos(paginacao);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosTopicoRegistrado> buscarTopicoPorId(@PathVariable Long id) {
        var topico = topicoService.buscarTopicoPorId(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosTopicoRegistrado> atualizarTopico(@PathVariable Long id, @RequestBody DadosCadastroTopico dados) {
        var topicoAtualizado = topicoService.atualizarTopico(id, dados);
        return ResponseEntity.ok(topicoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarTopico(@PathVariable Long id) {
        topicoService.deletarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
