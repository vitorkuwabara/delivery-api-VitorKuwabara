package com.deliverytech.delivery.dto;

import com.deliverytech.delivery.entity.Produto;
import lombok.*;

import java.math.BigDecimal;

@Data
public class ProdutoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private String categoria;
    private Boolean disponivel;
    private Long restauranteId;
    public ProdutoResponseDTO(Produto save) {
        this.id = save.getId();
        this.nome = save.getNome();
        this.descricao = save.getDescricao();
        this.preco = save.getPreco();
        this.categoria = save.getCategoria();
        this.disponivel = save.getDisponivel();
        this.restauranteId = save.getRestauranteId();
    }
}