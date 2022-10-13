package br.edu.unidep.project.entities;

import java.io.Serializable;
import java.lang.annotation.Repeatable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

@Entity
@Table(name ="tb_lote")
public class Lote implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoLote;
	private String descricao;
	
	
	@ManyToOne
	@JoinColumn(name="codigo_produto")
	private Produto codigoProduto;
	
	
	private Double quantidade;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dataValidade;
	

	public Lote() {
	}

	public Lote(Integer codigoLote, String descricao, Produto codigoProduto, Double quantidade, Date dataValidade) {
		super();
		this.codigoLote = codigoLote;
		this.descricao = descricao;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.dataValidade = dataValidade;
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

	public Produto getProduto() {
		return codigoProduto;
	}

	public void setProduto(Produto codigoProduto) {
		this.codigoProduto = codigoProduto;
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
