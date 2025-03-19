package com.devmarrima.gestorstock.entities;

import com.devmarrima.gestorstock.services.ProdutoService;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Table(name = "tb_acerto_estoque")
public class AcertoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long codProduto;
    private String descricao;
    private String operacao;
    private Integer quantidade;
    private String observacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataHoraCriacao;


    public AcertoEstoque() {
    }

    public AcertoEstoque(UUID id, Long codProduto, String descricao, String operacao, Integer quantidade, String observacao) {
        ProdutoService pdService = new ProdutoService();

        this.id = id;
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.operacao = operacao;
        this.quantidade = quantidade;
        this.observacao = observacao;
        this.dataHoraCriacao = Calendar.getInstance();
    }

    public UUID getId() {
        return id;
    }

    public Long getCodProduto() {
        return codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getOperacao() {
        return operacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCodProduto(Long codProduto) {
        this.codProduto = codProduto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Calendar getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(Calendar dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
}
