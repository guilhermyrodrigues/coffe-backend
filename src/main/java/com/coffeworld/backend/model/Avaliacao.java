package com.coffeworld.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Pedido pedido;

    private Integer nota; // Ex: 1 a 5
    private String comentario;
}
