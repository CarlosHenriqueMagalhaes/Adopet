package br.whitefox.tcc.adopet.domain;

import br.whitefox.tcc.adopet.enums.PorteDoAnimal;
import br.whitefox.tcc.adopet.enums.TipoDoAnimal;
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
    private Integer raca;//enum
    private Integer porte;//enum

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Animal(Integer id, TipoDoAnimal raca, PorteDoAnimal porte) {
        this.id = id;
        this.raca = (raca==null)?null:raca.getCod();
        this.porte = (porte==null)?null:porte.getCod();
    }

    // Getters e Setters para o caso do ENUM
    public TipoDoAnimal getRaca() {
        return TipoDoAnimal.toEnum(raca);
    }
    public void setRaca(TipoDoAnimal raca) {
        this.raca = raca.getCod();
    }
    public PorteDoAnimal getPorte() {
        return PorteDoAnimal.toEnum(porte);
    }
    public void setPorte(PorteDoAnimal porte) {
        this.porte = porte.getCod();
    }
}