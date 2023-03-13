package br.whitefox.tcc.adopet.enums.animal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum PorteDoAnimal {
    GRANDE("Porte grande"), MEDIO("Porte médio"),PEQUENO("Porte pequeno");
    private String descricao;
}
