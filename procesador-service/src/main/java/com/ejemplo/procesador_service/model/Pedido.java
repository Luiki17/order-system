package com.ejemplo.procesador_service.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    private String id;
    private String cliente;
    @ElementCollection
    private List<String> productos;
}
