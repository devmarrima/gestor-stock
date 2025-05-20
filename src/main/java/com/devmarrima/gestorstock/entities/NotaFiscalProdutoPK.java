package com.devmarrima.gestorstock.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@Embeddable
public class NotaFiscalProdutoPK implements Serializable {

    private UUID notaFiscal;
    private Long produto;

    public NotaFiscalProdutoPK () {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NotaFiscalProdutoPK that = (NotaFiscalProdutoPK) o;
        return Objects.equals(notaFiscal, that.notaFiscal) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notaFiscal, produto);
    }
}
