package br.whitefox.tcc.adopet.service;

import br.whitefox.tcc.adopet.domain.animal.Animal;
import br.whitefox.tcc.adopet.domain.animal.AnimalRepository;
import br.whitefox.tcc.adopet.domain.animal.PorteDoAnimal;
import br.whitefox.tcc.adopet.domain.animal.TipoDoAnimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public void cadastrarNovoAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public Page<Animal> listarTodosAnimais(Pageable page) {
        return animalRepository.findAll(page);
    }

    public Page<Animal> buscarAnimalPorRaca(TipoDoAnimal raca, Pageable page) {
        return animalRepository.findByRaca(raca, page);
    }

    public Page<Animal> buscarAnimalPeloPorte(PorteDoAnimal porte, Pageable page) {
        return animalRepository.findByPorte(porte, page);
    }

    public void excluirAnimal(Integer id) { animalRepository.deleteById(id);
    }
}
