package br.whitefox.tcc.adopet.domain.usuario;

// Usado para o método de listar todos usuários sem trazer o endereço no corpo
public record ListagemUsuario(
        Integer id,
        String nome,
        String email,
        String telefone,
        String telefoneRecado,
        TipoDeUsuario tipoDeUsuario) {
    public ListagemUsuario(Usuario usuario){
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getTelefoneRecado(),
                usuario.getTipoDeUsuario());
    }
}
