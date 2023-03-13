package br.whitefox.tcc.adopet.dto.usuario;

import br.whitefox.tcc.adopet.domain.Usuario;
import br.whitefox.tcc.adopet.enums.usuario.TipoDeUsuario;
import lombok.*;

// Usado para o método de listar todos usuários sem trazer o endereço no corpo
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ListagemUsuario {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String telefoneRecado;
    private TipoDeUsuario tipoDeUsuario;

    public ListagemUsuario(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
        telefone = usuario.getTelefone();
        telefoneRecado = usuario.getTelefoneRecado();
        tipoDeUsuario = usuario.getTipoDeUsuario();
    }
}
