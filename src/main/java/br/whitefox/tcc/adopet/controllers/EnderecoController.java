package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.Endereco;
import br.whitefox.tcc.adopet.dto.endereco.EnderecoDTO;
import br.whitefox.tcc.adopet.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/endereco/cidade")
    public ResponseEntity<EnderecoDTO> buscaUmEnderecoPorCidade(@RequestParam String cidade) {
       Endereco endereco = enderecoService.buscaUmEndercoPorCidade(cidade);
        return ResponseEntity.ok().body(new EnderecoDTO(endereco));
    }
}
