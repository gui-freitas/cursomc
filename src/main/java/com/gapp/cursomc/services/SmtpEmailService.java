package com.gapp.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage sm) {
		LOG.info("Enviando email..");
		mailSender.send(sm);
		LOG.info("Email enviado");		
	}

	@Override
	public void sendHtmlEmail(MimeMessage mm) {
		LOG.info("Enviando email HTML..");
		javaMailSender.send(mm);
		LOG.info("Email enviado");			
	}
}
