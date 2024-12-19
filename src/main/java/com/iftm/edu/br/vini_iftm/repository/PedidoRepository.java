package com.iftm.edu.br.vini_iftm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iftm.edu.br.vini_iftm.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

