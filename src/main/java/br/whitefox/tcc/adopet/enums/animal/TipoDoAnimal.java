package br.whitefox.tcc.adopet.enums.animal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum TipoDoAnimal {

    CACHORRO( "Cachorro"), GATO( "Gato"), COELHO("Coelho"), OUTROS("Outros");
    private String descricao;
}

