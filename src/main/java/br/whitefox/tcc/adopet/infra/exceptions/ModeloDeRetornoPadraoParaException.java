package br.whitefox.tcc.adopet.infra.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModeloDeRetornoPadraoParaException implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer status;
    private String mensagem;
}
