package br.edu.unidep.project.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.unidep.project.entities.pk.ProdutoEstoquePK;

@Entity
@Table(name = "tb_produto_estoque")
public class ProdutoEstoque implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProdutoEstoquePK produtoEstoquePK = new ProdutoEstoquePK();
	
	public ProdutoEstoque() {
	}
	
	public ProdutoEstoque(Estoque estoque, Produto produto) {
		produtoEstoquePK.setCodigoEstoque(estoque);
		produtoEstoquePK.setCodigoProduto(produto);
	}

	public void setEstoque(Estoque estoque) {
		produtoEstoquePK.setCodigoEstoque(estoque);
	}
	
	public Estoque getEstoque() {
		return produtoEstoquePK.getCodigoEstoque();
	}
	
	public void setProduto(Produto produto) {
		produtoEstoquePK.setCodigoProduto(produto);
	}
	
	public Produto getProduto() {
		return produtoEstoquePK.getCodigoProduto();
	}
}
