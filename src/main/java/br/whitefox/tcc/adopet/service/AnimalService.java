package br.whitefox.tcc.adopet.service;

import br.whitefox.tcc.adopet.domain.animal.Animal;
import br.whitefox.tcc.adopet.domain.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public Page<Animal> listarTodosAnimais(Pageable page) {
        return animalRepository.findAll(page);
    }

}
