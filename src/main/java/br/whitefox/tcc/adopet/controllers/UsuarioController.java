package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.usuario.*;
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
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUsuarioPadrao(@RequestBody @Valid DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        usuario.setTipoDeUsuario(TipoDeUsuario.PADRAO);
        usuarioRepository.save(usuario);
        return ResponseEntity.created(null).body(new DetalhamentoUsuario(usuario));
    }

    @PostMapping("/administrador")
    @Transactional
    public ResponseEntity cadastrarUsuarioAdministrador(@RequestBody @Valid DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        usuario.setTipoDeUsuario(TipoDeUsuario.ADMIN);
        usuarioRepository.save(usuario);
        return ResponseEntity.created(null).body(new DetalhamentoUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemUsuario>> listar(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao) {
        var page = usuarioRepository.findAll(paginacao).map(ListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Integer id) {
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhamentoUsuario(usuario));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Integer id, @RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosAtualizacaoUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Integer id) {
        usuarioRepository.delete(usuarioRepository.getReferenceById(id));
        return ResponseEntity.noContent().build();
    }
}
