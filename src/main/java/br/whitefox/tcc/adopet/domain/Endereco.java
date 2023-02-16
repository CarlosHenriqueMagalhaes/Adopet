package br.whitefox.tcc.adopet.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String logradouro;
    @NotNull
    private String numero;
    private String complemento;
    @NotNull
    private String bairro;
    @NotNull
    private String cep;
    @NotNull
    private String cidade;
    @NotNull
    private String estado;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Endereco(Integer id, String logradouro, String numero, String complemento, String bairro, String cep, String cidade,String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}
