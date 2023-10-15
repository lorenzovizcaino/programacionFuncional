package _3APIStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreams1 {

    public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Ana", "Carlos", "Antonio", "David", "Eva");

        List<String> nombresFiltrados = nombres.stream()
                .filter(nombre -> nombre.length() > 3)          //filtra los nombres de longitud >3
                .map(String::toUpperCase)                       //transforma a mayusculas
                .sorted()                                       //ordena alfabeticamente
                .collect(Collectors.toList());                  //los pasa a la lista nombresFiltrados

        System.out.println(nombresFiltrados);

        //una variante
        nombres.stream()
                .filter(nombre -> nombre.length() > 3)          //filtra los nombres de longitud >3
                .map(String::toUpperCase)                       //transforma a mayusculas
                .sorted()                                       //ordena alfabeticamente
                .forEach(nombre -> System.out.println(nombre)); //lo imprime
    }
}
