package com.coffeworld.backend.service;

import com.coffeworld.backend.dto.ItemPedidoDTO;
import com.coffeworld.backend.dto.PedidoDTO;
import com.coffeworld.backend.mapper.ItemPedidoMapper;
import com.coffeworld.backend.mapper.PedidoMapper;
import com.coffeworld.backend.model.ItemPedido;
import com.coffeworld.backend.model.Pedido;
import com.coffeworld.backend.model.Produto;
import com.coffeworld.backend.repository.PedidoRepository;
import com.coffeworld.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private ItemPedidoMapper itemPedidoMapper;

    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PedidoDTO buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .map(pedidoMapper::toDTO)
                .orElse(null);
    }

    public PedidoDTO salvar(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        pedido.setDataHoraPedido(LocalDateTime.now());

        double valorTotal = 0.0;
        int tempoEstimadoTotal = 0;

        for (ItemPedido item : pedido.getItens()) {
            Produto produto = produtoRepository.findById(item.getProduto().getId()).orElseThrow();
            item.setProduto(produto);
            item.setPedido(pedido);
            valorTotal += produto.getPreco() * item.getQuantidade();
            tempoEstimadoTotal += produto.getTempoPreparoMinutos() * item.getQuantidade();
        }

        pedido.setValorTotal(valorTotal);
        pedido.setPrevisaoEntrega(LocalDateTime.now().plusMinutes(tempoEstimadoTotal));

        Pedido salvo = pedidoRepository.save(pedido);
        return pedidoMapper.toDTO(salvo);
    }

    public PedidoDTO atualizarStatus(Long id, PedidoDTO pedidoDTO) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            Pedido pedido = optional.get();
            pedido.setStatus(pedidoDTO.getStatus());
            pedido.setMotivoCancelamento(pedidoDTO.getMotivoCancelamento());
            return pedidoMapper.toDTO(pedidoRepository.save(pedido));
        }
        return null;
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
