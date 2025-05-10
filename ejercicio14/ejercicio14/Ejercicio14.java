import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.*;

public class Ejercicio14 {
    public static void main(String[] args) {
        String topico = "eventos";


        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");  // Dirección de tu servidor Kafka
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());


        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        Scanner scanner = new Scanner(System.in);
        List<String> mensajes = new ArrayList<>();

        System.out.println("Introduce 5 mensajes:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Mensaje " + (i + 1) + ": ");
            String mensaje = scanner.nextLine();
            mensajes.add(mensaje);
        }

  
        for (String mensaje : mensajes) {
            producer.send(new ProducerRecord<>(topico, mensaje));
            System.out.println("Enviado: " + mensaje);
        }

  
        producer.close();
        System.out.println("Todos los mensajes han sido enviados.");
    }
}
