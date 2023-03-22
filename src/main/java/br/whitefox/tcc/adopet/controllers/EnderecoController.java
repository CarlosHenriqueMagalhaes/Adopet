package br.whitefox.tcc.adopet.controllers;

import br.whitefox.tcc.adopet.domain.endereco.DadosCadastroEAtualizacaoEndereco;
import br.whitefox.tcc.adopet.domain.endereco.DetalhamentoEndereco;
import br.whitefox.tcc.adopet.domain.endereco.Endereco;
import br.whitefox.tcc.adopet.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity cadastrarEndereco(@RequestBody @Valid DadosCadastroEAtualizacaoEndereco dados) {
        var endereco = new Endereco(dados);
        enderecoService.cadastrarEndereco(endereco);
        return ResponseEntity.created(null).body(new DetalhamentoEndereco(endereco));
    }

    //page //traz apenas se tiver um elemento
    @GetMapping("/cidade")
    public ResponseEntity buscarEnderecoPelaCidade(@RequestParam String cidade) {
        Endereco endereco = enderecoService.buscarEnderecoPelaCidade(cidade);
        return ResponseEntity.ok(new DetalhamentoEndereco(endereco));
    }

    //page //traz apenas se tiver um elemento
    @GetMapping("/cep")
    public ResponseEntity buscarEnderecoPeloCep(@RequestParam String bairro) {
        Endereco endereco = enderecoService.buscarEnderecoPeloCep(bairro);
        return ResponseEntity.ok(new DetalhamentoEndereco(endereco));
    }

    //page //traz apenas se tiver um elemento
    @GetMapping("/estado")
    public ResponseEntity buscarEnderecoPeloEstado(@RequestParam String estado) {
        Endereco endereco = enderecoService.buscarEnderecoPeloEstado(estado);
        return ResponseEntity.ok(new DetalhamentoEndereco(endereco));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarEndereco(@PathVariable Integer id, @RequestBody @Valid DadosCadastroEAtualizacaoEndereco dados) {
        var endereco = enderecoService.alterarEndereco(id, dados);
        endereco.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosCadastroEAtualizacaoEndereco(endereco));
    }
}
