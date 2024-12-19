package com.iftm.edu.br.vini_iftm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vini_iftm.model.DetalhePedido;

@Repository
public interface DetalhePedidoRepository extends JpaRepository<DetalhePedido, Long> {
}
