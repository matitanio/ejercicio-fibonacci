package ar.com.w3.fibonacci.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {

    private static List<Integer> serieEn1 = Arrays.asList(0);
    private static Fibonacci instance;


    private Fibonacci() {}

    public static Fibonacci getInstance(){

        if(instance == null)
            instance = new Fibonacci();

        return instance;
    }


    public List<Integer> calcular(Integer cantidad) {

        List<Integer> serie;
        if(esSerieBaseEn1(cantidad)){
            return serieEn1;
        }
        serie = crearSerieBaseEn2();
        return calcularSerie(serie, cantidad);
    }

    private boolean esSerieBaseEn1(Integer cantidad) {
        return cantidad == 1;
    }


    private List<Integer> crearSerieBaseEn2() {
        return new ArrayList<>(Arrays.asList(0,1));
    }

    private List<Integer> calcularSerie(List<Integer> serie, Integer cantidad) {
        for (int i = 2; i < cantidad; i++) {
            Integer nuevoNumero = serie.get(i-2) + serie.get(i-1);
            serie.add(nuevoNumero);
        }


        return serie;
    }


}
