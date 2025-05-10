package app;


import org.apache.kafka.clients.consumer.*;
import java.util.Collections;
import java.util.Properties;

public class Consumidor3 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "grupo-consumidor3");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("eventos"));

        while (true) {
            for (ConsumerRecord<String, String> record : consumer.poll(1000)) {
                System.out.println("Consumidor3 recibió: " + record.value());
            }
        }
    }
}
