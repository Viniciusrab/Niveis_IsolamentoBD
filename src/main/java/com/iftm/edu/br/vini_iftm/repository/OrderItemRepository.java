package com.iftm.edu.br.vini_iftm.repository;

import com.iftm.edu.br.vini_iftm.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {}
