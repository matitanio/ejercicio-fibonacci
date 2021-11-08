package ar.com.w3.fibonacci.parametros.parsers;

import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoImpresion;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.impresion.EstrategiaImpresionEnArchivo;

public class ParserParametrosTipoImpresion extends ParserParametros {


    @Override
    public Parametro doEjecutar() {
        return popularParametro(new ParametroTipoImpresion(new EstrategiaImpresionEnArchivo()));
    }

    @Override
    protected String[] splitValues() {
        return new String[]{getValores()};
    }
}
