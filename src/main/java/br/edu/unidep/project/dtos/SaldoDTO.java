package br.edu.unidep.project.dtos;

import java.io.Serializable;

import br.edu.unidep.project.entities.Saldo;

public class SaldoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer codigoSaldo;
	private String descricao;
	private Boolean movimentaLote;
	
	public SaldoDTO() {
		super();
	}

	public SaldoDTO(Integer codigoSaldo, String descricao, Boolean movimentaLote) {
		super();
		this.codigoSaldo = codigoSaldo;
		this.descricao = descricao;
		this.movimentaLote = movimentaLote;
	}
	
	public SaldoDTO(Saldo saldo) {
		this.codigoSaldo = saldo.getCodigoSaldo();
		this.descricao = saldo.getDescricao();
		this.movimentaLote = saldo.getMovimentaLote();
	}

	public Integer getCodigoSaldo() {
		return codigoSaldo;
	}

	public void setCodigoSaldo(Integer codigoSaldo) {
		this.codigoSaldo = codigoSaldo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getMovimentaLote() {
		return movimentaLote;
	}

	public void setMovimentaLote(Boolean movimentaLote) {
		this.movimentaLote = movimentaLote;
	}
}
