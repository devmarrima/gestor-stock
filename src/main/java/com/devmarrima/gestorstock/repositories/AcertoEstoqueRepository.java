package com.devmarrima.gestorstock.repositories;

import com.devmarrima.gestorstock.entities.AcertoEstoque;
import jakarta.persistence.GenerationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AcertoEstoqueRepository extends JpaRepository<AcertoEstoque, UUID> {
}
