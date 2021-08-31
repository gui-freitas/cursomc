package com.gapp.cursomc.domain;

import java.time.Instant;

import javax.persistence.Entity;

import com.gapp.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	
	private Instant dataVencimento;
	private Instant dataPagamento;
	
	public PagamentoComBoleto() { }

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Instant dataVencimento, Instant dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Instant getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Instant dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Instant getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Instant dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
}