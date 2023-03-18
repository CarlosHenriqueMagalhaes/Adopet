package br.whitefox.tcc.adopet.domain.endereco;

public record DetalhamentoEndereco(
        Integer id,
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cep,
        String cidade,
        String estado
) {
    public DetalhamentoEndereco(Endereco endereco) {
        this(
                endereco.getId(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getEstado());
    }
}