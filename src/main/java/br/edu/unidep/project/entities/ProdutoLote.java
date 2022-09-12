package br.edu.unidep.project.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.unidep.project.entities.pk.ProdutoLotePK;

@Entity
@Table(name="tb_produto_lote")
public class ProdutoLote implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProdutoLotePK produtoLotePK = new ProdutoLotePK();
	
	public ProdutoLote() {
	}
	
	public ProdutoLote(Produto produto, Lote lote) {
		produtoLotePK.setCodigoProduto(produto);
		produtoLotePK.setCodigoLote(lote);
	}
	
	public Produto getProduto() {
		return produtoLotePK.getCodigoProduto();
	}
	
	public void setProduto(Produto produto) {
		produtoLotePK.setCodigoProduto(produto);
	}
	
	public Lote getLote() {
		return produtoLotePK.getCodigoLote();
	}
	
	public void setLote(Lote lote) {
		produtoLotePK.setCodigoLote(lote);
	}
}
