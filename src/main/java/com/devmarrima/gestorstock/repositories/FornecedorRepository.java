package com.devmarrima.gestorstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmarrima.gestorstock.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
