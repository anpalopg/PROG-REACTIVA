package com.mycompany.ejercicio15;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Ejercicio15 {
    public static void main(String[] args) {
        
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "grupo-ejemplo");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

       
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

      
        consumer.subscribe(Collections.singletonList("my-topic"));

        System.out.println("Esperando mensajes desde el topic 'my-topic'...");

      
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Mensaje recibido:");
                System.out.println(" - Key: " + record.key());
                System.out.println(" - Valor: " + record.value());
                System.out.println(" - Offset: " + record.offset());
                System.out.println(" - ParticiÃ³n: " + record.partition());
            }
        }
    }
}
