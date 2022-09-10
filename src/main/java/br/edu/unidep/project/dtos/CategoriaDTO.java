package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.Categoria;

public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigoCategoria;
	private String descricao;
	

	public CategoriaDTO() {
	}

	public CategoriaDTO(Integer codigoCategoria, String descricao) {
		this.codigoCategoria = codigoCategoria;
		this.descricao = descricao;
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.codigoCategoria = categoria.getCodigoCategoria();
		this.descricao = categoria.getDescricao();
	}

	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
