package com.herick.forumHub.controller;

import com.herick.forumHub.domain.usuario.DadosLogin;
import com.herick.forumHub.domain.usuario.UsuarioModel;
import com.herick.forumHub.infra.DadosTokenJWT;
import com.herick.forumHub.infra.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity<DadosTokenJWT> login(@RequestBody DadosLogin dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var token = tokenService.gerarToken((UsuarioModel)authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(token));
    }
}
