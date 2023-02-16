package br.whitefox.tcc.adopet.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Principal Exception handling class
 * @author Carlos Magalhães
 * @since 1.0
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * For object not found:
	 * @param e
	 * @param request
	 * @return message declared in the method
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}