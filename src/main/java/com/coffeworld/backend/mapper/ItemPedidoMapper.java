package com.coffeworld.backend.mapper;

import com.coffeworld.backend.dto.ItemPedidoDTO;
import com.coffeworld.backend.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    ItemPedidoDTO toDTO(ItemPedido entity);
}
