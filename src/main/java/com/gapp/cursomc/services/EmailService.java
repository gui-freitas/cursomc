package com.gapp.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.gapp.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage sm);
}