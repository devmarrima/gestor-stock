package com.devmarrima.gestorstock.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.devmarrima.gestorstock.entities.Produto;

public class ProdutoDTO {

	private Long id;
	private String descricao;
	private String codigoOriginal;
	private String codigoFornecedor;
	private BigDecimal precoMedioCusto;
	private String locacaoEstoque;
	private String especificacoes;
	private int quantidadeMinima;
	private int quantidadeEstoque;
	private String aplicacao;
	private String linha;
	private String grupo;
	private String subgrupo;

    private List<PrecoDTO> precos;
    
    
    
    public ProdutoDTO() {

	}

	public ProdutoDTO(Long id, String descricao, String codigoOriginal, String codigoFornecedor,
            BigDecimal precoMedioCusto, String locacaoEstoque, String especificacoes, int quantidadeMinima,
            int quantidadeEstoque, String aplicacao, String linha, String grupo, String subgrupo, List<PrecoDTO> precos) {
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
        this.precos = precos;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.codigoOriginal = produto.getCodigoOriginal();
        this.codigoFornecedor = produto.getCodigoFornecedor();
        this.precoMedioCusto = produto.getPrecoMedioCusto();
        this.locacaoEstoque = produto.getLocacaoEstoque();
        this.especificacoes = produto.getEspecificacoes();
        this.quantidadeMinima = produto.getQuantidadeMinima();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.aplicacao = produto.getAplicacao();
        this.linha = produto.getLinha();
        this.grupo = produto.getGrupo();
        this.subgrupo = produto.getSubgrupo();
        this.precos = produto.getPrecos().stream()
                             .map(PrecoDTO::new)
                             .collect(Collectors.toList());
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

    public List<PrecoDTO> getPrecos() {
        return precos;
    }

    public void setPrecos(List<PrecoDTO> precos) {
        this.precos = precos;
    }



    
}
