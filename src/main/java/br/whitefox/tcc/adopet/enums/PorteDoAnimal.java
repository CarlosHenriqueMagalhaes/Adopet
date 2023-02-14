package br.whitefox.tcc.adopet.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum PorteDoAnimal {
    GRANDE(1, "Porte grande"), MEDIO(2, "Porte médio"),PEQUENO(3,"Porte pequeno");
    private int cod;
    private String descricao;
    public Integer getCod() {
        return cod;
    }
    // Método
    public static PorteDoAnimal toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (PorteDoAnimal x : PorteDoAnimal.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + cod);
    }
}
