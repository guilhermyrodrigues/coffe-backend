package com.coffeworld.backend.dto;

import com.coffeworld.backend.model.Pedido;
import com.coffeworld.backend.model.Produto;

import lombok.Data;

@Data
public class ItemPedidoDTO {
    private Long id;
    private Long produtoId;
    private String nomeProduto;
    private Double precoProduto;
    private Integer quantidade;
}
