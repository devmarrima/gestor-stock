package com.devmarrima.gestorstock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devmarrima.gestorstock.dto.ProdutoDTO;
import com.devmarrima.gestorstock.entities.Produto;
import com.devmarrima.gestorstock.repositories.ProdutoRepository;
import com.devmarrima.gestorstock.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;

	@Transactional(readOnly = true)
	public ProdutoDTO findById(Long id) {
			Produto produto = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new ProdutoDTO(produto);
	}

	public Page<ProdutoDTO> findAll(String name, Pageable pageable) {
		Page<Produto> result;

		if (name != null && !name.trim().isEmpty()) {
			result = repository.searchByName(name, pageable);
		} else {
			result = repository.findProdutoWithPrecos(pageable);
		}

		return result.map(x -> new ProdutoDTO(x));
	}

	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProdutoDTO(entity);
	}

	@Transactional
	public ProdutoDTO update(Long id, ProdutoDTO dto) {
		Produto entity = repository.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ProdutoDTO(entity);

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		repository.deleteById(id);

	}

	private void copyDtoToEntity(ProdutoDTO dto, Produto entity) {
		entity.setDescricao(dto.getDescricao());
		entity.setCodigoOriginal(dto.getCodigoOriginal());
		entity.setCodigoFornecedor(dto.getCodigoFornecedor());
		entity.setPrecoMedioCusto(dto.getPrecoMedioCusto());
		entity.setLocacaoEstoque(dto.getLocacaoEstoque());
		entity.setEspecificacoes(dto.getEspecificacoes());
		entity.setQuantidadeMinima(dto.getQuantidadeMinima());
		entity.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		entity.setGrupo(dto.getGrupo());
		entity.setLinha(dto.getLinha());
		entity.setAplicacao(dto.getAplicacao());
		entity.setSubgrupo(dto.getSubgrupo());

	}
}
