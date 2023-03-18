package br.whitefox.tcc.adopet.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratamentoParaErroDeValidacao(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ModeloDeRetornoPadraoParaException> tratamentoErroNomeDuplicado (SQLIntegrityConstraintViolationException exception, HttpServletRequest request){
        ModeloDeRetornoPadraoParaException erro = new ModeloDeRetornoPadraoParaException(HttpStatus.BAD_REQUEST.value(), "Erro de validação: Duplicidade de dados");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
