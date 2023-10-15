package _1ProgramacionFuncional;

import java.util.ArrayList;

public class pruebas {
    public static void main(String[] args) {
        ArrayList<String> nombres= new ArrayList<>();
        nombres.add("Maria");
        nombres.add("ANA");
        nombres.add("DULCINEA");

        nombres.forEach(nombre-> System.out.println(nombre));

        nombres.forEach(System.out::println);
    }
}
