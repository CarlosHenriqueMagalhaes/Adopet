package br.whitefox.tcc.adopet.repositories;

import br.whitefox.tcc.adopet.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository <Animal, Integer> {
}
