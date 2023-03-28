package br.whitefox.tcc.adopet.domain.usuario;

import br.whitefox.tcc.adopet.domain.animal.Animal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)//essa anotação garante que esse campo não tera repetição
    private String email;
    private String telefone;
    private String telefoneRecado;
    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipoDeUsuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Animal> animais = new ArrayList<>();

    /**
     * Constructor para Usuario DTO e método from DTO
     *
     * @param id
     * @param nome
     * @param email
     * @param telefone
     * @param telefoneRecado
     * @param tipoDeUsuario
     */
    public Usuario(Integer id, String nome, String email, String telefone, String telefoneRecado, TipoDeUsuario tipoDeUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.telefoneRecado = telefoneRecado;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    /**
     * Constructor para DTO Cadastro Usuario
     *
     * @param dadosCadastroUsuario
     */
    public Usuario(DadosCadastroUsuario dadosCadastroUsuario) {
        this.nome = dadosCadastroUsuario.nome();
        this.email = dadosCadastroUsuario.email();
        this.telefone = dadosCadastroUsuario.telefone();
        this.telefoneRecado = dadosCadastroUsuario.telefoneRecado();
    }

    public void atualizarInformacoes(DadosAtualizacaoUsuario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.telefoneRecado() != null) {
            this.telefoneRecado = dados.telefoneRecado();
        }
    }
}