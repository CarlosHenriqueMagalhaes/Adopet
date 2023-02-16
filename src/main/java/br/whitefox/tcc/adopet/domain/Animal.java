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
    @Enumerated(EnumType.STRING)
    private TipoDoAnimal raca;
    @Enumerated(EnumType.STRING)
    private PorteDoAnimal porte;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}