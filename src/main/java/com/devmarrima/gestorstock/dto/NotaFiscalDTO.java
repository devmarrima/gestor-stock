package com.devmarrima.gestorstock.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.devmarrima.gestorstock.entities.ItemNotaFiscal;
import com.devmarrima.gestorstock.entities.NotaFiscal;

import lombok.Data;

@Data
public class NotaFiscalDTO {

	private Long id;
	private String numero;
	private String serie;
	private String dataEmissao;
	private BigDecimal valorTotal;
	private String observacoes;
	private String chaveAcesso;
	private String statusNota;
	private List<ItemNotaFiscalDTO> itens;

	public NotaFiscalDTO(NotaFiscal entity) {
		this.id = entity.getId();
		this.numero = entity.getNumero();
		this.serie = entity.getSerie();
		this.dataEmissao = entity.getDataEmissao();
		this.valorTotal = entity.getValorTotal();
		this.observacoes = entity.getObservacoes();
		this.chaveAcesso = entity.getChaveAcesso();
		this.statusNota = entity.getStatusNota();

		// Converte os itens, se necessário
		this.itens = entity.getItens().stream()
				.map(ItemNotaFiscalDTO::new)
				.collect(Collectors.toList());
	}
	

	public NotaFiscalDTO() {
	
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getChaveAcesso() {
		return chaveAcesso;
	}

	public void setChaveAcesso(String chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}

	public String getStatusNota() {
		return statusNota;
	}

	public void setStatusNota(String statusNota) {
		this.statusNota = statusNota;
	}

	public List<ItemNotaFiscalDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemNotaFiscalDTO> itens) {
		this.itens = itens;
	}
	

	
}
