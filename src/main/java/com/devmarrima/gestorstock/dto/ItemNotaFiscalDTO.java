package com.devmarrima.gestorstock.dto;

import java.math.BigDecimal;

import com.devmarrima.gestorstock.entities.ItemNotaFiscal;
import com.devmarrima.gestorstock.entities.Produto;


public class ItemNotaFiscalDTO {

    private Long id;
    private Long produtoId;
    private String descricaoProduto;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;

    
    public ItemNotaFiscalDTO(Long id, Long produtoId, String descricaoProduto, Integer quantidade,
			BigDecimal valorUnitario, BigDecimal valorTotal) {
		
		this.id = id;
		this.produtoId = produtoId;
		this.descricaoProduto = descricaoProduto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}

	public ItemNotaFiscalDTO(ItemNotaFiscal entity) {
        this.id = entity.getId();
        
        Produto produto = entity.getProduto();
        if (produto != null) {
            this.produtoId = produto.getId();
            this.descricaoProduto = produto.getDescricao(); 
        }

        this.quantidade = entity.getQuantidade();
        this.valorUnitario = entity.getValorUnitario();
        this.valorTotal = entity.getValorTotal();
    }
	
	
	public ItemNotaFiscal toEntity() {
	    ItemNotaFiscal item = new ItemNotaFiscal();

	    item.setId(this.id);
	    item.setQuantidade(this.quantidade);
	    item.setValorUnitario(this.valorUnitario);
	    item.setValorTotal(this.valorTotal);

	    if (this.produtoId != null) {
	        Produto produto = new Produto();
	        produto.setId(this.produtoId);
	        // Apenas o ID é setado, o restante pode vir do banco via JPA se necessário
	        item.setProduto(produto);
	    }

	    return item;
	}
	

	public ItemNotaFiscalDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
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
