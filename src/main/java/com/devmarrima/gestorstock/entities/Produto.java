package com.devmarrima.gestorstock.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TEXT")
	private String descricao;

	private String codigoOriginal;
	private String codigoFornecedor;
	private BigDecimal precoMedioCusto;
	private String locacaoEstoque;

	@Column(columnDefinition = "TEXT")
	private String especificacoes;

	private int quantidadeMinima;
	private int quantidadeEstoque;
	private String aplicacao;
	private String linha;
	private String grupo;
	private String subgrupo;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Preco> precos = new ArrayList<>();

	public Produto() {

	}

	public Produto(Long id, String descricao, String codigoOriginal, String codigoFornecedor,
			BigDecimal precoMedioCusto, String locacaoEstoque, String especificacoes, int quantidadeMinima,
			int quantidadeEstoque, String aplicacao, String linha, String grupo, String subgrupo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigoOriginal = codigoOriginal;
		this.codigoFornecedor = codigoFornecedor;
		this.precoMedioCusto = precoMedioCusto;
		this.locacaoEstoque = locacaoEstoque;
		this.especificacoes = especificacoes;
		this.quantidadeMinima = quantidadeMinima;
		this.quantidadeEstoque = quantidadeEstoque;
		this.aplicacao = aplicacao;
		this.linha = linha;
		this.grupo = grupo;
		this.subgrupo = subgrupo;
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

	public List<Preco> getPrecos() {
		return precos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
