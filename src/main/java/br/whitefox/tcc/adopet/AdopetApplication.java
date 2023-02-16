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

	User userDefaultAdm = new User(null,"Zero","zero@mail.com","(35)9705-1145",null, TipoDeUsuario.ADMIN);
	User userDefault = new User(null,"Nobody","nobobody.padrao@mail.com","(35)9998-0511","3471-0340", TipoDeUsuario.PADRAO);
	Endereco enderecoDefault = new Endereco(null,"Rua: Lurdes de Oliveira","7",null,"Aristeu Costa Rios","3755-055","Pouso Alegre","MG");
	Animal animalModel = new Animal(null, TipoDoAnimal.CACHORRO, PorteDoAnimal.MEDIO);

	userDefault.getEnderecos().add(enderecoDefault);
	userDefault.getAnimais().add(animalModel);

		userRepository.saveAll(List.of(userDefaultAdm,userDefault));
		enderecoRepository.saveAll(List.of(enderecoDefault));
		animalRepository.saveAll(List.of(animalModel));
	}
}
