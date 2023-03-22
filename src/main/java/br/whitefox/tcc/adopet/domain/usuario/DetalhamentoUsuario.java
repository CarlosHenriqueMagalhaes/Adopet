package br.whitefox.tcc.adopet.domain.usuario;

// Usado para o método de listar todos usuários sem trazer o endereço no corpo
public record DetalhamentoUsuario(
        Integer id,
        String nome,
        String email,
        String telefone,
        String telefoneRecado,
        TipoDeUsuario tipoDeUsuario) {
    public DetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTelefoneRecado(),
                usuario.getTipoDeUsuario());
    }
}
