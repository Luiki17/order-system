package com.ejemplo.pedido_service.controller;

import com.ejemplo.pedido_service.model.Pedido;
import com.ejemplo.pedido_service.service.PedidoProducer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoProducer pedidoProducer;

    public PedidoController(PedidoProducer pedidoProducer) {
        this.pedidoProducer = pedidoProducer;
    }

    @PostMapping
    public ResponseEntity<String> enviarPedido(@Valid @RequestBody Pedido pedido) {
        pedidoProducer.enviarPedido(pedido);
        return ResponseEntity.ok("Pedido enviado correctamente");
    }

}
