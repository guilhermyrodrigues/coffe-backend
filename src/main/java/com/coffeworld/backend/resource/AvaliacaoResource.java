package com.coffeworld.backend.resource;

import com.coffeworld.backend.dto.AvaliacaoDTO;
import com.coffeworld.backend.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/avaliacoes")
@CrossOrigin(origins = "*")
public class AvaliacaoResource {
    @Autowired
    private AvaliacaoService avaliacaoService;

    @Operation(summary = "Criar avaliação para um pedido")
    @PostMapping("/pedido/{pedidoId}")
    public AvaliacaoDTO avaliarPedido(@PathVariable Long pedidoId, @RequestBody AvaliacaoDTO dto) {
        return avaliacaoService.salvar(pedidoId, dto);
    }

    @Operation(summary = "Buscar avaliação por ID")
    @GetMapping("/pedido/{pedidoId}")
    public AvaliacaoDTO buscarAvaliacao(@PathVariable Long pedidoId) {
        return avaliacaoService.buscarPorPedido(pedidoId);
    }
}
