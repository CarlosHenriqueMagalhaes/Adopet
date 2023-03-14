package br.whitefox.tcc.adopet.domain.usuario;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

// Usado para o método de listar todos usuários sem trazer o endereço no corpo

public record DadosCadastroUsuario(

        @NotBlank
        @NotEmpty(message = "Preenchimento obrigatório")
        @Length(min = 2, max = 80, message = "Esse campo deve conter entre 2 e 80 caracteres")
        String nome,
        @NotBlank(message = "Esse email ja esta cadastrado!")
        @Email
        @Column(unique = true)
        String email,
        String telefone,
        String telefoneRecado) {
    public DadosCadastroUsuario(Usuario usuario) {
        this(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTelefoneRecado());
    }
}
