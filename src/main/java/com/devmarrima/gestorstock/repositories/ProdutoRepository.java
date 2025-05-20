package com.devmarrima.gestorstock.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devmarrima.gestorstock.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("SELECT obj FROM Produto obj " + " WHERE UPPER(obj.descricao) LIKE UPPER(CONCAT('%',:name,'%')) ")
	Page<Produto> searchByName(String name, Pageable pageable);

	@Query(value = "SELECT obj FROM Produto obj JOIN FETCH obj.precos", countQuery = "SELECT CONT(obj) FROM Produto obj JOIN obj.precos")
	Page<Produto> findProdutoWithPrecos(Pageable pageable);

}
