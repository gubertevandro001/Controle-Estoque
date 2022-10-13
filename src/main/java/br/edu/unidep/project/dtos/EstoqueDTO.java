package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.Estoque;

public class EstoqueDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigoEstoque;
	private String descricao;
	
	public EstoqueDTO() {
		super();
	}

	public EstoqueDTO(Integer codigoEstoque, String descricao) {
		super();
		this.codigoEstoque = codigoEstoque;
		this.descricao = descricao;
	}
	
	public EstoqueDTO(Estoque estoque) {
		this.codigoEstoque = estoque.getCodigoEstoque();
		this.descricao = estoque.getDescricao();
	}

	public Integer getCodigoEstoque() {
		return codigoEstoque;
	}

	public void setCodigoEstoque(Integer codigoEstoque) {
		this.codigoEstoque = codigoEstoque;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
