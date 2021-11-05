package ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EstrategiaOrden {

    static Map<String,EstrategiaOrden> estrategias;

    static {
        estrategias = new HashMap<>();
        estrategias.put("d", new EstrategiaOrdenNatural());
        estrategias.put("i", new EstrategiaOrdenInverso());
    }

    public static EstrategiaOrden getEstrtegia(String tipo){

        return estrategias.get(tipo);
    }

    public abstract  List<Integer> ordenar(List<Integer> lista);
}
