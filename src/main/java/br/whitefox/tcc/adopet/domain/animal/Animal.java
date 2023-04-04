package br.whitefox.tcc.adopet.domain.animal;

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
@Table(name = "Animal")
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private TipoDoAnimal raca;
    @Enumerated(EnumType.STRING)
    private PorteDoAnimal porte;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Animal(DetalhamentoAnimal dados) {
        this.porte = dados.porte();
        this.raca = dados.raca();
    }

    public Animal(DetalhamentoAnimalComIdendificador dados) {
        this.id = dados.id();
        this.porte = dados.porte();
        this.raca = dados.raca();
    }
}

