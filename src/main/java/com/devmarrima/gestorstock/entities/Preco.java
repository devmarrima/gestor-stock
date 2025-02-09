package com.devmarrima.gestorstock.entities;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Preco")
public class Preco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal precoIndicado;
	private BigDecimal precoMinimo;

	@Enumerated(EnumType.STRING)
	private TipoPreco tipo;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataVigencia;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public Preco(Long id, BigDecimal precoIndicado, BigDecimal precoMinimo, TipoPreco tipo, Instant dataVigencia) {
		this.id = id;
		this.precoIndicado = precoIndicado;
		this.precoMinimo = precoMinimo;
		this.tipo = tipo;
		this.dataVigencia = dataVigencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrecoIndicado() {
		return precoIndicado;
	}

	public void setPrecoIndicado(BigDecimal precoIndicado) {
		this.precoIndicado = precoIndicado;
	}

	public BigDecimal getPrecoMinimo() {
		return precoMinimo;
	}

	public void setPrecoMinimo(BigDecimal precoMinimo) {
		this.precoMinimo = precoMinimo;
	}

	public Instant getDataVigencia() {
		return dataVigencia;
	}

	public void setDataVigencia(Instant dataVigencia) {
		this.dataVigencia = dataVigencia;
	}

	public String getDescricao() {
        return tipo != null ? tipo.getDescricao() : null;
    }

}
