package br.whitefox.tcc.adopet.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Principal Exception handling class
 * @author Carlos Magalhães
 * @since 1.0
 */
@RestControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * For object not found:
	 * @param exception
	 * @param request
	 * @return message declared in the method
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request) {
		StandardError erro = new StandardError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<StandardError> tratamentoErroNomeDuplicado (SQLIntegrityConstraintViolationException exception, HttpServletRequest request){
		StandardError erro = new StandardError(HttpStatus.BAD_REQUEST.value(), "Erro de validação: Duplicidade de dados");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}