package com.deliverytech.delivery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    @Column(nullable = true)
    private Boolean ativo;
    public void inativar() {
        this.ativo = false;
    }
}