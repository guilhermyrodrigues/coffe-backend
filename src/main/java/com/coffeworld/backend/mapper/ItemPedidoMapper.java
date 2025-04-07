package com.coffeworld.backend.mapper;

import com.coffeworld.backend.dto.ItemPedidoDTO;
import com.coffeworld.backend.model.ItemPedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    @Mapping(source = "produto.id", target = "produtoId")
    @Mapping(source = "produto.nome", target = "nomeProduto")
    @Mapping(source = "produto.preco", target = "precoProduto")
    ItemPedidoDTO toDTO(ItemPedido entity);
}
