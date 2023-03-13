package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AnimalController {
    @Autowired
    private AnimalService animalService;
}
