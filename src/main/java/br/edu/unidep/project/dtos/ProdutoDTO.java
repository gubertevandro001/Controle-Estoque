package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.Produto;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer codigoProduto;
	private String descricao;
	private Integer codigoCategoria;
	private Integer codigoGrupo;
	private Integer codigoDepartamento;
	private Integer codigoMarca;
	private String codigoReferencia;
	private String codigoBarras;
	private Double custoAquisicao;
	private Double precoVenda;

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Integer codigoProduto, String descricao, Integer codigoCategoria, Integer codigoGrupo, Integer codigoDepartamento,
			Integer codigoMarca, String codigoReferencia, String codigoBarras, Double custoAquisicao, Double precoVenda) {
		super();
		this.codigoProduto = codigoProduto;
		this.descricao = descricao;
		this.codigoCategoria = codigoCategoria;
		this.codigoGrupo = codigoGrupo;
		this.codigoDepartamento = codigoDepartamento;
		this.codigoMarca = codigoMarca;
		this.codigoReferencia = codigoReferencia;
		this.codigoBarras = codigoBarras;
		this.custoAquisicao = custoAquisicao;
		this.precoVenda = precoVenda;
	}

	public ProdutoDTO(Produto produto) {
		this.codigoProduto = produto.getCodigoProduto();
		this.descricao = produto.getDescricao();
		this.codigoCategoria = produto.getCategoria().getCodigoCategoria();
		this.codigoGrupo = produto.getGrupo().getCodigoGrupo();
		this.codigoDepartamento = produto.getDepartamento().getCodigoDepartamento();
		this.codigoMarca = produto.getMarca().getCodigoMarca();
		this.codigoReferencia = produto.getCodigoReferencia();
		this.codigoBarras = produto.getCodigoBarras();
		this.custoAquisicao = produto.getCustoAquisicao();
		this.precoVenda = produto.getPrecoVenda();
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

	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Integer getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(Integer grupo) {
		this.codigoGrupo = grupo;
	}

	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public void setCodigoDepartamento(Integer codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}

	public Integer getCodigoMarca() {
		return codigoMarca;
	}

	public void setCodigoMarca(Integer codigoMarca) {
		this.codigoMarca = codigoMarca;
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
