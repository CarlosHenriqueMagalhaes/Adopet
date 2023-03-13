package br.whitefox.tcc.adopet.services;

import br.whitefox.tcc.adopet.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

}
