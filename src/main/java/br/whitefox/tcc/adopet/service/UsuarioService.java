package br.whitefox.tcc.adopet.service;

import br.whitefox.tcc.adopet.domain.usuario.DadosAtualizacaoUsuario;
import br.whitefox.tcc.adopet.domain.usuario.TipoDeUsuario;
import br.whitefox.tcc.adopet.domain.usuario.Usuario;
import br.whitefox.tcc.adopet.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuarioPadrao(Usuario usuario) {
        usuario.setTipoDeUsuario(TipoDeUsuario.PADRAO);
        return usuarioRepository.save(usuario);
    }

    public Usuario cadastrarUsuarioAdministrador(Usuario usuario) {
        usuario.setTipoDeUsuario(TipoDeUsuario.ADMIN);
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> listarTodosUsuarios(Pageable page) {
        return usuarioRepository.findAll(page);
    }

    public Usuario buscarUsuarioPeloId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow();
    }

    public Usuario AlterarUsuario(Integer id, DadosAtualizacaoUsuario usuario) {
        return usuarioRepository.getReferenceById(id);
    }

    public void deletarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

