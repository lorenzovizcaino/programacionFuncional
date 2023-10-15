package _3APIStream;
import java.util.Collection;
import java.util.List;

public class EjemploStreams3 {

    public static void main(String[] args) {

        List<Integer> lista1 = List.of(2, 1,  4,  6, 8, 10);
        List<Integer> lista2 = List.of(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<Integer> lista3 = List.of(21, 22, 23, 24, 25, 26, 27, 28, 29, 30);
        List<Integer> lista4 = List.of(31, 32, 33, 34, 35, 36, 37, 38, 39, 40);
        List<List<Integer>> listaFinal = List.of(lista1, lista2, lista3, lista4);

        // EJEMPLO 1
        List<Integer> listaFiltrada = listaFinal.stream()
                .flatMap(Collection::stream)                    //aplanamos, es decir la listaFinal que esta formada por 4 listas se convierte en una sola lista con los elementos de las 4
                .peek(n -> System.out.print(n + " "))           //peek: nos sirve para ir viendo como se va transformando este Stream
                .filter(n -> n % 10 == 0)                        //filtra los multiplos de 10
                .peek(n -> System.out.print(n + " "))
                .map(n -> n / 10)                                //los divide por 10
                .peek(n -> System.out.print(n + " "))
                .toList();                                       //los mete en la lista

        System.out.println(listaFiltrada); // [1, 2, 3, 4]

        // EJEMPLO 2
        int cantidad = (int) listaFinal.stream()
                .flatMap(Collection::stream)                  //aplanamos, es decir la listaFinal que esta formada por 4 listas se convierte en una sola lista con los elementos de las 4
                .filter(n -> n % 10 == 0)                     //filtramos los multiplos de 10
                .map(n -> n / 10)                             //los divide por 10
                .count();                                     //Cuenta la cantidad de numeros que han llegado hasta aqui

        System.out.println(cantidad); // 4

        // EJEMPLO 3
        int total = listaFinal.stream()
                .flatMap(Collection::stream)
                .filter(n -> n % 10 == 0)
                .map(n -> n / 10)
                .reduce(0, (acumulado, n) -> acumulado + n * 2);  //sumamos partiendo de 0 la suma de los numeros multiplicados por dos

        System.out.println(total); // 2 + 4 + 6 + 8 = 20

        // EJEMPLO 4
        List<Integer> menores = listaFinal.stream()
                .flatMap(Collection::stream)
                .takeWhile(n -> n < 20)   //metemos en la lista los numeros que sean menor que 20, en el momento que uno de ellos no cumpla la condicion termina (como si fuera un break; en un bucle
                .toList();

        System.out.println(menores); // 1-19

        // EJEMPLO 5
        List<Integer> mayores = listaFinal.stream()
                .flatMap(Collection::stream)
                .dropWhile(n -> n < 20)     //elimina los números mientras no se cumpla la condicion
                .toList();

        System.out.println(mayores); // 20-40

        // EJEMPLO 6
        List<Integer> ninguno = listaFinal.stream()
                .flatMap(Collection::stream)
                .takeWhile(n -> n % 2 == 0)                 //toma elementos mientras sea par, en este caso como el primer numero es un 1 no toma ningun elemento
                .toList();

        System.out.println(ninguno); // no hay elementos
        
        // EJEMPLO 7
        List<Integer> todos = listaFinal.stream()
                .flatMap(Collection::stream)
                .dropWhile(n -> n % 2 == 0)             //borrara mientras encuentre pares, como el primer elemento es un 1, no borra ninguna
                .toList();

        System.out.println(todos); // 1-40
    }
}
