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
    private UsuarioRepository usuarioRepository;

    public void cadastrarUsuarioPadrao(Usuario usuario) {
        usuario.setTipoDeUsuario(TipoDeUsuario.PADRAO);
        usuarioRepository.save(usuario);
    }

    public void cadastrarUsuarioAdministrador(Usuario usuario) {
        usuario.setTipoDeUsuario(TipoDeUsuario.ADMIN);
        usuarioRepository.save(usuario);
    }

    public Page<Usuario> listarTodosUsuarios(Pageable page) {
        return usuarioRepository.findAll(page);
    }

    public Usuario buscarUsuarioPeloId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow();
    }

    public Usuario alterarUsuario(Integer id, DadosAtualizacaoUsuario usuario) {
        return usuarioRepository.getReferenceById(id);
    }

    public void deletarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}

