package com.devmarrima.gestorstock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devmarrima.gestorstock.dto.FornecedorDTO;
import com.devmarrima.gestorstock.dto.ItemNotaFiscalDTO;
import com.devmarrima.gestorstock.dto.NotaFiscalDTO;
import com.devmarrima.gestorstock.entities.Fornecedor;
import com.devmarrima.gestorstock.entities.ItemNotaFiscal;
import com.devmarrima.gestorstock.entities.NotaFiscal;
import com.devmarrima.gestorstock.repositories.FornecedorRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Transactional(readOnly = true)
	public List<FornecedorDTO> listarFornecedore(){
		List<Fornecedor> fornecedor = new ArrayList<>();
		fornecedor = fornecedorRepository.findAll();
		
		List<FornecedorDTO> dto = fornecedor.stream()
				.map(FornecedorDTO::new)
				.collect(Collectors.toList());
		
		return dto;
			
	}
	
	@Transactional
	public String salvarFornecedor(FornecedorDTO dto) {
		Fornecedor fornecedor = new Fornecedor();
		paraEntidade(fornecedor, dto);
		
		FornecedorDTO dtoAtualizado = new FornecedorDTO(fornecedorRepository.save(fornecedor));
		
		String msg = String.format("Fornecedor registrador com sucesso!", dtoAtualizado);
		return msg;
		
	}
	
	@Transactional
	public FornecedorDTO atualizar(Long id, FornecedorDTO dto) {
		Fornecedor fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado!!"));
				
				if(!Objects.equals(dto.getNome(), fornecedor.getNome())) {
					fornecedor.setNome(dto.getNome());
				}
				
				if(!Objects.equals(dto.getEmail(), fornecedor.getEmail())) {
					fornecedor.setEmail(dto.getEmail());
				}
				
				if(!Objects.equals(dto.getCnpj(), fornecedor.getCnpj())) {
					fornecedor.setCnpj(dto.getCnpj());
				}
				
				if(!Objects.equals(dto.getTelefone(), fornecedor.getTelefone())) {
					fornecedor.setTelefone(dto.getTelefone());
				}
				
				if(!Objects.equals(dto.getEndereco(), fornecedor.getEndereco())) {
					fornecedor.setEndereco(dto.getEndereco());
				}
				
				if(!Objects.equals(dto.getNotasFiscais(), fornecedor.getNotasFiscais())) {
					fornecedor.setNotasFiscais(fornecedor.getNotasFiscais());;
				}
									
				
				Fornecedor fornecedorAtualizado = fornecedorRepository.save(fornecedor);
					
				return new FornecedorDTO(fornecedorAtualizado);
					
					
	}

	@Transactional 
	public String remover(Long id) {
		Fornecedor fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado"));
		
		fornecedorRepository.delete(fornecedor);
		String msg = String.format("Fornecedor com o id:  %d", id);
		return msg;
	}
	
	
	//Copiando dados do DTO para entidade notaFiscal
	private NotaFiscal toNotaFiscal(NotaFiscalDTO notaFiscalDTO) {
	    NotaFiscal notaFiscal = new NotaFiscal();

	    notaFiscal.setId(notaFiscalDTO.getId());
	    notaFiscal.setNumero(notaFiscalDTO.getNumero());
	    notaFiscal.setSerie(notaFiscalDTO.getSerie());
	    notaFiscal.setDataEmissao(notaFiscalDTO.getDataEmissao());
	    notaFiscal.setValorTotal(notaFiscalDTO.getValorTotal());
	    notaFiscal.setObservacoes(notaFiscalDTO.getObservacoes());
	    notaFiscal.setChaveAcesso(notaFiscalDTO.getChaveAcesso());
	    notaFiscal.setStatusNota(notaFiscalDTO.getStatusNota());

	    // Converte os itens de volta para entidade, se necessário
	    List<ItemNotaFiscal> itens = notaFiscalDTO.getItens().stream()
	            .map(ItemNotaFiscalDTO::toEntity) // Supondo que exista esse método
	            .collect(Collectors.toList());
	    notaFiscal.setItens(itens);

	    return notaFiscal;
	}
	
	
	//Copiando dados do DTO para entidade
	public void paraEntidade(Fornecedor entity, FornecedorDTO dto) {
		entity.setNome(dto.getNome());
		entity.setCnpj(dto.getCnpj());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
		entity.setEndereco(dto.getEndereco());
		
		entity.setNotasFiscais(dto.getNotasFiscais()
				.stream()
				.map(this::toNotaFiscal)
				.collect(Collectors.toList()));
		
		}
	
	
}
