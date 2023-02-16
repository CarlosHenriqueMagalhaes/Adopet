package br.whitefox.tcc.adopet.services;

import br.whitefox.tcc.adopet.domain.User;
import br.whitefox.tcc.adopet.exceptions.ObjectNotFoundException;
import br.whitefox.tcc.adopet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * buscar User por ID (GET do controller) Apenas Administradores
     * @param id
     * @return
     */
    public User buscaUmUsuarioPeloId(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new ObjectNotFoundException(
                "Usu encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
    }

    /**
     * Lista todos os Usuários (GET do controller) Apenas Administradores
     * @return
     */
    public List<User> listaTodosUsuarios() {
        return userRepository.findAll();
    }
}
