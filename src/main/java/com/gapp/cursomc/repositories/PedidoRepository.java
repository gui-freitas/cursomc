package com.gapp.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gapp.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}