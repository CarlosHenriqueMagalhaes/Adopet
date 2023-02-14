package br.whitefox.tcc.adopet.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TipoDoAnimal {

    CACHORRO(1, "Cachorro"), GATO(2, "Gato"), COELHO(3,"Coelho"), OUTROS(4,"Outros");

    private int cod;
    private String descricao;
    public Integer getCod() {
        return cod;
    }

    // Método
    public static TipoDoAnimal toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (TipoDoAnimal x : TipoDoAnimal.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido " + cod);
    }
}

