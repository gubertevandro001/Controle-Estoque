package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.ProdutoLote;

public class ProdutoLoteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer codigoProduto;
	private Integer codigoLote;
	
	public ProdutoLoteDTO() {
	}
	
	public ProdutoLoteDTO(Integer codigoProduto, Integer codigoLote) {
		super();
		this.codigoProduto = codigoProduto;
		this.codigoLote = codigoLote;
	}
	
	public ProdutoLoteDTO(ProdutoLote produtoLote) {
		this.codigoProduto = produtoLote.getProduto().getCodigoProduto();
		this.codigoLote = produtoLote.getLote().getCodigoLote();
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getCodigoLote() {
		return codigoLote;
	}

	public void setCodigoLote(Integer codigoLote) {
		this.codigoLote = codigoLote;
	}
	
}
