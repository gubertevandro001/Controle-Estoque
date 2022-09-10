package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.Departamento;

public class DepartamentoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigoDepartamento;
	private String descricao;
	
	
	public DepartamentoDTO() {
	}

	public DepartamentoDTO(Integer codigoDepartamento, String descricao) {
		super();
		this.codigoDepartamento = codigoDepartamento;
		this.descricao = descricao;
	}
	
	public DepartamentoDTO(Departamento departamento) {
		this.codigoDepartamento = departamento.getCodigoDepartamento();
		this.descricao = departamento.getDescricao();
	}

	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(Integer codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
