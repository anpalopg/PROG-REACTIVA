import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Source;
import scala.concurrent.Future; 


import java.util.*;

public class ejercicio13 {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ejercicio13");
        ActorMaterializer materializer = ActorMaterializer.create(system);

        List<String> numberWords = Arrays.asList(
            "cero", "uno", "dos", "tres", "cuatro", 
            "cinco", "seis", "siete", "ocho", "nueve", "diez"
        );

        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        System.out.println("Introduce 5 números entre 0 y 10 para convertir su equivalente en letras:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int numero = scanner.nextInt();
            if (numero >= 0 && numero <= 10) {
                numeros.add(numero);
            } else {
                System.out.println("Número fuera de rango. Debe ser entre 0 y 10.");
            }
        }

        Source.from(numeros)
              .map(numberWords::get)
              .runForeach(System.out::println, materializer)
              .thenRun(system::terminate);
    }
}
