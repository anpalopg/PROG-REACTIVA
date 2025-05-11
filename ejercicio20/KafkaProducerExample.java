package com.mycompany.ejercicio200;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerExample {

    public static void main(String[] args) {
        
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Dirección de tu broker Kafka
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        ProducerRecord<String, String> record = new ProducerRecord<>("my-topic", "key", "Hello Kafka!");
        try {
            producer.send(record);
            System.out.println("Mensaje enviado: " + record.value());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close(); 
        }
    }

    static Thread sendMessage() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
