package br.whitefox.tcc.adopet.domain.endereco;

import br.whitefox.tcc.adopet.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
    Endereco findByCidade(String cidade);
}
