package com.devmarrima.gestorstock.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name="tb_item_nota_fiscal")
@Data
public class ItemNotaFiscal {
	@Id
	@Column(name="ITN_ID")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name ="NF_ID")
	private NotaFiscal notaFiscal;
	
	@ManyToOne
	@JoinColumn(name= "produto_id")
	private Produto produto;
	
	@Column(name ="ITN_QUANTIDADE")
	private Integer quantidade;
	
	@Column(name = "ITN_VALORUNITARIO")
	private BigDecimal valorUnitario;
	
	@Column(name="ITN_VALORTOTAL)")
	private BigDecimal valorTotal;

	public ItemNotaFiscal(Long id, NotaFiscal notaFiscal, Produto produto, Integer quantidade, BigDecimal valorUnitario,
			BigDecimal valorTotal) {
		this.id = id;
		this.notaFiscal = notaFiscal;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}

	public ItemNotaFiscal() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	

	
}
