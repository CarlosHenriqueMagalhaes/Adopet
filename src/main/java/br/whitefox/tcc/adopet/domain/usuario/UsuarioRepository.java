package br.whitefox.tcc.adopet.domain.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Override
    Page<Usuario> findAll(Pageable pageable);

    //find by email = find by login
    UserDetails findByEmail(String email);
}
