package ar.com.w3.fibonacci.parametros.tipos;

import ar.com.w3.fibonacci.parametros.tipos.estrategias.output.EstrategiaImpresion;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.output.EstrategiaImpresionPorConsola;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;

public class ParametroTipoImpresion extends Parametro {

    private EstrategiaImpresion estrategiaImpresion;

    public ParametroTipoImpresion(EstrategiaImpresion estrategiaImpresion){
        this.estrategiaImpresion = estrategiaImpresion;
    }

    @Override
    public String ejecutar(ContextoEjecucion contextoEjecucion) {

        return estrategiaImpresion.imprimir(contextoEjecucion.getResultadoFinal());
    }

    public static ParametroTipoImpresion obtenerEstadoPorDefecto(){

        return new ParametroTipoImpresion(new EstrategiaImpresionPorConsola());

    }
}
