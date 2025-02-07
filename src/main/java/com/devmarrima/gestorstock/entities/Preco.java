package com.devmarrima.gestorstock.entities;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_preco")
public class Preco {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private BigDecimal precoIndicado;
	private BigDecimal precoMinimo;
	
    @OneToOne(mappedBy = "precoAtacado")
    private Produto produtoAtacado;

    @OneToOne(mappedBy = "precoBalcao")
    private Produto produtoBalcao;

	public Preco(BigDecimal precoIndicado, BigDecimal precoMinimo) {
		this.precoIndicado = precoIndicado;
		this.precoMinimo = precoMinimo;
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
	
}
