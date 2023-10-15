package _3APIStream;
import java.util.Arrays;
import java.util.List;
//Ejemplo para filtrar los numeros pares de una lista, calcular el cuadrado de los filtrados y sumarlos
public class EjemploStreams2 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);

        int sumaCuadradosPares = numeros.stream()
                .filter(n -> n % 2 == 0)                //filtramos los numeros pares de la lista (le llamamos n como podria ser numero o lo que sea
                .map(n -> n * n)                        //nos quedamos con el cuadrado de cada numero que paso el filtro
                .reduce(0, Integer::sum);        //dos parametros 0--> es el valor inicial al cual se le sumara cada uno de los numeros que han llegado hasta aqui (es como suma+=numero)

        System.out.println(sumaCuadradosPares);


        List<String> palabras=Arrays.asList("a","ab","abc","abcd");

        String frase=palabras.stream()
                .filter(palabra->palabra.length()>1)        //filtramos las palabras de mas de 1 caracter (le llamamos palabra, pero valdria cualquier nombre
                .map(palabra -> palabra+"_")                            //le añadimos a cada palabra un _
                .reduce("Frase: ",String::concat);  //unimos el valor inicial "Frase" con la concatenacion de nuestras palabras que han llegado hasta aqui
        System.out.println(frase);

    }
}
