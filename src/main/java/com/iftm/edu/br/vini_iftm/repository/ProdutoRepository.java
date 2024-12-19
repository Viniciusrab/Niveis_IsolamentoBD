package com.iftm.edu.br.vini_iftm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.iftm.edu.br.vini_iftm.model.Produto;

import jakarta.persistence.LockModeType;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE) // Para o lock pessimista
    Produto findById(Long id);
}

