package com.iftm.edu.br.vini_iftm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iftm.edu.br.vini_iftm.model.Product;
import com.iftm.edu.br.vini_iftm.repository.ProductRepository;

@Service
public class PedidoService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ResponseEntity<?> processarPedidoSemLock(Long produtoId, Integer quantidade) {
        Product produto = productRepository.findById(produtoId).orElse(null);
        if (produto == null || produto.getStock() < quantidade) {
            return ResponseEntity.status(409).body("Estoque insuficiente ou produto não encontrado.");
        }
        produto.setStock(produto.getStock() - quantidade);
        productRepository.save(produto);
        return ResponseEntity.ok("Pedido processado com sucesso.");
    }

    @Transactional
    public ResponseEntity<?> processarPedidoComLockOtimista(Long produtoId, Integer quantidade) {
        Product produto = productRepository.findById(produtoId).orElse(null);
        if (produto == null || produto.getStock() < quantidade) {
            return ResponseEntity.status(409).body("Estoque insuficiente ou produto não encontrado.");
        }

        produto.setStock(produto.getStock() - quantidade);
        productRepository.save(produto);
        return ResponseEntity.ok("Pedido processado com sucesso.");
    }

    @Transactional
    public synchronized ResponseEntity<?> processarPedidoComLockPessimista(Long produtoId, Integer quantidade) {
        Product produto = productRepository.findById(produtoId).orElse(null);
        if (produto == null || produto.getStock() < quantidade) {
            return ResponseEntity.status(409).body("Estoque insuficiente ou produto não encontrado.");
        }

        produto.setStock(produto.getStock() - quantidade);
        productRepository.save(produto);
        return ResponseEntity.ok("Pedido processado com sucesso.");
    }
}
