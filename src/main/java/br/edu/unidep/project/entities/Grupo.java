package br.edu.unidep.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_grupo")
public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoGrupo;
	private String descricao;

	@OneToMany(mappedBy="grupo")
	private List<Produto> produtos = new ArrayList<>();

	public Grupo() {
	}

	public Grupo(Integer codigoGrupo, String descricao) {
		this.codigoGrupo = codigoGrupo;
		this.descricao = descricao;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
