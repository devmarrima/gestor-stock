package com.devmarrima.gestorstock.services;

import com.devmarrima.gestorstock.dto.CreateAcertoEstoqueDTO;
import com.devmarrima.gestorstock.entities.AcertoEstoque;
import com.devmarrima.gestorstock.repositories.AcertoEstoqueRepository;
import com.devmarrima.gestorstock.services.exceptions.ResourceNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AcertoEstoqueService {

    @Autowired
    private AcertoEstoqueRepository repository;

    @Transactional(readOnly = true)
    public AcertoEstoque findById (UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
    }

    public void deleteById (UUID id) {
        repository.deleteById(id);
    }

    public AcertoEstoque create (CreateAcertoEstoqueDTO createAcertoEstoqueDTO) {
        System.out.println(createAcertoEstoqueDTO.cod_produto());
        ProdutoService pdService = new ProdutoService();
        String descricao = pdService.findById(createAcertoEstoqueDTO.cod_produto()).getDescricao();

        AcertoEstoque novoAcertEstoque = new AcertoEstoque(
                UUID.randomUUID(),
                createAcertoEstoqueDTO.cod_produto(),
                descricao,
                createAcertoEstoqueDTO.operacao(),
                createAcertoEstoqueDTO.quantidade(),
                createAcertoEstoqueDTO.observacao()
        );
        System.out.println(novoAcertEstoque);

        try {
            return repository.save(novoAcertEstoque);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
