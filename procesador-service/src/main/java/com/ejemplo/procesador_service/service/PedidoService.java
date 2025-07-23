package com.ejemplo.procesador_service.service;

import com.ejemplo.procesador_service.exception.PedidoNotFoundException;
import com.ejemplo.procesador_service.model.Pedido;
import com.ejemplo.procesador_service.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findByIdOrThrow(String id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));
    }

}
