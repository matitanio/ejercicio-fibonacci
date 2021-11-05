package ar.com.w3.fibonacci.parametros.parsers;

import ar.com.w3.fibonacci.parametros.ParametrosInvalidos;
import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoOrientacion;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion.EstrategiaOrden;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion.EstrategiaOrientacion;

import java.util.List;

public class ParserParametroTipoOrientacion extends ParserParametros {


    public Parametro porDefecto() {

        return this.ejecutar("-o=hd");
    }

    @Override
    public Parametro doEjecutar() {
        String[] tokens = getTokens();
        String valores = tokens[1];

        if(!valores.matches("h|hd|hi|v|vd|vi"))
            throw new ParametrosInvalidos();

        ParametroTipoOrientacion p= new ParametroTipoOrientacion();
        popularParametro(p);
        popularEstrategias(p);

        return p;

    }

    private void popularEstrategias(ParametroTipoOrientacion p) {
        List<String> opciones = p.getOpciones();

        String direccion = opciones.contains("i")?"i":"d";
        String orientacion = opciones.contains("v")?"v":"h";

        p.setEstrategiaOrden(EstrategiaOrden.getEstrtegia(direccion));
        p.setEstrategiaOrientacion(EstrategiaOrientacion.obtenerEstrategia(orientacion));
    }

}
