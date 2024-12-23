
package com.iftm.edu.br.vini_iftm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.edu.br.vini_iftm.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
