package com.devmarrima.gestorstock.dto;

import java.util.UUID;

public record CreateAcertoEstoqueDTO(
        Long cod_produto,
        String operacao,
        Integer quantidade,
        String observacao
) {}
