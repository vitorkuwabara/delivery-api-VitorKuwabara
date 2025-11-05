package com.deliverytech.delivery.repository;

import com.deliverytech.delivery.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteIdOrderByDataPedidoDesc(Long clienteId);
    Pedido findByNumeroPedido(String numeroPedido);
    List<Pedido> findByRestauranteIdOrderByDataPedidoDesc(Long restauranteId);
}