package com.herick.forumHub.controller;

import com.herick.forumHub.domain.topico.DadosCadastroTopico;
import com.herick.forumHub.domain.topico.TopicoModel;
import com.herick.forumHub.domain.topico.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<TopicoModel> criarTopico(@RequestBody DadosCadastroTopico dados) { // TODO - Alterar o retorno para uma DTO
        var topicoSalvo = topicoService.criarTopico(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoSalvo);
    }
}
