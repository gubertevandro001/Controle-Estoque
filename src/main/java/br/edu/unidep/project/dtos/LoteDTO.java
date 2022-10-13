package br.edu.unidep.project.dtos;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import br.edu.unidep.project.entities.Lote;

public class LoteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codigoLote;
	private String descricao;
	private Integer codigoProduto;
	private Double quantidade;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataValidade;
	
	public LoteDTO() {
		super();
	}

	public LoteDTO(Integer codigoLote, String descricao, Integer codigoProduto, Double quantidade,
			Date dataValidade) {
		super();
		this.codigoLote = codigoLote;
		this.descricao = descricao;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.dataValidade = dataValidade;
	}

	public LoteDTO(Lote lote) {
		this.codigoLote = lote.getCodigoLote();
		this.descricao = lote.getDescricao();
		this.codigoProduto = lote.getProduto().getCodigoProduto();
		this.quantidade = lote.getQuantidade();
		this.dataValidade = lote.getDataValidade();
	}

	public Integer getCodigoLote() {
		return codigoLote;
	}

	public void setCodigoLote(Integer codigoLote) {
		this.codigoLote = codigoLote;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Integer produto) {
		this.codigoProduto = produto;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

}
