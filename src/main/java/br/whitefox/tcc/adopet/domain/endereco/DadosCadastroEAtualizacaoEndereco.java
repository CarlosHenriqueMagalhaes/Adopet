package br.whitefox.tcc.adopet.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record DadosCadastroEAtualizacaoEndereco(
        @NotBlank (message = "Preenchimento obrigatório")
        @Length(min = 2, max = 100, message = "Esse campo deve conter entre 2 e 100 caracteres")
        String logradouro,
        String numero,
        @Length(min = 1, max = 100, message = "Esse campo deve conter entre 1 e 100 caracteres")
        String complemento,
        @NotBlank (message = "Preenchimento obrigatório")
        @Length(min = 2, max = 100, message = "Esse campo deve conter entre 2 e 100 caracteres")
        String bairro,
        @NotBlank (message = "Preenchimento obrigatório")
        String cep,
        String cidade,
        String estado) {
        public DadosCadastroEAtualizacaoEndereco(Endereco endereco) {
                this(
                        endereco.getLogradouro(),
                        endereco.getNumero(),
                        endereco.getComplemento(),
                        endereco.getBairro(),
                        endereco.getCep(),
                        endereco.getCidade(),
                        endereco.getEstado());
        }
}
