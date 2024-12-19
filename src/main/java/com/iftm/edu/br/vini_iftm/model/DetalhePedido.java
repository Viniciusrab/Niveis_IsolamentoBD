package com.iftm.edu.br.vini_iftm.model;

import jakarta.persistence.*;

@Entity
public class DetalhePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    private int quantidade;

    // Getters e Setters
}

