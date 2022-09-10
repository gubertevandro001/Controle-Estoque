package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.Grupo;

public class GrupoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigoGrupo;
	private String descricao;
	
	public GrupoDTO() {
		super();
	}

	public GrupoDTO(Integer codigoGrupo, String descricao) {
		super();
		this.codigoGrupo = codigoGrupo;
		this.descricao = descricao;
	};
	
	public GrupoDTO(Grupo grupo) {
		this.codigoGrupo = grupo.getCodigoGrupo();
		this.descricao = grupo.getDescricao();
	}

	public Integer getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(Integer codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
