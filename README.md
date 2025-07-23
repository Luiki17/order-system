# Proyecto Sistema de Pedidos con Microservicios (Spring Boot, Kafka, Docker y MySQL)

Este proyecto es una aplicación didáctica que implementa un sistema básico de pedidos usando una arquitectura de microservicios. El objetivo principal fue repasar y mejorar conceptos fundamentales de desarrollo backend con tecnologías actuales.

---

## Tecnologías usadas

- **Java 21**
- **Spring Boot** (REST API, Spring Data JPA, Spring Kafka)
- **Apache Kafka** (mensajería asincrónica)
- **MySQL** (base de datos relacional)
- **Docker** (contenedores para base de datos y Kafka)
- **Swagger/OpenAPI** (documentación API)
- **Lombok** (reducción de boilerplate)
- **Maven** (gestión de dependencias)

---

## Arquitectura y descripción

El sistema consta de dos microservicios principales:

1. **pedido-service**  
   - Servicio productor de pedidos.  
   - Expone un endpoint para crear pedidos.  
   - Envía pedidos a un topic Kafka (`pedidos`).  

2. **procesador-service**  
   - Servicio consumidor de pedidos.  
   - Escucha el topic Kafka y persiste pedidos en MySQL.  
   - Expone endpoints para consultar pedidos (listado y detalle).  
   - Documentación Swagger disponible en `/swagger-ui/index.html`.

---

## Cómo ejecutar

1. Clona el repositorio.
2. Asegúrate de tener Docker y Docker Compose instalados.
3. Ejecuta `docker-compose up` para levantar Kafka, Zookeeper y MySQL.
4. Ejecuta los microservicios `pedido-service` y `procesador-service` desde tu IDE o línea de comandos.
5. Prueba los endpoints con Postman o Swagger UI.

---

## Endpoints destacados

### pedido-service
- `POST /api/pedidos` – Crear un pedido (envía mensaje Kafka).

### procesador-service
- `GET /pedidos` – Listar todos los pedidos.
- `GET /pedidos/{id}` – Obtener pedido por ID.
- `/swagger-ui/index.html` – Documentación Swagger.

---

## Lecciones y mejoras

Este proyecto me permitió reforzar conocimientos y prácticas como:

- Comunicación entre microservicios con Kafka.
- Persistencia en base de datos con Spring Data JPA.
- Configuración y uso de Docker para infraestructura.
- Manejo básico de excepciones y documentación de API con Swagger.
- Diseño limpio y modular en Spring Boot.

---

¡Gracias por visitar este proyecto!

