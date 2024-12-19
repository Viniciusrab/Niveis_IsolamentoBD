package com.iftm.edu.br.vini_iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.edu.br.vini_iftm.model.Pedido;
import com.iftm.edu.br.vini_iftm.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/novo")
    public ResponseEntity<?> criarPedido(
        @RequestParam Long produtoId,
        @RequestParam int quantidade,
        @RequestParam Long clienteId
    ) {
        try {
            Pedido pedido = pedidoService.processarPedido(produtoId, quantidade, clienteId);
            return ResponseEntity.ok(pedido);
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}
