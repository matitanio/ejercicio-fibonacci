package ar.com.w3.fibonacci.parametros.tipos;
import ar.com.w3.fibonacci.runner.Fibonacci;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;

import java.util.Arrays;
import java.util.List;


public class ParametroTipoCalculo extends Parametro {

    public String ejecutar(ContextoEjecucion contextoEjecucion){

        List<Integer> serie = Fibonacci.getInstance().calcular(contextoEjecucion.getCantidadNumeros());
        TipoParametro tipoParametroSiguiente = TipoParametro.TIPO_ORIENTACION;

        if (opciones.get(0).equals("s")) {

            String calculo = serie.stream().reduce(0, Integer::sum).toString();
            contextoEjecucion.setResultadoFinal(calculo);
            tipoParametroSiguiente = TipoParametro.TIPO_IMPRESION;
        }

        contextoEjecucion.setResultadoParcial(serie);
        Parametro siguiente =  contextoEjecucion
                .obtenerParametro(tipoParametroSiguiente);

        return siguiente.ejecutar(contextoEjecucion);
    }

    public static ParametroTipoCalculo obtenerEstadoPorDefecto(){
        ParametroTipoCalculo p = new ParametroTipoCalculo();
        p.setOpciones(Arrays.asList("l"));

        return p;

    }
}
