package ar.com.w3.fibonacci.parametros.parsers;

import ar.com.w3.fibonacci.parametros.ParametrosInvalidos;
import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoCalculo;

public class ParserParametrosTipoCalculo extends ParserParametros {


    @Override
    public Parametro doEjecutar() {
        String[] tokens = getTokens();
        String valores = tokens[1];

        if(!valores.matches("l|s"))
            throw new ParametrosInvalidos();

        return popularParametro(new ParametroTipoCalculo());
    }


}
