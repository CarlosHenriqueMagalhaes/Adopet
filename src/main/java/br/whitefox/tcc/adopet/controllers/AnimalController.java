//package br.whitefox.tcc.adopet.controllers;
//
//import br.whitefox.tcc.adopet.domain.animal.Animal;
//import br.whitefox.tcc.adopet.domain.animal.DetalhamentoAnimal;
//import br.whitefox.tcc.adopet.service.AnimalService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class AnimalController {
//    @Autowired
//    private AnimalService animalService;
//
//    @PostMapping
//    @Transactional
//    public ResponseEntity cadastrarEndereco(@RequestBody @Valid DetalhamentoAnimal dados) {
//        var animal = new Animal(dados);
//        animalService.cadastrarAnimal(animal);
//        return ResponseEntity.created(null).body(new DetalhamentoAnimal(animal));
//    }
//
//    @GetMapping("/raca")
//    public ResponseEntity<Page<DetalhamentoAnimal>> buscarAnimalPelaRaca(@PageableDefault(size = 10, page = 0) @RequestParam String raca) {
//        return ResponseEntity.ok().body(animalService.buscarAnimalPelaRaca(raca).map(DetalhamentoAnimal::new));
//    }
//
//    @GetMapping("/porte")
//    public ResponseEntity<Page<DetalhamentoAnimal>> buscarAnimalPeloPorte(@PageableDefault(size = 10, page = 0) @RequestParam String porte) {
//        return ResponseEntity.ok().body(animalService.buscarAnimalPeloPorte(porte).map(DetalhamentoAnimal::new));
//    }
//
//}
