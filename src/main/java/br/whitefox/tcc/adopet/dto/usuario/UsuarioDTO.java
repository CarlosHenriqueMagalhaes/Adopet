package br.whitefox.tcc.adopet.dto.usuario;

import br.whitefox.tcc.adopet.domain.Endereco;
import br.whitefox.tcc.adopet.domain.Usuario;
import br.whitefox.tcc.adopet.enums.usuario.TipoDeUsuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotBlank
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 80, message = "Esse campo deve conter entre 3 e 80 caracteres")
    private String nome;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String telefone;
    private String telefoneRecado;
    private TipoDeUsuario tipoDeUsuario;
    private Endereco enderecos;

    public UsuarioDTO(Usuario user) {
        id = user.getId();
        nome = user.getNome();
        email = user.getEmail();
        telefone = user.getTelefone();
        telefoneRecado = user.getTelefoneRecado();
        tipoDeUsuario = user.getTipoDeUsuario();
        enderecos = user.getEnderecos();
    }
}
