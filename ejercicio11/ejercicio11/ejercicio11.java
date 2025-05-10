import io.reactivex.rxjava3.core.Observable;
import java.util.Scanner;

public class ejercicio11 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);   
        System.out.println("Introduce un numero:");
        int numero = scanner.nextInt();
        scanner.close();

        Observable<Integer> observable = Observable.range(1, numero);

        observable
            .filter(i -> i % 3 == 0)
            .subscribe(i -> System.out.println("Los multiplos de 3 son: " + i));
    }
}
