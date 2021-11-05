package ar.com.w3.fibonacci.parametros.tipos;

import ar.com.w3.fibonacci.runner.ContextoEjecucion;

import java.util.*;

import static ar.com.w3.fibonacci.parametros.tipos.TipoParametro.*;

public abstract class Parametro {


    protected List<String> opciones = new ArrayList<>();

    static Map<TipoParametro, Parametro> parametrosPorDefecto;

    static {
        parametrosPorDefecto = new HashMap<>();
        parametrosPorDefecto.put(TIPO_CALCULO, ParametroTipoCalculo.obtenerEstadoPorDefecto());
        parametrosPorDefecto.put(TIPO_IMPRESION, ParametroTipoImpresion.obtenerEstadoPorDefecto());
        parametrosPorDefecto.put(TIPO_ORIENTACION, ParametroTipoOrientacion.obtenerEstadoPorDefecto());

    }

    public  abstract String ejecutar(ContextoEjecucion contextoEjecucion);

    public List<String> getOpciones() {
        return opciones;
    }



    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public static Parametro obtenerDefault(TipoParametro tipo) {

        return parametrosPorDefecto.get(tipo);
    }

}
