package com.devmarrima.gestorstock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "tb_nota_fiscal")
@Setter
@Getter
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String serie;
    private String chave;
    @Temporal(TemporalType.DATE)
    private LocalDate dataEmissao;
    @Temporal(TemporalType.DATE)
    private LocalDate dataEntrada;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    private double valorTotal;
    @OneToMany(mappedBy = "id.notaFiscal")
    private List<NotaFiscalProduto> produtos = new ArrayList<>();

    public NotaFiscal(Long id, String numero, String serie, String chave, LocalDate dataEmissao, LocalDate dataEntrada, Fornecedor fornecedor, double valorTotal, List<NotaFiscalProduto> produtos) {
        this.id = id;
        this.numero = numero;
        this.serie = serie;
        this.chave = chave;
        this.dataEmissao = dataEmissao;
        this.dataEntrada = dataEntrada;
        this.fornecedor = fornecedor;
        this.valorTotal = valorTotal;
        this.produtos = produtos;
    }
}
