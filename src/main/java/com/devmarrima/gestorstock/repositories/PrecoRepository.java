package com.devmarrima.gestorstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmarrima.gestorstock.entities.Preco;

public interface PrecoRepository extends JpaRepository<Preco,Long> {

}
