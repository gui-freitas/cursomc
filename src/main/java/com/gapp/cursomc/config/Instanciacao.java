package com.gapp.cursomc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gapp.cursomc.services.CloudinaryService;

@Configuration
public class Instanciacao implements CommandLineRunner{
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
	public void run(String... args) throws Exception {
		cloudinaryService.uploadFile("N:\\DOWNLOADS\\logo.png");
	}
}