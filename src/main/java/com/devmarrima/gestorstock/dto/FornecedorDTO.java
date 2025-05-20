package com.devmarrima.gestorstock.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.br.CNPJ;

import com.devmarrima.gestorstock.entities.Fornecedor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class FornecedorDTO {
	
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 1, max= 50)
	private String nome;
	
	@NotBlank(message = "CNPJ é obrigatório")
	@CNPJ
	private String cnpj;
	
	@Email(message = "Por favor, insira um email válido")
	@Pattern(
	    regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
	    message = "O email deve conter um domínio válido, como .com, .br, etc."
	)
	private String email;
	
	@NotBlank(message = "Telefone é obrigatório")
	private String telefone;
	
	@NotBlank(message = "Endereço é obrigatório")
	private String endereco;
	
	private List<NotaFiscalDTO> notasFiscais;
	
	public FornecedorDTO(
			Long id, 
			String nome,
			String cnpj,
			String email, String telefone,
			String endereco, List<NotaFiscalDTO> notasFiscais) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.notasFiscais = new ArrayList<>();
	}

	
	public FornecedorDTO(Fornecedor entity){
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cnpj = entity.getCnpj();
		this.email = entity.getEmail();
		this.telefone = entity.getTelefone();
		this.endereco = entity.getEndereco();
		
		
				
	}
	
	public FornecedorDTO() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public List<NotaFiscalDTO> getNotasFiscais() {
		return notasFiscais;
	}


	public void setNotasFiscais(List<NotaFiscalDTO> notasFiscais) {
		this.notasFiscais = notasFiscais;
	}
	
	
	
	
}
