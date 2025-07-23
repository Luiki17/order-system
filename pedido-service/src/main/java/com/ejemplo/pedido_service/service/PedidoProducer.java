package com.ejemplo.pedido_service.service;

import com.ejemplo.pedido_service.model.Pedido;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {

    private final KafkaTemplate<String, Pedido> kafkaTemplate;

    public PedidoProducer(KafkaTemplate<String, Pedido> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarPedido(Pedido pedido) {
        kafkaTemplate.send("pedidos", pedido);
    }
}
