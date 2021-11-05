package ar.com.w3.fibonacci.parametros.parsers;

import ar.com.w3.fibonacci.parametros.ParametrosInvalidos;
import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoImpresion;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.output.EstrategiaImpresionEnArchivo;

public class ParserParametrosTipoImpresion extends ParserParametros {


    @Override
    public Parametro doEjecutar() {
        String[] tokens = getTokens();
        String valores = tokens[1];
        if(!valores.matches("f"))
            throw new ParametrosInvalidos();

        return new ParametroTipoImpresion(new EstrategiaImpresionEnArchivo());
    }


}
