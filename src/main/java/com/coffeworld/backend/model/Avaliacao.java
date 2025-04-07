package com.coffeworld.backend.model;

import jakarta.persistence.*;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne
    private Pedido pedido;

    private Integer nota; // Ex: 1 a 5
    private String comentario;
}
