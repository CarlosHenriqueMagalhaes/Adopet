package br.whitefox.tcc.adopet.domain.usuario;

import br.whitefox.tcc.adopet.domain.endereco.Endereco;

// Usado para o método de listar todos usuários sem trazer o endereço no corpo
public record DetalhamentoUsuario(
        Integer id,
        String nome,
        String email,
        String telefone,
        String telefoneRecado,
        TipoDeUsuario tipoDeUsuario,
        Endereco endereco) {
    public DetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTelefoneRecado(),
                usuario.getTipoDeUsuario(),
                usuario.getEndereco());
    }
}
