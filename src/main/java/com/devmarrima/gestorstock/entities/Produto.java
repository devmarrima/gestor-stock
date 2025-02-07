package com.devmarrima.gestorstock.entities;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	private String codigoOriginal;
	private String codigoFornecedor;
	private BigDecimal precoMedioCusto;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preco_atacado_id")
	private Preco precoAtacado;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "preco_balcao_id")
	private Preco precoBalcao;

	private String locacaoEstoque;

	@Column(columnDefinition = "TEXT")
	private String especificacoes;

	private int quantidadeMinima;
	private int quantidadeEstoque;
	private String aplicacao;
	private String linha;
	private String grupo;
	private String subgrupo;

	public Produto(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoOriginal() {
		return codigoOriginal;
	}

	public void setCodigoOriginal(String codigoOriginal) {
		this.codigoOriginal = codigoOriginal;
	}

	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(String codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}

	public BigDecimal getPrecoMedioCusto() {
		return precoMedioCusto;
	}

	public void setPrecoMedioCusto(BigDecimal precoMedioCusto) {
		this.precoMedioCusto = precoMedioCusto;
	}

	public Preco getPrecoAtacado() {
		return precoAtacado;
	}

	public void setPrecoAtacado(Preco precoAtacado) {
		this.precoAtacado = precoAtacado;
	}

	public Preco getPrecoBalcao() {
		return precoBalcao;
	}

	public void setPrecoBalcao(Preco precoBalcao) {
		this.precoBalcao = precoBalcao;
	}

	public String getLocacaoEstoque() {
		return locacaoEstoque;
	}

	public void setLocacaoEstoque(String locacaoEstoque) {
		this.locacaoEstoque = locacaoEstoque;
	}

	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(int quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(String subgrupo) {
		this.subgrupo = subgrupo;
	}
}
