package br.whitefox.tcc.adopet.domain.animal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Override
    Page<Animal> findAll(Pageable pageable);

    Page<Animal> findByRaca(TipoDoAnimal raca, Pageable page);
    Page<Animal> findByPorte(PorteDoAnimal porte, Pageable page);
}
