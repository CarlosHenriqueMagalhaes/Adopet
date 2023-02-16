package br.whitefox.tcc.adopet.controllers.dto;

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
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;

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

    public UserDTO (User userDto){
        id = userDto.getId();
        nome = userDto.getNome();
        email = userDto.getEmail();
        telefone = userDto.getTelefone();
        telefoneRecado = userDto.getTelefoneRecado();
        tipoDeUsuario = userDto.getTipoDeUsuario();
    }
}
