package com.gapp.cursomc.services;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.utils.ObjectUtils;
import com.gapp.cursomc.config.CloudinaryConfig;

@Service
public class CloudinaryService {
	
	private Logger LOG = LoggerFactory.getLogger(CloudinaryService.class);
	
	@Autowired
	private CloudinaryConfig cloudinaryConfig;
	
	public void uploadFile(String localFilePath) {
		try {
			File file = new File(localFilePath);
			LOG.info("Iniciando upload!");
			cloudinaryConfig.cloudinaryClient().uploader().upload(file, ObjectUtils.emptyMap());
			LOG.info("Upload finalizado!");
		} catch (IOException e) {
			LOG.info("IOException: " + e.getMessage());
		}
	}
}