package com.coffeworld.backend.dto;

import lombok.Data;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String imagemUrl;
    private Double preco;
    private Integer tempoPreparoMinutos;
}
