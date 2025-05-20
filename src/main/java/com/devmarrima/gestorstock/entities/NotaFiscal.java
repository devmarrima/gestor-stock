package com.devmarrima.gestorstock.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name = "tb_nota_fiscal")
@Data // Está anotação gerar os construtores e os getters e setters
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "NF_ID")
	private Long id;
	
	//Column define o nome da tabela no banco
	@Column(name ="NF_NUMERO", nullable=false) 
	private String numero;
	
	@Column(name ="NF_SERIE", nullable=false)
	private String serie;
	
	@Column(name ="NF_DATAEMISSAO", nullable=false)
	private String dataEmissao;
	
	@Column(name ="NF_VALORTOTAL", nullable=false)
	private BigDecimal valorTotal;
	
	
	//Um fornecedor pode ter várias notas fiscais
	@ManyToOne
	
	private Fornecedor fornecedor;

	
	// Referência o atributo da outra classe chamado 'notafisca e se uma nota for apagada os items são removidos
	@OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL, orphanRemoval = true) 
    private List<ItemNotaFiscal> itens = new ArrayList<>();
	
	@Column(name="NF_OBSERVACOES")
	private String observacoes;
	
	@Column(name="NF_CHAVEACESSO")
	private String chaveAcesso;
	
	@Column(name = "NF_STATUSNOTA")
	private String statusNota;
	

	public NotaFiscal(Long id, String numero, String serie, String dataEmissao, BigDecimal valorTotal,
			Fornecedor fornecedor, List<ItemNotaFiscal> itens, String observacoes, String chaveAcesso,
			String statusNota) {
		super();
		this.id = id;
		this.numero = numero;
		this.serie = serie;
		this.dataEmissao = dataEmissao;
		this.valorTotal = valorTotal;
		this.fornecedor = fornecedor;
		this.itens = itens;
		this.observacoes = observacoes;
		this.chaveAcesso = chaveAcesso;
		this.statusNota = statusNota;
	}
	

	public NotaFiscal() {
		
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

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<ItemNotaFiscal> getItens() {
		return itens;
	}

	public void setItens(List<ItemNotaFiscal> itens) {
		this.itens = itens;
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
	
	
	
	
	
	
	
}
