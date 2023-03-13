package br.whitefox.tcc.adopet.repositories;

import br.whitefox.tcc.adopet.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Override
    Page<Usuario> findAll(Pageable pageable);
}
