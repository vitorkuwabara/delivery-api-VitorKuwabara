package com.deliverytech.delivery.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Data
public class RestauranteRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;
    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;
    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;
    @NotBlank(message = "A taxa de entrega é obrigatória")
    private BigDecimal taxaEntrega;
    @NotBlank(message = "A avaliação é obrigatória")
    private BigDecimal avaliacao;
}