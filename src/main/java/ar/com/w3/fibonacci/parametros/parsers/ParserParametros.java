package ar.com.w3.fibonacci.parametros.parsers;

import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.TipoParametro;

import java.util.Arrays;

public abstract class ParserParametros {

    protected String parametroSinParsear;
    protected String[] tokens;



    public Parametro ejecutar(String parametroSinParsear) {
        this.parametroSinParsear = parametroSinParsear;
        this.tokens = parametroSinParsear.split("=");
        return doEjecutar();
    }

    protected abstract Parametro doEjecutar();
    protected String[] getTokens( ){

        return tokens;
    }
    protected String getParametro(){
        return tokens[0];
    }
    protected String getValores(){
        return tokens[1];
    }

    protected Parametro popularParametro(Parametro p) {

        p.setOpciones(
                Arrays.asList(getValores().split(""))
        );

        return p;
    }
}
