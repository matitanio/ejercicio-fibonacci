package ar.com.w3.fibonacci.parametros.tipos;

import ar.com.w3.fibonacci.parametros.tipos.estrategias.impresion.EstrategiaImpresion;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.impresion.EstrategiaImpresionPorConsola;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;

public class ParametroTipoImpresion extends Parametro {

    private EstrategiaImpresion estrategiaImpresion;

    public String getNombreArchivo(){

        return opciones.get(0);
    }
    public ParametroTipoImpresion(EstrategiaImpresion estrategiaImpresion){
        this.estrategiaImpresion = estrategiaImpresion;
        this.estrategiaImpresion.setParamertro(this);
    }

    @Override
    public String ejecutar(ContextoEjecucion contextoEjecucion) {

        return estrategiaImpresion.imprimir(contextoEjecucion);
    }

    public static ParametroTipoImpresion obtenerEstadoPorDefecto(){

        return new ParametroTipoImpresion(new EstrategiaImpresionPorConsola());

    }
}
