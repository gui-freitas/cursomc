package com.gapp.cursomc.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.gapp.cursomc.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagamentoComBoleto, Instant instanteDoPedido) {
		Instant instant = instanteDoPedido.plus(7, ChronoUnit.DAYS);
		pagamentoComBoleto.setDataVencimento(instant);
	}
}