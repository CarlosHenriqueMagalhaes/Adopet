package br.whitefox.tcc.adopet.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

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

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ModeloDeRetornoPadraoParaException> regidtroNaoEncontrado (NoSuchElementException exception, HttpServletRequest request){
        ModeloDeRetornoPadraoParaException erro = new ModeloDeRetornoPadraoParaException(HttpStatus.NOT_FOUND.value(), "Registro não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ModeloDeRetornoPadraoParaException> tipoEnumParaAnimaisNaoExistenteSelecionadoNoCadastro (HttpMessageNotReadableException exception, HttpServletRequest request){
        ModeloDeRetornoPadraoParaException erro = new ModeloDeRetornoPadraoParaException(HttpStatus.BAD_REQUEST.value(), "Dados de entrada inválidos");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ModeloDeRetornoPadraoParaException> buscaInvalidaNaUrlParaOsEnumsAnimal (MethodArgumentTypeMismatchException exception, HttpServletRequest request){
        ModeloDeRetornoPadraoParaException erro = new ModeloDeRetornoPadraoParaException(HttpStatus.BAD_REQUEST.value(), "Busca na URL inválida");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
