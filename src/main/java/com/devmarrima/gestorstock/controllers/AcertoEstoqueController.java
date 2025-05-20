package com.devmarrima.gestorstock.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmarrima.gestorstock.dto.CreateAcertoEstoqueDTO;
import com.devmarrima.gestorstock.entities.AcertoEstoque;
import com.devmarrima.gestorstock.services.AcertoEstoqueService;

@RestController
@RequestMapping(value = "/acerto-estoque")
public class AcertoEstoqueController {
    @Autowired
    private AcertoEstoqueService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AcertoEstoque> findById(@PathVariable UUID id) {
        AcertoEstoque acertoEstoque = service.findById(id);
        return ResponseEntity.ok(acertoEstoque);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById (@PathVariable UUID id) {
        service.deleteById(id);
        ResponseEntity.ok();
    }

    @PostMapping
    public ResponseEntity<AcertoEstoque> createAcertoEstoque (@RequestBody CreateAcertoEstoqueDTO createAcertoEstoqueDTO) {
        return ResponseEntity.ok(service.create(createAcertoEstoqueDTO));
    }

}
