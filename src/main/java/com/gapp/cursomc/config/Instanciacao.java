package com.gapp.cursomc.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gapp.cursomc.domain.Categoria;
import com.gapp.cursomc.repositories.CategoriaRepository;

@Configuration
public class Instanciacao implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}
}