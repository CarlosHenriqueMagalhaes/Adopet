package br.whitefox.tcc.adopet.services;

import br.whitefox.tcc.adopet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
