package br.whitefox.tcc.adopet.domain.animal;

public record DetalhamentoAnimal(
//        @NotBlank(message = "Selecione: CACHORRO, GATO, COELHO ou OUTROS")
        TipoDoAnimal raca,
//        @NotBlank(message = "Selecione: GRANDE, MEDIO ou PEQUENO")
        PorteDoAnimal porte
) {
    public DetalhamentoAnimal(Animal animal) {
        this(
                animal.getRaca(),
                animal.getPorte());
    }
}
