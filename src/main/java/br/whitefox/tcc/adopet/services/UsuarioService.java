package br.whitefox.tcc.adopet.services;

import br.whitefox.tcc.adopet.domain.Usuario;
import br.whitefox.tcc.adopet.dto.usuario.DadosCadastroUsuario;
import br.whitefox.tcc.adopet.exceptions.ObjectNotFoundException;
import br.whitefox.tcc.adopet.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscaUmUsuarioPeloId(Integer id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        return usuarioOptional.orElseThrow(() -> new ObjectNotFoundException(
                "Usuário ID: " + id + ", não encontrado!"));
    }

    public List<Usuario> listaTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastraUsuario(Usuario usuario) {
    return usuarioRepository.save(usuario);
    }

    public Usuario fromDTO(DadosCadastroUsuario usuarioDto) {
        return new Usuario(usuarioDto.getId(), usuarioDto.getNome(), usuarioDto.getEmail(), usuarioDto.getTelefone(),
                usuarioDto.getTelefoneRecado(), usuarioDto.getTipoDeUsuario());
    }
}
