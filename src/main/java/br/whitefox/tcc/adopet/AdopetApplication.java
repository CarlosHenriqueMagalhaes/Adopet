package br.whitefox.tcc.adopet;

import br.whitefox.tcc.adopet.domain.Animal;
import br.whitefox.tcc.adopet.domain.Usuario;
import br.whitefox.tcc.adopet.enums.animal.PorteDoAnimal;
import br.whitefox.tcc.adopet.enums.animal.TipoDoAnimal;
import br.whitefox.tcc.adopet.enums.usuario.TipoDeUsuario;
import br.whitefox.tcc.adopet.repositories.AnimalRepository;
import br.whitefox.tcc.adopet.repositories.EnderecoRepository;
import br.whitefox.tcc.adopet.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdopetApplication implements CommandLineRunner {
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(AdopetApplication.class, args);
    }

    @Override
    public void run(String... args) {


        Usuario usuarioAdministradorPadrao = new Usuario(null, "Zero", "zero@mail.com",
                "(35)9705-1145", "3471-0340", TipoDeUsuario.ADMIN
        );
        Usuario usuarioPadrao = new Usuario(null, "Anakin Skywalker", "anakin_jedi.sith@starmail.com",
                "(35)9998-0511", null, TipoDeUsuario.PADRAO
        );
        Animal animalModelCao = new Animal(
                null, TipoDoAnimal.CACHORRO, PorteDoAnimal.MEDIO, usuarioAdministradorPadrao);
        Animal animalModelGato = new Animal(null, TipoDoAnimal.GATO, PorteDoAnimal.PEQUENO, usuarioPadrao);

        usuarioAdministradorPadrao.getAnimais().add(animalModelCao);
        usuarioPadrao.getAnimais().add(animalModelGato);

        userRepository.saveAll(List.of(usuarioAdministradorPadrao, usuarioPadrao));
        animalRepository.saveAll(List.of(animalModelCao, animalModelGato));
    }
}
