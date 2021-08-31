package com.gapp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapp.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}