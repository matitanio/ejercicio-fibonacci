package ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EstrategiaOrientacion {


    public abstract String orientar(List<Integer> lista);

    static Map<String,EstrategiaOrientacion> estrategias;

    static {
        estrategias = new HashMap<>();
        estrategias.put("h", new EstrategiaHorizontal());
        estrategias.put("v", new EstrategiaOrdenVertical());
    }

    public static EstrategiaOrientacion obtenerEstrategia(String tipo){

        return estrategias.get(tipo);
    }

    protected String imprimir(List<Integer> serieFibonacci, String s) {
        StringBuilder resultado = new StringBuilder();
        for (Integer numero : serieFibonacci) {

            resultado.append(numero).append(s);
        }

        resultado.deleteCharAt(resultado.lastIndexOf(s));

        return resultado.toString();
    }
}
