package br.whitefox.tcc.adopet.domain.animal;

public record DetalhamentoAnimalComIdendificador(
        Integer id,
//        @NotBlank(message = "Selecione: CACHORRO, GATO, COELHO ou OUTROS")
        TipoDoAnimal raca,
//        @NotBlank(message = "Selecione: GRANDE, MEDIO ou PEQUENO")
        PorteDoAnimal porte
) {
    public DetalhamentoAnimalComIdendificador(Animal animal) {
        this(
                animal.getId(),
                animal.getRaca(),
                animal.getPorte());
    }
}
