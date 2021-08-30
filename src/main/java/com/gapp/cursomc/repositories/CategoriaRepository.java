package com.gapp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapp.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}