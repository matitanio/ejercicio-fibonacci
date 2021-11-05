package ar.com.w3.fibonacci.parametros.tipos.estrategias.output;

import java.util.HashMap;
import java.util.Map;

public abstract class EstrategiaImpresion {

    static Map<String, EstrategiaImpresion> estrategias;

    static {
        estrategias = new HashMap<>();
        estrategias.put("f", new EstrategiaImpresionEnArchivo());

    }

    public abstract String imprimir(String resultado);
}
