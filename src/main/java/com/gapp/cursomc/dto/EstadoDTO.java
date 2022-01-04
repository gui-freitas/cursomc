package com.gapp.cursomc.dto;

import java.io.Serializable;

import com.gapp.cursomc.domain.Estado;

public class EstadoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	private Integer id;

	private String nome;
	
	public EstadoDTO() { }
	
	public EstadoDTO(Estado estado) {
		id = estado.getId();
		nome = estado.getNome();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}