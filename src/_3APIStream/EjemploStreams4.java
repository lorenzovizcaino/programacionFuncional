package _3APIStream;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class EjemploStreams4 {

    public static void main(String[] args) {

        // Ejemplo para encontrar el número de palabras únicas en una String
        //  "\\s+" --> el caracter para separar las palabras es un espacio o mas
        String texto = "Ejemplo ejemplo texto   texto texto";

        Set<String> palabrasUnicas = Arrays.stream(texto.split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        System.out.println("Numero de palabras unicas: " + palabrasUnicas.size()); // 2





        // Ejemplo para ordenar las palabras de una String en orden alfabético
        texto = "Ejemplo de ordenamiento alfabetico utilizando la API Stream de Java";

        System.out.println("Palabras ordenadas alfabeticamente:");
        String s = Arrays.stream(texto.split("\\s+"))
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.joining(" - "));

        System.out.println(s + ".");

    }
}
