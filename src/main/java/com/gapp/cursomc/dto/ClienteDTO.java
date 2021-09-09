package com.gapp.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.gapp.cursomc.domain.Cliente;
import com.gapp.cursomc.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Necessário preencher o nome!")
	@Length(min = 5, max = 100, message = "O tamanho deve ser entre 5 e 100 caracteres!")
	private String nome;
	
	@NotEmpty(message = "Necessário preencher o e-mail")
	@Email(message = "Email inválido")
	private String email;
	
	public ClienteDTO() { }
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		email = cliente.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}