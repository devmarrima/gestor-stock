package com.devmarrima.gestorstock.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmarrima.gestorstock.entities.AcertoEstoque;

public interface AcertoEstoqueRepository extends JpaRepository<AcertoEstoque, UUID> {
}
