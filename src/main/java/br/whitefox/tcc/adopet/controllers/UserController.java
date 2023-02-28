package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.dto.UserDTO;
import br.whitefox.tcc.adopet.domain.User;
import br.whitefox.tcc.adopet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Médodo GET - devolve um User de acordo com o id solicitado (apenas administradores)
     * @param id
     * @return
     */
    @GetMapping("/user")
    public ResponseEntity<UserDTO> endPointBuscaUmUsuarioPeloId(@RequestParam Integer id) {
        User user = userService.buscaUmUsuarioPeloId(id);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    /**
     * Médodo GET - Lista todos os Users (apenas administradores)
     * @return
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> endPointListaTodosUsuarios() {
        List<User> list = userService.listaTodosUsuarios();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
