package com.deliverytech.delivery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_pedido")
    private String numeroPedido;
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;
    private String status;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    private String observacoes;
    @Column(name = "cliente_id")
    private Long clienteId;
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;
    private String itens;
}