package br.edu.unidep.project.controllers.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String erro;
	
	public StandardError() {
		super();
	}

	public StandardError(Long timestamp, Integer status, String erro) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.erro = erro;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
}
