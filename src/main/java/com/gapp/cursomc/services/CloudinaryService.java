package com.gapp.cursomc.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.gapp.cursomc.config.CloudinaryConfig;
import com.gapp.cursomc.services.exceptions.FileException;

@Service
public class CloudinaryService {
	
	private Logger LOG = LoggerFactory.getLogger(CloudinaryService.class);
	
	@Autowired
	private CloudinaryConfig cloudinaryConfig;
	
	public URI uploadFile(MultipartFile multipartFile) {
		try {
			File uploadFile = convertMultiPartToFile(multipartFile);
			String fileName = multipartFile.getOriginalFilename();

			LOG.info("Iniciando upload!");
			Map result = cloudinaryConfig.cloudinaryClient().uploader().upload(uploadFile, ObjectUtils.asMap("public_id", removeFormat(fileName)));
			String urlLoaded = cloudinaryConfig.cloudinaryClient().signedPreloadedImage(result);
			String cdn = Cloudinary.AKAMAI_SHARED_CDN.toString();
			LOG.info("Upload finalizado!");
			
			URI uri = new URI(cdn + "/" + cloudinaryConfig.getCloudName() + "/" + urlLoaded);
			return uri;
		} 
		catch (IOException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
		catch (URISyntaxException e) {
			throw new FileException("Erro ao converter a String para URI");
		}
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		  File convFile = new File(file.getOriginalFilename());
		  FileOutputStream fos = new FileOutputStream(convFile);
		  fos.write(file.getBytes());
		  fos.close();
		  return convFile;
	}
	
	private String removeFormat(String fileName) {
		String newName = null;
		
		if(fileName.contains(".jpg")) {
			newName = fileName.replace(".jpg", "");
		}
		if(fileName.contains(".png")) {
			newName = fileName.replace(".png", "");
		}
		if(fileName.contains(".jpeg")) {
			newName = fileName.replace(".jpeg", "");
		}
		return newName;
	}
}