package com.coffeworld.backend.dto;

import com.coffeworld.backend.model.Pedido;
import lombok.Data;

@Data
public class AvaliacaoDTO {
    private Long id;
    private Integer nota;         // Ex: 1 a 5
    private String comentario;
    private Long pedidoId;
}
