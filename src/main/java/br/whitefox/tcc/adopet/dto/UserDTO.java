package br.whitefox.tcc.adopet.dto;

import br.whitefox.tcc.adopet.domain.Endereco;
import br.whitefox.tcc.adopet.domain.User;
import br.whitefox.tcc.adopet.enums.TipoDeUsuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotNull
    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 3, max = 80, message = "Esse campo deve conter entre 3 e 80 caracteres")
    private String nome;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    private String telefone;
    private String telefoneRecado;
    private TipoDeUsuario tipoDeUsuario;
   // private List<EnderecoDTO> enderecos = new ArrayList<>();

    public UserDTO (User user){
        id = user.getId();
        nome = user.getNome();
        email = user.getEmail();
        telefone = user.getTelefone();
        telefoneRecado = user.getTelefoneRecado();
        tipoDeUsuario = user.getTipoDeUsuario();
//        enderecos = user.getEnderecos();
    }
}
