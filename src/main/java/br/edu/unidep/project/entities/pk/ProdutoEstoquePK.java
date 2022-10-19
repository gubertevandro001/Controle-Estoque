package br.edu.unidep.project.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.edu.unidep.project.entities.Estoque;
import br.edu.unidep.project.entities.Produto;

@Embeddable
public class ProdutoEstoquePK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name="estoque_id")
	private Estoque codigoEstoque;
	
	@OneToOne
	@JoinColumn(name="produto_id")
	private Produto codigoProduto;

	public Estoque getCodigoEstoque() {
		return codigoEstoque;
	}

	public void setCodigoEstoque(Estoque codigoEstoque) {
		this.codigoEstoque = codigoEstoque;
	}

	public Produto getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Produto codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
}
