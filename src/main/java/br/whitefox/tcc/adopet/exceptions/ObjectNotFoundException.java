package br.whitefox.tcc.adopet.exceptions;
/**
 * Exception handling class
 * @author Carlos Magalhães
 * @since 1.0
 */
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
	public ObjectNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}