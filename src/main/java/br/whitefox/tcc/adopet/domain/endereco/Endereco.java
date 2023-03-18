package br.whitefox.tcc.adopet.domain.endereco;

import br.whitefox.tcc.adopet.domain.usuario.DadosAtualizacaoUsuario;
import br.whitefox.tcc.adopet.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {
    @Id
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    @MapsId
    private Usuario usuario;

    public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco(DadosCadastroEAtualizacaoEndereco dadosCadastroEndereco) {
        this.logradouro = dadosCadastroEndereco.logradouro();
        this.numero = dadosCadastroEndereco.numero();
        this.complemento = dadosCadastroEndereco.complemento();
        this.bairro = dadosCadastroEndereco.bairro();
        this.cep = dadosCadastroEndereco.cep();
        this.cidade = dadosCadastroEndereco.cidade();
        this.estado = dadosCadastroEndereco.estado();
    }

    public void atualizarInformacoes(DadosCadastroEAtualizacaoEndereco dados) {
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.numero() != null) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.estado() != null) {
            this.estado = dados.estado();
        }
    }
}
