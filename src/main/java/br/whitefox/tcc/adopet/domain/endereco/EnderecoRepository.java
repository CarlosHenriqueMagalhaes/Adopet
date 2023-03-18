package br.whitefox.tcc.adopet.domain.endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
    Endereco findByCidade(String cidade);
    Endereco findByCep (String cep);
    Endereco findByEstado (String estado);
}
