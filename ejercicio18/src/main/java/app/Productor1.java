package app;


import org.apache.kafka.clients.producer.*;
import java.util.Properties;

public class Productor1 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 1; i <= 5; i++) {
            String mensaje = "Productor1 - Mensaje #" + i;
            producer.send(new ProducerRecord<>("eventos", mensaje));
            System.out.println("Enviado: " + mensaje);
        }
        producer.close();
    }
}
