//package br.whitefox.tcc.adopet.service;
//
//import br.whitefox.tcc.adopet.domain.animal.Animal;
//import br.whitefox.tcc.adopet.domain.animal.AnimalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AnimalService {
//    @Autowired
//    private AnimalRepository animalRepository;
//
//    public Animal cadastrarAnimal(Animal animal) {
//        return animalRepository.save(animal);
//    }
//
//    public Page<Animal> buscarAnimalPelaRaca(String raca) {
//        return animalRepository.findByRaca(raca);
//    }
//
//    public Page<Animal> buscarAnimalPeloPorte(String porte) {
//        return animalRepository.findByPorte(porte);
//    }
//}
