package br.whitefox.tcc.adopet.repositories;

import br.whitefox.tcc.adopet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
