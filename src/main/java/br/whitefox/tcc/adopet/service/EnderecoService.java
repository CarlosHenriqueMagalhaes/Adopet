package br.whitefox.tcc.adopet.service;

import br.whitefox.tcc.adopet.domain.endereco.DadosCadastroEAtualizacaoEndereco;
import br.whitefox.tcc.adopet.domain.endereco.Endereco;
import br.whitefox.tcc.adopet.domain.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco cadastrarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

//    public Page<Endereco> buscarEnderecoPelaCidade(Pageable cidade) {
//        return enderecoRepository.findByCidade(cidade);
//    }
//
//    public Page<Endereco> buscarEnderecoPeloCep(Pageable cep) {
//        return enderecoRepository.findByCep(cep);
//    }
//
//    public Page<Endereco> buscarEnderecoPeloEstado(Pageable estado) {
//        return enderecoRepository.findByEstado(estado);
//    }

    public Endereco alterarEndereco(Integer id, DadosCadastroEAtualizacaoEndereco dados) {
        return enderecoRepository.getReferenceById(id);
    }
}
