package com.devmarrima.gestorstock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devmarrima.gestorstock.dto.ProdutoDTO;
import com.devmarrima.gestorstock.entities.Produto;
import com.devmarrima.gestorstock.repositories.ProdutoRepository;
import com.devmarrima.gestorstock.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
			Produto produto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ProdutoDTO(produto);
	}
}
