package br.whitefox.tcc.adopet.dto.endereco;

import br.whitefox.tcc.adopet.domain.Endereco;
import br.whitefox.tcc.adopet.domain.Usuario;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDTO implements Serializable {
    @Id
    private Integer id;
    @NotBlank(message = "Dados do endereço são obrigatórios")
    private String logradouro;
    @NotBlank(message = "Dados do endereço são obrigatórios")
    private String numero;
    private String complemento;
    @NotBlank(message = "Dados do endereço são obrigatórios")
    private String bairro;
    @NotBlank(message = "Dados do endereço são obrigatórios")
    @Pattern(regexp = "\\d{8}")
    private String cep;
    @NotBlank(message = "Dados do endereço são obrigatórios")
    private String cidade;
    @NotBlank(message = "Dados do endereço são obrigatórios")
    private String estado;
    private Usuario usuario;

    public EnderecoDTO(Endereco endereco) {
        id = endereco.getId();
        logradouro = endereco.getLogradouro();
        numero = endereco.getNumero();
        complemento = endereco.getComplemento();
        bairro = endereco.getBairro();
        cep = endereco.getCep();
        cidade = endereco.getCidade();
        estado = endereco.getEstado();
        usuario = endereco.getUsuario();
    }
}
