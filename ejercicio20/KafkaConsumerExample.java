package com.mycompany.ejercicio200;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerExample {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); 
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // Crear el consumidor
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // Suscribirse al topic "my-topic"
        consumer.subscribe(Collections.singletonList("my-topic"));

        // Consumir mensajes
        while (true) {
            var records = consumer.poll(100); 
            records.forEach(record -> {
                System.out.println("Mensaje recibido: " + record.value());
            });
        }
    }

    static Thread consumeMessage() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
