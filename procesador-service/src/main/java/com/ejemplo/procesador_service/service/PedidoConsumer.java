package com.ejemplo.procesador_service.service;

import com.ejemplo.procesador_service.exception.PedidoException;
import com.ejemplo.procesador_service.model.Pedido;
import com.ejemplo.procesador_service.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PedidoConsumer {

    @Autowired
    private PedidoRepository pedidoRepository;

    @KafkaListener(topics = "pedidos", groupId = "procesador-grupo", containerFactory = "pedidoFactory")
    public void recibirPedido(Map<String, Object> pedidoMap) {
        try {
            Pedido pedido = new Pedido();
            pedido.setId((String) pedidoMap.get("id"));
            pedido.setCliente((String) pedidoMap.get("cliente"));
            pedido.setProductos((List<String>) pedidoMap.get("productos"));

            pedidoRepository.save(pedido);
        } catch (Exception ex) {
            throw new PedidoException("Error al procesar el pedido recibido desde Kafka: " + ex.getMessage());
        }
    }

}
