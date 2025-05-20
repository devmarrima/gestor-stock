package com.devmarrima.gestorstock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="tb_nota_fiscal_produto")
public class NotaFiscalProduto {

    @EmbeddedId
    private NotaFiscalProdutoPK id = new NotaFiscalProdutoPK();

    @ManyToOne
    @MapsId("notaFiscal")
    @JoinColumn(name = "nota_fiscal_id")
    private NotaFiscal notaFiscal;

    @ManyToOne
    @MapsId("produto")
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private int quantidade;
    private double preco;
    // acrescentar outras atributos de partes fiscais


    public NotaFiscalProduto(NotaFiscal notaFiscal, Produto produto, int quantidade, double preco) {
//        id.setNotaFiscal(notaFiscal);
//        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

//    public NotaFiscal getNotaFiscal () {
//        return id.getNotaFiscal();
//    }
//
//    public void setNotaFiscal(NotaFiscal notaFiscal) {
//        id.setNotaFiscal(notaFiscal);
//    }
//
//    public void setProduto(Produto produto) {
//        id.setProduto(produto);
//    }
//
//    public Produto getProduto () {
//        return id.getProduto();
//    }

}
