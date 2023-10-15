package _3APIStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EjemploStreams5 {

    public static void main(String[] args) {

        // Ejemplo para ordenar las distintas palabras de una String según la cantidad
        // caracteres que tiene la palabra, de más caracteres a menos
        String texto = "Voy a aprobar programación con buena nota";
        List<String> palabrasOrdenadasPorLongitud = Arrays.stream(texto.split("\\s+"))    //coge la cadena y separa las palabras por los espacios
                .distinct()                                                                     //elimina palabras duplicadas
                .sorted(Comparator.comparingInt(String::length).reversed())                     //ordena las palabras comparando el tamaño de letras, el reversed es para que sea de mayor a menor, sin el las ordenaria de menor a mayor
                .toList();                                                                      //las mete en la lista
        System.out.println("Palabras ordenadas por longitud: " + palabrasOrdenadasPorLongitud);

    }
}
