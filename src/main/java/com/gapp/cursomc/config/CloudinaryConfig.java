package com.gapp.cursomc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {
	
	@Value("${cloud.name}")
	private String cloudName;
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${api.secrect}")
	private String apiSecret;
	
	@Bean
	public Cloudinary cloudinaryClient() {
	    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
	    "cloud_name", cloudName,
	    "api_key", apiKey,
	    "api_secret", apiSecret,
	    "secure", true));
	    return cloudinary;
	}
}