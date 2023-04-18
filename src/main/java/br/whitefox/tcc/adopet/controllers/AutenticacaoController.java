package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.usuario.DadosAutenticacao;
import br.whitefox.tcc.adopet.domain.usuario.Usuario;
import br.whitefox.tcc.adopet.infra.security.DadosTokenJWT;
import br.whitefox.tcc.adopet.infra.security.TokenService;
import jakarta.validation.Valid;
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
    public class AutenticacaoController {
        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dadosAutenticacao.email(), dadosAutenticacao.senha());
            var authentication = authenticationManager.authenticate(authenticationToken);
            var tokenJWT =  tokenService.gerarToken((Usuario) authentication.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        }
    }

