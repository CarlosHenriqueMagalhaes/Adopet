package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.animal.*;
import br.whitefox.tcc.adopet.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoAnimal> cadastrarNovoAnimal(@RequestBody @Valid DetalhamentoAnimal dados) {
        var animal = new Animal(dados);
        animalService.cadastrarNovoAnimal(animal);
        return ResponseEntity.created(null).body(new DetalhamentoAnimal(animal));
    }

    @GetMapping
    public ResponseEntity<Page<DetalhamentoAnimalComIdendificador>> listarTodosAnimais(@PageableDefault(size = 10, page = 0) Pageable paginacao) {
        return ResponseEntity.ok().body(animalService.listarTodosAnimais(paginacao).map(DetalhamentoAnimalComIdendificador::new));
    }

    @GetMapping("/raca/{raca}")
    public ResponseEntity<Page<DetalhamentoAnimalComIdendificador>> buscarAnimalPorRaca(@PageableDefault(size = 10, page = 0) @PathVariable TipoDoAnimal raca, Pageable page) {
        return ResponseEntity.ok().body(animalService.buscarAnimalPorRaca(raca, page).map(DetalhamentoAnimalComIdendificador::new));
    }

    @GetMapping("/porte/{porte}")
    public ResponseEntity<Page<DetalhamentoAnimalComIdendificador>> buscarAnimalPeloPorte(@PageableDefault(size = 10, page = 0) @PathVariable PorteDoAnimal porte, Pageable page) {
        return ResponseEntity.ok().body(animalService.buscarAnimalPeloPorte(porte, page).map(DetalhamentoAnimalComIdendificador::new));
    }

    @DeleteMapping("/{id}")
   @Transactional
    public ResponseEntity<?> excluirAnimal(@PathVariable Integer id) {
        animalService.excluirAnimal(id);
        return ResponseEntity.noContent().build();
    }

}
