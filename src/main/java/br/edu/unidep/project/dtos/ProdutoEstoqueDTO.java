package br.edu.unidep.project.dtos;

import br.edu.unidep.project.entities.ProdutoEstoque;

public class ProdutoEstoqueDTO {
	
	private Integer codigoEstoque;
	private Integer codigoProduto;
	
	public ProdutoEstoqueDTO() {
	}

	public ProdutoEstoqueDTO(Integer codigoEstoque, Integer codigoProduto) {
		super();
		this.codigoEstoque = codigoEstoque;
		this.codigoProduto = codigoProduto;
	}
	
	public ProdutoEstoqueDTO(ProdutoEstoque produtoEstoque) {
		super();
		this.codigoEstoque = produtoEstoque.getEstoque().getCodigoEstoque();
		this.codigoProduto = produtoEstoque.getProduto().getCodigoProduto();
	}

	public Integer getCodigoEstoque() {
		return codigoEstoque;
	}

	public void setCodigoEstoque(Integer codigoEstoque) {
		this.codigoEstoque = codigoEstoque;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

}
