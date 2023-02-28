package br.whitefox.tcc.adopet.domain;

import br.whitefox.tcc.adopet.enums.TipoDeUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotBlank
    private String nome;
    @NotBlank
    @NotNull
    @Column(unique = true)//essa anotação garante que esse campo não tera repetição
    private String email;
    @NotBlank
    @NotNull
    private String telefone;
    private String telefoneRecado;
    @Enumerated(EnumType.STRING)
    private TipoDeUsuario tipoDeUsuario; //  para o caso do ENUMS user padrão ou user admin
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();
    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    private List<Animal> animais = new ArrayList<>();

    public User(Integer id, String nome, String email, String telefone, String telefoneRecado, TipoDeUsuario tipoDeUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.telefoneRecado = telefoneRecado;
        this.tipoDeUsuario = tipoDeUsuario;
    }
}
