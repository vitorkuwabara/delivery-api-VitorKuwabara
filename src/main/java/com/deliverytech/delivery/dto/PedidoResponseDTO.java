package com.deliverytech.delivery.dto;

import com.deliverytech.delivery.entity.Pedido;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoResponseDTO {
    private Long id;
    private String numeroPedido;
    private LocalDateTime dataPedido;
    private String status;
    private BigDecimal valorTotal;
    private String observacoes;
    private Long clienteId;
    private Long restauranteId;
    private String itens;
    public PedidoResponseDTO(Pedido save) {
        this.id = save.getId();
        this.numeroPedido = save.getNumeroPedido();
        this.dataPedido = save.getDataPedido();
        this.status = save.getStatus();
        this.valorTotal = save.getValorTotal();
        this.observacoes = save.getObservacoes();
        this.clienteId = save.getClienteId();
        this.restauranteId = save.getRestaurante().getId();
        this.itens = save.getItens();
    }
}