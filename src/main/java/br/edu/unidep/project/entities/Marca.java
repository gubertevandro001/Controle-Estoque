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
@Table(name = "tb_marca")
public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoMarca;
	private String descricao;
	
	@OneToMany(mappedBy="marca")
	private List<Produto> produtos = new ArrayList<>();

	public Marca() {
	}

	public Marca(Integer codigoMarca, String descricao) {
		this.codigoMarca = codigoMarca;
		this.descricao = descricao;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
