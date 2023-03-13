package br.whitefox.tcc.adopet.exceptions;

import java.io.Serializable;

/**
 * Exception handling class
 * @author Carlos Magalhães
 * @since 1.0
 */
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String mensagem;

	/**
	 *Constructors
	 */
	public StandardError() {
	}
	public StandardError(Integer status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}

	/**
	 *Getters and setters
	 */
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
