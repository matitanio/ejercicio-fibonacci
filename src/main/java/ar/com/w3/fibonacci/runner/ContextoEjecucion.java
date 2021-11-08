package ar.com.w3.fibonacci.runner;

import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoImpresion;
import ar.com.w3.fibonacci.parametros.tipos.TipoParametro;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.output.EstrategiaImpresionEnArchivo;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.output.EstrategiaImpresionPorConsola;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ContextoEjecucion {

    private List<Integer> resultadoParcial;
    private String resultadoFinal;
    private Integer cantidadNumeros;
    private Map<TipoParametro, Parametro> parametros;

    public ContextoEjecucion( Integer cantidadNumeros, Map<TipoParametro, Parametro> parametros) {
        this.cantidadNumeros = cantidadNumeros;
        this.parametros = parametros;
    }

    public List<Integer> getResultadoParcial() {
        return resultadoParcial;
    }

    public void setResultadoParcial(List<Integer> resultadoParcial) {
        this.resultadoParcial = resultadoParcial;
    }

    public Integer getCantidadNumeros() {
        return cantidadNumeros;
    }


    public Map<TipoParametro, Parametro> getParametros() {
        return parametros;
    }

    public String getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(String resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    public void setParametros(Map<TipoParametro, Parametro> parametros) {
        this.parametros = parametros;
    }

    public String getResultadoPorConsola(EstrategiaImpresionEnArchivo requester){

        return requester.getParamertro().getNombreArchivo();
    }

    public String getResultadoPorConsola(EstrategiaImpresionPorConsola requester){

        return resultadoFinal;
    }

    public Parametro obtenerParametro(TipoParametro tipoParametro){

        return this.
                parametros.getOrDefault(tipoParametro,Parametro.obtenerDefault(tipoParametro));
    }
}
