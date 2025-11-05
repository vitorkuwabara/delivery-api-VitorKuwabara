package com.deliverytech.delivery.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoRequestDTO {
    @NotBlank(message = "O número do pedido é obrigatório")
    private String numeroPedido;
    @NotBlank(message = "A data do pedido é obrigatória")
    private LocalDateTime dataPedido;
    @NotBlank(message = "O status é obrigatório")
    private String status;
    @NotBlank(message = "O valor total é obrigatório")
    private BigDecimal valorTotal;
    @NotBlank(message = "As observações são obrigatórias")
    private String observacoes;
}