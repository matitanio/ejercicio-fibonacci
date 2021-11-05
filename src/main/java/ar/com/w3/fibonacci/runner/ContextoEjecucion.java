package ar.com.w3.fibonacci.runner;

import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.TipoParametro;

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

    public void setCantidadNumeros(Integer cantidadNumeros) {
        this.cantidadNumeros = cantidadNumeros;
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
}
