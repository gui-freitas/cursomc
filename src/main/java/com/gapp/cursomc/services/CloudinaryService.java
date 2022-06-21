package com.gapp.cursomc.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import javax.imageio.ImageIO;

import org.cloudinary.json.JSONArray;
import org.cloudinary.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.gapp.cursomc.config.CloudinaryConfig;
import com.gapp.cursomc.services.exceptions.FileException;

@Service
public class CloudinaryService {
	
	private Logger LOG = LoggerFactory.getLogger(CloudinaryService.class);
	
	@Autowired
	private CloudinaryConfig cloudinaryConfig;
	
	public URI uploadFile(BufferedImage jpgImage, String fileName, String resourceType) {
		try {
			Map params = ObjectUtils.asMap("public_id", removeFormat(fileName), "resource_type", resourceType, "folder", "test", "upload_preset", "ml_default");
			File outputFile = new File(fileName);
		    ImageIO.write(jpgImage, "jpg", outputFile);

			LOG.info("Iniciando upload!");
			Map result = cloudinaryConfig.cloudinaryClient().uploader().upload(outputFile, params);
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
	
	//https://support.cloudinary.com/hc/en-us/community/posts/360009534411-How-can-i-get-all-files-or-images-from-a-folder-
	public ArrayList<String> getPictures() throws Exception {
		
		JSONObject outerObject = null;
		String jsonNext = null;
		boolean ifWeHaveMoreResources = true;
		ArrayList<String> listResult = new ArrayList<String>();
		
		while(ifWeHaveMoreResources) {
			outerObject = new JSONObject(cloudinaryConfig.cloudinaryClient().api().resources(ObjectUtils.asMap("max_results", 10,"next_cursor", jsonNext)));
			
			if (outerObject.has("next_cursor")) {
				jsonNext = outerObject.get("next_cursor").toString();
				ifWeHaveMoreResources = true;
			}
			else{
				ifWeHaveMoreResources = false;
			}
			
			JSONArray jsonArray = outerObject.getJSONArray("resources");
			for (int i = 0, size = jsonArray.length(); i < size; i++) {
				JSONObject objectInArray = jsonArray.getJSONObject(i);
				String url = objectInArray.get("secure_url").toString();
				listResult.add(url);
			}
		}
		return listResult;
	}
}