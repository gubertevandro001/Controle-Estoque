package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.Marca;

public class MarcaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigoMarca;
	private String descricao;
	
	public MarcaDTO() {
		super();
	}

	public MarcaDTO(Integer codigoMarca, String descricao) {
		super();
		this.codigoMarca = codigoMarca;
		this.descricao = descricao;
	};
	
	public MarcaDTO(Marca marca) {
		this.codigoMarca = marca.getCodigoMarca();
		this.descricao = marca.getDescricao();
	}

	public Integer getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(Integer codigoMarca) {
		this.codigoMarca = codigoMarca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
