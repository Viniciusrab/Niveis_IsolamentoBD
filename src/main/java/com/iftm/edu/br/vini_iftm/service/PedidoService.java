package com.iftm.edu.br.vini_iftm.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iftm.edu.br.vini_iftm.model.DetalhePedido;
import com.iftm.edu.br.vini_iftm.model.Pedido;
import com.iftm.edu.br.vini_iftm.model.Produto;
import com.iftm.edu.br.vini_iftm.repository.DetalhePedidoRepository;
import com.iftm.edu.br.vini_iftm.repository.PedidoRepository;
import com.iftm.edu.br.vini_iftm.repository.ProdutoRepository;

@Service
public class PedidoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetalhePedidoRepository detalhePedidoRepository;

    @Transactional
    public Pedido processarPedido(Long produtoId, int quantidade, Long clienteId) {
        Produto produto = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (produto.getUnidadesEmEstoque() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        produto.setUnidadesEmEstoque(produto.getUnidadesEmEstoque() - quantidade);
        produtoRepository.save(produto);

        Pedido pedido = new Pedido();
        pedido.setClienteId(clienteId);
        pedido.setData(LocalDateTime.now());
        pedido = pedidoRepository.save(pedido);

        DetalhePedido detalhe = new DetalhePedido();
        detalhe.setPedido(pedido);
        detalhe.setProduto(produto);
        detalhe.setQuantidade(quantidade);
        detalhePedidoRepository.save(detalhe);

        return pedido;
    }
}
