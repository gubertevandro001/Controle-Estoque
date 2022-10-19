package br.edu.unidep.project.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.unidep.project.entities.pk.EstoqueSaldoPK;

@Entity
@Table(name = "tb_estoque_saldo")
public class EstoqueSaldo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EstoqueSaldoPK estoqueSaldoPK = new EstoqueSaldoPK();
	private Double quantidade;
	
	public EstoqueSaldo() {
	}

	public EstoqueSaldo(Produto produto, Saldo saldo, Estoque estoque, Double quantidade) {
		estoqueSaldoPK.setCodigoProduto(produto);
		estoqueSaldoPK.setCodigoSaldo(saldo);
		estoqueSaldoPK.setCodigoEstoque(estoque);
		this.quantidade = quantidade;
	}
	
	public Produto getProduto() {
		return estoqueSaldoPK.getCodigoProduto();
	}
	
	public void setProduto(Produto produto) {
		estoqueSaldoPK.setCodigoProduto(produto);;
	}
	
	public Saldo getSaldo() {
		return estoqueSaldoPK.getCodigoSaldo();
	}
	
	public void setSaldo(Saldo saldo) {
		estoqueSaldoPK.setCodigoSaldo(saldo);;
	}
	
	public Estoque getEstoque() {
		return estoqueSaldoPK.getCodigoEstoque();
	}
	
	public void setEstoque(Estoque estoque) {
		estoqueSaldoPK.setCodigoEstoque(estoque);;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
}
