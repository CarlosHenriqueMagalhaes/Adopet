package br.whitefox.tcc.adopet.service;

import br.whitefox.tcc.adopet.domain.animal.Animal;
import br.whitefox.tcc.adopet.domain.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Animal cadastrarAnimal(Animal animal) {
        return animalRepository.save(animal);
    }
}
