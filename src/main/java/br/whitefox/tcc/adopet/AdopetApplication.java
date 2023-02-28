package br.whitefox.tcc.adopet;

import br.whitefox.tcc.adopet.domain.Animal;
import br.whitefox.tcc.adopet.domain.Endereco;
import br.whitefox.tcc.adopet.domain.User;
import br.whitefox.tcc.adopet.enums.PorteDoAnimal;
import br.whitefox.tcc.adopet.enums.TipoDeUsuario;
import br.whitefox.tcc.adopet.enums.TipoDoAnimal;
import br.whitefox.tcc.adopet.repositories.AnimalRepository;
import br.whitefox.tcc.adopet.repositories.EnderecoRepository;
import br.whitefox.tcc.adopet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AdopetApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AnimalRepository animalRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdopetApplication.class, args);
	}
	@Override
	public void run (String... args){


	User userDefaultAdm = new User(null,"Zero","zero@mail.com","(35)9705-1145","3471-0340", TipoDeUsuario.ADMIN);
	User userDefault = new User(null,"Anakin Skywalker","anakin_jedi.sith@starmail.com","(35)9998-0511",null, TipoDeUsuario.PADRAO);
	Endereco enderecoDefaultAdmin = new Endereco
			(null,"Rua: Lurdes de Oliveira","7","A","Aristeu Costa Rios","3755-055","Pouso Alegre","MG",userDefaultAdm);
		Endereco enderecoDefault = new Endereco
				(null,"Setor 7","0",null,"Estrela da Morte","5757-158","Estação Sith","SW",userDefault);
	Animal animalModelCao = new Animal(null, TipoDoAnimal.CACHORRO, PorteDoAnimal.MEDIO,userDefaultAdm);
		Animal animalModelGato = new Animal(null, TipoDoAnimal.GATO, PorteDoAnimal.PEQUENO,userDefault);

		userDefaultAdm.getEnderecos().add(enderecoDefaultAdmin);
		userDefaultAdm.getAnimais().add(animalModelCao);
		userDefault.getEnderecos().add(enderecoDefault);
		userDefault.getAnimais().add(animalModelGato);

		userRepository.saveAll(List.of(userDefaultAdm,userDefault));
		enderecoRepository.saveAll(List.of(enderecoDefaultAdmin,enderecoDefault));
		animalRepository.saveAll(List.of(animalModelCao,animalModelGato));
	}
}
