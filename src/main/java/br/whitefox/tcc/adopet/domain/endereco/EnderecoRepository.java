package br.whitefox.tcc.adopet.domain.endereco;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
    Page<Endereco> findByCidade(String cidade, Pageable page);
    Page<Endereco>findByCep(String cep, Pageable page);
    Page<Endereco> findByEstado(String estado, Pageable page);
}
