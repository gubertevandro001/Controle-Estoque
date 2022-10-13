package br.edu.unidep.project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_saldo")
public class Saldo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoSaldo;
	private String descricao;
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private Boolean movimentaLote;
	
	public Saldo() {
		super();
	}

	public Saldo(Integer codigoSaldo, String descricao, Boolean movimentaLote) {
		super();
		this.codigoSaldo = codigoSaldo;
		this.descricao = descricao;
		this.movimentaLote = movimentaLote;
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
