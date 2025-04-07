package com.coffeworld.backend.dto;

import com.coffeworld.backend.enums.StatusPedido;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;

    private String cpfCliente;
    private Double valorTotal;
    private String formaPagamento;

    private LocalDateTime dataHoraPedido;
    private LocalDateTime previsaoEntrega;

    private StatusPedido status; // PENDENTE, EM_PREPARO, FINALIZADO, CANCELADO

    private List<ItemPedidoDTO> itens;
    private AvaliacaoDTO avaliacao;

    private String motivoCancelamento;
}
