package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.animal.Animal;
import br.whitefox.tcc.adopet.domain.animal.DetalhamentoAnimal;
import br.whitefox.tcc.adopet.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarEndereco(@RequestBody @Valid DetalhamentoAnimal dados) {
        var animal = new Animal(dados);
        animalService.cadastrarAnimal(animal);
        return ResponseEntity.created(null).body(new DetalhamentoAnimal(animal));
    }
}
