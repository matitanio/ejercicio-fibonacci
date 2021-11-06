package ar.com.w3.fibonacci.parametros.tipos.estrategias.output;

import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoImpresion;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;

public class EstrategiaImpresionPorConsola extends EstrategiaImpresion{



    @Override
    public String imprimir(ContextoEjecucion contextoEjecucion) {

        return contextoEjecucion.getResultadoPorConsola(this);
    }
}
