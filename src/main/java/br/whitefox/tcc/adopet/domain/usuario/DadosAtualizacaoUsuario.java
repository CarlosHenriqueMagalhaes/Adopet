package br.whitefox.tcc.adopet.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoUsuario(
        @NotBlank
        String nome,
        String telefone,
        String telefoneRecado
) {
    public DadosAtualizacaoUsuario(Usuario usuario) {
        this(
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getTelefoneRecado()
        );
    }
}
