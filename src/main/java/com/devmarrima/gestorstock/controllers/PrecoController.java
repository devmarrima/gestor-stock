package com.devmarrima.gestorstock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmarrima.gestorstock.dto.PrecoDTO;
import com.devmarrima.gestorstock.services.PrecoService;

@RestController
@RequestMapping(value = "/preco")
public class PrecoController {
	
	@Autowired
	private PrecoService service;

	@GetMapping(value = ("/{id}"))
	public ResponseEntity<PrecoDTO> findById(@PathVariable Long id) {
		PrecoDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
}
