package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.endereco.DadosCadastroEAtualizacaoEndereco;
import br.whitefox.tcc.adopet.domain.endereco.DetalhamentoEndereco;
import br.whitefox.tcc.adopet.domain.endereco.Endereco;
import br.whitefox.tcc.adopet.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoEndereco> cadastrarEndereco(@RequestBody @Valid DadosCadastroEAtualizacaoEndereco dados) {
        var endereco = new Endereco(dados);
        enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.created(null).body(new DetalhamentoEndereco(endereco));
    }
//
//    @GetMapping("/cidade")
//    public ResponseEntity<Page<DetalhamentoEndereco>> buscarEnderecoPelaCidade(@PageableDefault(size = 10, page = 0) Pageable cidade) {
//        return ResponseEntity.ok().body(enderecoService.buscarEnderecoPelaCidade(cidade).map(DetalhamentoEndereco::new));
//    }
//
//    @GetMapping("/cep")
//    public ResponseEntity<Page<DetalhamentoEndereco>> buscarEnderecoPeloCep(@PageableDefault(size = 10, page = 0) Pageable cep) {
//        return ResponseEntity.ok().body(enderecoService.buscarEnderecoPeloCep(cep).map(DetalhamentoEndereco::new));
//    }
//
//    @GetMapping("/estado")
//    public ResponseEntity<Page<DetalhamentoEndereco>> buscarEnderecoPeloEstado(@PageableDefault(size = 10, page = 0) Pageable estado) {
//        return ResponseEntity.ok().body(enderecoService.buscarEnderecoPeloEstado(estado).map(DetalhamentoEndereco::new));
//    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosCadastroEAtualizacaoEndereco> atualizarEndereco(@PathVariable Integer id, @RequestBody @Valid DadosCadastroEAtualizacaoEndereco dados) {
        var endereco = enderecoService.alterarEndereco(id, dados);
        endereco.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosCadastroEAtualizacaoEndereco(endereco));
    }
}
