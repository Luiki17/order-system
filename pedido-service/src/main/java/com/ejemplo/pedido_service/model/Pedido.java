package com.ejemplo.pedido_service.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @NotNull(message = "El ID no puede ser nulo")
    private String id;
    @NotEmpty(message = "El nombre del cliente no puede estar vacío")
    private String cliente;
    @NotEmpty(message = "Debe incluir al menos un producto")
    private List<String> productos;
}