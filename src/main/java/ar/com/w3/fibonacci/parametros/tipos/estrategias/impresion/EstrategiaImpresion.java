package ar.com.w3.fibonacci.parametros.tipos.estrategias.impresion;

import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoImpresion;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;

import java.util.HashMap;
import java.util.Map;

public abstract class EstrategiaImpresion {

    static Map<String, EstrategiaImpresion> estrategias;

    public ParametroTipoImpresion getParamertro() {
        return paramertro;
    }

    public void setParamertro(ParametroTipoImpresion paramertro) {
        this.paramertro = paramertro;
    }

    private  ParametroTipoImpresion paramertro;


    static {
        estrategias = new HashMap<>();
        estrategias.put("f", new EstrategiaImpresionEnArchivo());

    }

    public abstract String imprimir(ContextoEjecucion resultado);
}
