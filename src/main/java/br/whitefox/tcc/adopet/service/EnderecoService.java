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

    public void cadastrarEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Page<Endereco> buscarEnderecoPelaCidade(String cidade, Pageable page) {
        return enderecoRepository.findByCidade(cidade, page);
    }

    public Page<Endereco> buscarEnderecoPeloCep(String cep, Pageable page) {
        return enderecoRepository.findByCep(cep, page);
    }

    public Page<Endereco> buscarEnderecoPeloEstado(String estado, Pageable page) {
        return enderecoRepository.findByEstado(estado, page);
    }

    public Endereco alterarEndereco(Integer id, DadosCadastroEAtualizacaoEndereco dados) {
        return enderecoRepository.getReferenceById(id);
    }
}
