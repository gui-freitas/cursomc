package com.gapp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapp.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}