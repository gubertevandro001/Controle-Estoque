package br.edu.unidep.project.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.edu.unidep.project.entities.Lote;
import br.edu.unidep.project.entities.Produto;

@Embeddable
public class ProdutoLotePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name="produto_id")
	private Produto codigoProduto;
	
	@OneToOne
	@JoinColumn(name="lote_id", unique = true)
	private Lote codigoLote;

	public Produto getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Produto codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Lote getCodigoLote() {
		return codigoLote;
	}

	public void setCodigoLote(Lote codigoLote) {
		this.codigoLote = codigoLote;
	}
}
