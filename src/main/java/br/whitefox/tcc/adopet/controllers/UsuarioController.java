package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.usuario.*;
import br.whitefox.tcc.adopet.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuarioPadrao(@RequestBody @Valid DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        usuarioService.cadastrarUsuarioPadrao(usuario);
        return ResponseEntity.created(null).body(new DetalhamentoUsuario(usuario));
    }

    @PostMapping("/administrador")
    @Transactional
    public ResponseEntity cadastrarUsuarioAdministrador(@RequestBody @Valid DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        usuarioService.cadastrarUsuarioAdministrador(usuario);
        return ResponseEntity.created(null).body(new DetalhamentoUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemUsuario>> listarTodosUsuarios(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        return ResponseEntity.ok().body(usuarioService.listarTodosUsuarios(paginacao).map(ListagemUsuario::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUsuarioPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioService.buscarUsuarioPeloId(id);
        return ResponseEntity.ok(new DetalhamentoUsuario(usuario));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarUsuario(@PathVariable Integer id, @RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = usuarioService.AlterarUsuario(id, dados);
        usuario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosAtualizacaoUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable Integer id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
