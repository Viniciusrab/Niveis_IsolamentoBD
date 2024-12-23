package com.iftm.edu.br.vini_iftm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iftm.edu.br.vini_iftm.service.PedidoService;

@RestController
@RequestMapping("/pedido/novo")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> processarPedido(@RequestParam Long produtoId, @RequestParam Integer quantidade) {
        return pedidoService.processarPedidoSemLock(produtoId, quantidade);
    }
}
