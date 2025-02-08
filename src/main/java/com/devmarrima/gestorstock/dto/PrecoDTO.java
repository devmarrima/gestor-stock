package com.devmarrima.gestorstock.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.devmarrima.gestorstock.entities.Preco;
import com.devmarrima.gestorstock.entities.TipoPreco;


public class PrecoDTO {

	private Long id;
	private BigDecimal precoIndicado;
	private BigDecimal precoMinimo;
	private TipoPreco tipo;
	private Instant dataVigencia;
    
    public PrecoDTO(Long id, BigDecimal precoIndicado, BigDecimal precoMinimo, TipoPreco tipo, Instant dataVigencia) {
        this.id = id;
        this.precoIndicado = precoIndicado;
        this.precoMinimo = precoMinimo;
        this.tipo = tipo;
        this.dataVigencia = dataVigencia;
    }

    public PrecoDTO(Preco preco) {
        this.id = preco.getId();
        this.precoIndicado = preco.getPrecoIndicado();
        this.precoMinimo = preco.getPrecoMinimo();
        this.tipo = TipoPreco.fromDescricao(preco.getDescricao());
        this.dataVigencia = preco.getDataVigencia();
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

    public TipoPreco getTipo() {
        return tipo;
    }

    public void setTipo(TipoPreco tipo) {
        this.tipo = tipo;
    }

    public Instant getDataVigencia() {
        return dataVigencia;
    }

    public void setDataVigencia(Instant dataVigencia) {
        this.dataVigencia = dataVigencia;
    }

    
}
