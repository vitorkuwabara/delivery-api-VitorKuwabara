package com.deliverytech.delivery.dto;

import com.deliverytech.delivery.entity.Restaurante;
import lombok.*;
import java.math.BigDecimal;

@Data
public class RestauranteResponseDTO {
    private Long id;
    private String nome;
    private String categoria;
    private String endereco;
    private String telefone;
    private BigDecimal taxaEntrega;
    private BigDecimal avaliacao;
    private Boolean ativo;
    public RestauranteResponseDTO(Restaurante save) {
        this.id = save.getId();
        this.nome = save.getNome();
        this.categoria = save.getCategoria();
        this.endereco = save.getEndereco();
        this.telefone = save.getTelefone();
        this.taxaEntrega = save.getTaxaEntrega();
        this.avaliacao = save.getAvaliacao();
        this.ativo = save.getAtivo();
    }
}