package com.gapp.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockMailService extends AbstractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(MockMailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage sm) {
		LOG.info("Simulando envio de email..");
		LOG.info(sm.toString());
		LOG.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage mm) {
		LOG.info("Simulando envio de email HTML..");
		LOG.info(mm.toString());
		LOG.info("Email enviado");
	}
}