package com.iftm.edu.br.vini_iftm.model;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double preco;

    @Column(name = "unidades_em_estoque")
    private int unidadesEmEstoque;

    @Version // Para controle de Lock Otimista
    private int versao;

    // Getters e Setters
}

