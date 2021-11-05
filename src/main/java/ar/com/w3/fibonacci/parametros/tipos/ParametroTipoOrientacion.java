package ar.com.w3.fibonacci.parametros.tipos;

import ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion.EstrategiaHorizontal;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion.EstrategiaOrdenNatural;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion.EstrategiaOrden;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion.EstrategiaOrientacion;

import java.util.Arrays;

public class ParametroTipoOrientacion extends Parametro {

    private EstrategiaOrientacion estrategiaOrientacion;
    private EstrategiaOrden estrategiaOrden;



    public void setEstrategiaOrientacion(EstrategiaOrientacion estrategiaOrientacion) {
        this.estrategiaOrientacion = estrategiaOrientacion;
    }

    public void setEstrategiaOrden(EstrategiaOrden estrategiaOrden) {
        this.estrategiaOrden = estrategiaOrden;
    }

    @Override
    public String ejecutar(ContextoEjecucion contextoEjecucion) {

        String resultado = estrategiaOrientacion
                .orientar(
                        estrategiaOrden.ordenar(contextoEjecucion.getResultadoParcial()
                        )
                );

        contextoEjecucion.setResultadoFinal(resultado);

        TipoParametro tipoParametroSiguiente = TipoParametro.TIPO_IMPRESION;
        Parametro siguiente =  contextoEjecucion
                .getParametros()
                .getOrDefault(tipoParametroSiguiente, Parametro.obtenerDefault(tipoParametroSiguiente));

        return siguiente
                .ejecutar(contextoEjecucion);


    }

    public static ParametroTipoOrientacion obtenerEstadoPorDefecto(){
        ParametroTipoOrientacion parametroTipoOrientacion = new ParametroTipoOrientacion();
        parametroTipoOrientacion.setEstrategiaOrientacion(new EstrategiaHorizontal());
        parametroTipoOrientacion.setEstrategiaOrden(new EstrategiaOrdenNatural());
        parametroTipoOrientacion.setOpciones(Arrays.asList("h"));

        return parametroTipoOrientacion;

    }


}
