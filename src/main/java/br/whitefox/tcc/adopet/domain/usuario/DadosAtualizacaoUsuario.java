package br.whitefox.tcc.adopet.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record DadosAtualizacaoUsuario(
        @NotBlank (message = "Preenchimento obrigatório")
        @Length(min = 2, max = 80, message = "Esse campo deve conter entre 2 e 80 caracteres")
        String nome,
        String telefone,
        String telefoneRecado
) {
    public DadosAtualizacaoUsuario(Usuario usuario) {
        this(
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getTelefoneRecado());
    }
}
