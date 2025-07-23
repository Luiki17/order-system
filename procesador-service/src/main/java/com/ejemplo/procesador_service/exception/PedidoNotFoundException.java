package com.ejemplo.procesador_service.exception;

public class PedidoNotFoundException extends RuntimeException {
    public PedidoNotFoundException(String id) {
        super("Pedido con ID " + id + " no encontrado.");
    }
}
