package com.devmarrima.gestorstock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmarrima.gestorstock.dto.ProdutoDTO;
import com.devmarrima.gestorstock.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
	private ProdutoService service;

	@GetMapping(value = ("/{id}"))
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
		ProdutoDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

}
