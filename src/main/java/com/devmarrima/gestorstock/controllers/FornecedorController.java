package com.devmarrima.gestorstock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmarrima.gestorstock.dto.FornecedorDTO;
import com.devmarrima.gestorstock.services.FornecedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	
	@GetMapping
	public ResponseEntity<List<FornecedorDTO>> listarFornecedor(){
		List<FornecedorDTO> fornecedor = fornecedorService.listarFornecedore();
		return ResponseEntity.ok(fornecedor);
		
	}
	
	
	@PostMapping("/registar")
	public ResponseEntity<String> salvarFornecedor(@Valid  @RequestBody FornecedorDTO dto){
		String novo = fornecedorService.salvarFornecedor(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(novo);
		
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<FornecedorDTO> atualizarFornecedor(@PathVariable Long id, @Valid @RequestBody FornecedorDTO dto){
		FornecedorDTO fornecedor = fornecedorService.atualizar(id, dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedor);
				
	}
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<String> removerFornecedor(@PathVariable Long id){
		String msg = fornecedorService.remover(id);
		return ResponseEntity.status(HttpStatus.OK).body(msg);
	}

}
