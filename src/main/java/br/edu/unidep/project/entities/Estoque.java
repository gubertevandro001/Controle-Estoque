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
@Table(name = "tb_estoque")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoEstoque;
	private String descricao;
	
	@OneToMany(mappedBy="estoquePadrao")
	private List<Produto> produtos = new ArrayList<>();
	
	
	public Estoque() {
		super();
	}

	public Estoque(Integer codigoEstoque, String descricao) {
		super();
		this.codigoEstoque = codigoEstoque;
		this.descricao = descricao;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
