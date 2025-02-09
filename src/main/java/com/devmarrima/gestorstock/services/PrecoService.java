package com.devmarrima.gestorstock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devmarrima.gestorstock.dto.PrecoDTO;
import com.devmarrima.gestorstock.entities.Preco;
import com.devmarrima.gestorstock.repositories.PrecoRepository;
import com.devmarrima.gestorstock.services.exceptions.ResourceNotFoundException;

@Service
public class PrecoService {
	 @Autowired
	    private PrecoRepository repository;

	    @Transactional(readOnly = true)
		public PrecoDTO findById(Long id) {
			Preco preco = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
			return new PrecoDTO(preco);
		}
}
