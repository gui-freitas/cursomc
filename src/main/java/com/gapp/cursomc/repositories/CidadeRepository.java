package com.gapp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapp.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}