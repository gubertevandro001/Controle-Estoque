package br.edu.unidep.project.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.edu.unidep.project.entities.Estoque;
import br.edu.unidep.project.entities.Produto;
import br.edu.unidep.project.entities.Saldo;

@Embeddable
public class EstoqueSaldoPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name="produto_id")
	private Produto codigoProduto;
	
	@OneToOne
	@JoinColumn(name="saldo_id")
	private Saldo codigoSaldo;
	
	@OneToOne
	@JoinColumn(name="estoque_id")
	private Estoque codigoEstoque;

	public Produto getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Produto codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Saldo getCodigoSaldo() {
		return codigoSaldo;
	}

	public void setCodigoSaldo(Saldo codigoSaldo) {
		this.codigoSaldo = codigoSaldo;
	}

	public Estoque getCodigoEstoque() {
		return codigoEstoque;
	}

	public void setCodigoEstoque(Estoque codigoEstoque) {
		this.codigoEstoque = codigoEstoque;
	}
}
