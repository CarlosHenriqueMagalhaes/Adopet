package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.Usuario;
import br.whitefox.tcc.adopet.dto.usuario.DadosCadastroUsuario;
import br.whitefox.tcc.adopet.dto.usuario.ListagemUsuario;
import br.whitefox.tcc.adopet.dto.usuario.UsuarioDTO;
import br.whitefox.tcc.adopet.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity<UsuarioDTO> buscaUmUsuario(@RequestParam Integer id) {
        Usuario usuario = usuarioService.buscaUmUsuarioPeloId(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<ListagemUsuario>> ListaTodosUsuarios() {
        List<Usuario> list = usuarioService.listaTodosUsuarios();
        List<ListagemUsuario> listaDTO = list.stream().map(ListagemUsuario::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> cadastraUsuario(
            @RequestBody @Valid DadosCadastroUsuario usuarioDTO) {
        Usuario usuario = usuarioService.fromDTO(usuarioDTO);
        return ResponseEntity.created(null).body(usuarioService.cadastraUsuario(usuario));
    }
}
