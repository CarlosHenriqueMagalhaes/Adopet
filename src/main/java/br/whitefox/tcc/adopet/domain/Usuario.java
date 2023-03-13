package br.whitefox.tcc.adopet.domain;

import br.whitefox.tcc.adopet.dto.usuario.DadosCadastroUsuario;
import br.whitefox.tcc.adopet.enums.usuario.TipoDeUsuario;
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
    private TipoDeUsuario tipoDeUsuario; //  para o caso do ENUMS user padrão ou user admin
    // @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Endereco enderecos;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Animal> animais = new ArrayList<>();

    /**
     * Constructor para Usuario DTO e método from DTO
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
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.telefoneRecado = telefoneRecado;
    }
}
