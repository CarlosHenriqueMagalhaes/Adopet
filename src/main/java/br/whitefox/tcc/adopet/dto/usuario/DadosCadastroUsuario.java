package br.whitefox.tcc.adopet.dto.usuario;

import br.whitefox.tcc.adopet.domain.Usuario;
import br.whitefox.tcc.adopet.enums.usuario.TipoDeUsuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

// Usado para o método de listar todos usuários sem trazer o endereço no corpo
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class DadosCadastroUsuario {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotNull
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 80, message = "Esse campo deve conter entre 3 e 80 caracteres")
    private String nome;
    @NotNull(message = "Esse email ja esta cadastrado!")
    @Email
    @Column(unique = true)
    private String email;
    private String telefone;
    private String telefoneRecado;
    private TipoDeUsuario tipoDeUsuario;

    public DadosCadastroUsuario(Usuario usuario) {
        nome = usuario.getNome();
        email = usuario.getEmail();
        telefone = usuario.getTelefone();
        telefoneRecado = usuario.getTelefoneRecado();
        tipoDeUsuario = getTipoDeUsuario();
    }
}
