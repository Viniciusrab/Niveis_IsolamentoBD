package com.iftm.edu.br.vini_iftm.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;
    private LocalDateTime data;

}

