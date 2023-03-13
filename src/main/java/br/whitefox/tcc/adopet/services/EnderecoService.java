package br.whitefox.tcc.adopet.services;

import br.whitefox.tcc.adopet.domain.Endereco;
import br.whitefox.tcc.adopet.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco buscaUmEndercoPorCidade(String cidade) {
        return enderecoRepository.findByCidade(cidade);
    }

    public Endereco cadastraEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
