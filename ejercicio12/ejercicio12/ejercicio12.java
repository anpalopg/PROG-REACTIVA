import io.reactivex.rxjava3.core.Observable;
import java.util.ArrayList;
import java.util.List;

public class ejercicio12 {
   public static void main(String[] args) {
      List<String> paises = new ArrayList<>();
      paises.add("Colom");
      paises.add("Argen");
      paises.add("Méx");
      paises.add("Esp");
      paises.add("Chil");

      Observable<String> observable = Observable.fromIterable(paises);

      observable
         .map(p -> "País recibido: " + p.toUpperCase())
         .subscribe(System.out::println);
   }
}
