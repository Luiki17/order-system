package com.ejemplo.pedido_service.config;

import com.ejemplo.pedido_service.model.Pedido;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, Pedido> producerFactory() {
        Map<String, Object> config = new HashMap<>(); // Configuración del productor de Kafka
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Dirección del broker de Kafka
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // Serializador para la clave del mensaje
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // Serializador para el valor del mensaje (Pedido)
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false); // Evita agregar información de tipo en los encabezados del mensaje
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, Pedido> kafkaTemplate() { // KafkaTemplate para enviar mensajes al topic "pedidos"
        return new KafkaTemplate<>(producerFactory());
    }
}
