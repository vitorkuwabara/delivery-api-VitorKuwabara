package com.deliverytech.delivery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurantes")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private String endereco;
    private String telefone;
    @Column(name = "taxa_entrega")
    private BigDecimal taxaEntrega;
    private BigDecimal avaliacao;
    private Boolean ativo;
    public void inativar() {
        this.ativo = false;
    }
}