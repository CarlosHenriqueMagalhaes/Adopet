package br.whitefox.tcc.adopet.domain.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioLoginRepository extends JpaRepository <UsuarioLogin, Integer> {
    UserDetails findByLogin(String login);
}
