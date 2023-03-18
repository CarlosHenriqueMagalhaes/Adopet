package br.whitefox.tcc.adopet.service;

import br.whitefox.tcc.adopet.domain.endereco.DadosCadastroEAtualizacaoEndereco;
import br.whitefox.tcc.adopet.domain.endereco.Endereco;
import br.whitefox.tcc.adopet.domain.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    public Endereco cadastrarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco buscarEnderecoPelaCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade);
    }

    public Endereco buscarEnderecoPeloCep(String cep) {
        return enderecoRepository.findByCep(cep);
    }

    public Endereco buscarEnderecoPeloEstado(String estado) {
        return enderecoRepository.findByEstado(estado);
    }

    public Endereco alterarEndereco(Integer id, DadosCadastroEAtualizacaoEndereco dados) {
        return enderecoRepository.getReferenceById(id);
    }
}
