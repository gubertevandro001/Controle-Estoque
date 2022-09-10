package br.edu.unidep.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoProduto;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="grupo_id")
	private Grupo grupo;
	
	@ManyToOne
	@JoinColumn(name="departamento_id")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name="marca_id")
	private Marca marca;

	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tb_produto_lote",  joinColumns = {@JoinColumn(name="codigo_produto")}, inverseJoinColumns = {@JoinColumn(name="codigo_lote")})
	private List<Lote> lotes;
	
	private String codigoReferencia;
	private String codigoBarras;
	private Double custoAquisicao;
	private Double precoVenda;
	
	public Produto() {
	}

	public Produto(Integer codigoProduto, String descricao, Categoria categoria, Grupo grupo, Departamento departamento,
			Marca marca, String codigoReferencia, String codigoBarras, Double custoAquisicao, Double precoVenda) {
		super();
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.categoria = categoria;
		this.grupo = grupo;
		this.departamento = departamento;
		this.marca = marca;
		this.codigoReferencia = codigoReferencia;
		this.codigoBarras = codigoBarras;
		this.custoAquisicao = custoAquisicao;
		this.precoVenda = precoVenda;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Double getCustoAquisicao() {
		return custoAquisicao;
	}

	public void setCustoAquisicao(Double custoAquisicao) {
		this.custoAquisicao = custoAquisicao;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}	
}
