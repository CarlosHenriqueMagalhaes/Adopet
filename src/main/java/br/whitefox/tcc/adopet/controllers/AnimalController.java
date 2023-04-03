package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.animal.DetalhamentoAnimal;
import br.whitefox.tcc.adopet.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<Page<DetalhamentoAnimal>> listarTodosAnimais(@PageableDefault(size = 10, page = 0)  Pageable paginacao) {
        return ResponseEntity.ok().body(animalService.listarTodosAnimais(paginacao).map(DetalhamentoAnimal::new));
    }

}
