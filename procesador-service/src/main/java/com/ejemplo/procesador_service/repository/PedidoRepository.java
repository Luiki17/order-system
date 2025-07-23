package com.ejemplo.procesador_service.repository;

import com.ejemplo.procesador_service.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,String> {
}
