package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.EstoqueSaldo;

public class EstoqueSaldoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigoProduto;
	private Integer codigoSaldo;
	private Integer codigoEstoque;
	private Double quantidade;
	
	public EstoqueSaldoDTO() {
		
	}

	public EstoqueSaldoDTO(Integer codigoProduto, Integer codigoSaldo, Integer codigoEstoque, Double quantidade) {
		super();
		this.codigoProduto = codigoProduto;
		this.codigoSaldo = codigoSaldo;
		this.codigoEstoque = codigoEstoque;
		this.quantidade = quantidade;
	}
	
	public EstoqueSaldoDTO(EstoqueSaldo estoqueSaldo) {
		super();
		this.codigoProduto = estoqueSaldo.getProduto().getCodigoProduto();
		this.codigoSaldo = estoqueSaldo.getSaldo().getCodigoSaldo();
		this.codigoEstoque = estoqueSaldo.getEstoque().getCodigoEstoque();
		this.quantidade = estoqueSaldo.getQuantidade();
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Integer getCodigoSaldo() {
		return codigoSaldo;
	}

	public void setCodigoSaldo(Integer codigoSaldo) {
		this.codigoSaldo = codigoSaldo;
	}

	public Integer getCodigoEstoque() {
		return codigoEstoque;
	}

	public void setCodigoEstoque(Integer codigoEstoque) {
		this.codigoEstoque = codigoEstoque;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
}
