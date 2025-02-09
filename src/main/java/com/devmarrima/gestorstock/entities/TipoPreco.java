package com.devmarrima.gestorstock.entities;

public enum TipoPreco {
    ATACADO("Atacado"),
    BALCAO("Balcão");

    private final String descricao;

	// Construtor
    TipoPreco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoPreco fromDescricao(String descricao) {
        for (TipoPreco tipo : TipoPreco.values()) {
            if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }
      /*  public static List<TipoPreco> obterLista() {
        List<TipoPreco> lista = new ArrayList<>();
        for (TipoPreco tipo : TipoPreco.values()) {
            lista.add(tipo);
        }
        return lista; */


    }

