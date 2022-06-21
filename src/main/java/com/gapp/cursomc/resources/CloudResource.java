package com.gapp.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gapp.cursomc.services.CloudinaryService;

@RestController
@RequestMapping(value = "/fotos")
public class CloudResource {
	
	@Autowired
	private CloudinaryService cloudinaryService;
	
	@GetMapping
	public ResponseEntity<List<String>> getLinkPictures() throws Exception{
		List<String> list = cloudinaryService.getPictures();
		return ResponseEntity.ok().body(list);
	}
}