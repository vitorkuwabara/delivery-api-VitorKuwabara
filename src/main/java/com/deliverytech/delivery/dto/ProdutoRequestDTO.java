package com.deliverytech.delivery.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data
public class ProdutoRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotBlank(message = "O preço é obrigatório")
    private BigDecimal preco;
    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;
}