package br.edu.unidep.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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

	@OneToMany(mappedBy="codigoProduto")
	private List<Lote> lotes;
	
	@ManyToOne
	@JoinColumn(name="estoque_padrao_id")
	private Estoque estoquePadrao;
	
	@ManyToMany(mappedBy="produtos")
	private List<Estoque> outrosEstoques = new ArrayList<>();
	
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean usaControleDeLote;
	private String codigoReferencia;
	private String codigoBarras;
	@Column(updatable = false)
	private Double quantidade;
	private Double custoAquisicao;
	private Double precoVenda;
	
	public Produto() {
	}

	public Produto(Integer codigoProduto, String descricao, Categoria categoria, Grupo grupo, Departamento departamento,
			Marca marca, Estoque estoquePadrao, List<Estoque> outrosEstoques, boolean usaControleDeLote, String codigoReferencia, String codigoBarras, Double quantidade,
			Double custoAquisicao, Double precoVenda) {
		super();
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.categoria = categoria;
		this.grupo = grupo;
		this.departamento = departamento;
		this.marca = marca;
		this.estoquePadrao = estoquePadrao;
		this.outrosEstoques = outrosEstoques;
		this.usaControleDeLote = usaControleDeLote;
		this.codigoReferencia = codigoReferencia;
		this.codigoBarras = codigoBarras;
		this.quantidade = quantidade;
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

	public boolean isUsaControleDeLote() {
		return usaControleDeLote;
	}

	public void setUsaControleDeLote(boolean usaControleDeLote) {
		this.usaControleDeLote = usaControleDeLote;
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

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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

	public Estoque getEstoquePadrao() {
		return estoquePadrao;
	}

	public void setEstoquePadrao(Estoque estoquePadrao) {
		this.estoquePadrao = estoquePadrao;
	}

	public List<Estoque> getOutrosEstoques() {
		return outrosEstoques;
	}

	public void setOutrosEstoques(List<Estoque> outrosEstoques) {
		this.outrosEstoques = outrosEstoques;
	}
	
	public void adicionarEstoque(Estoque estoque) {
		this.outrosEstoques.add(estoque);
	}
	
	public void adicionarEstoquePadrao(Estoque estoque) {
		List<Estoque> estoquePadrao = new ArrayList<>();
		estoquePadrao.add(estoque);
	}
}
