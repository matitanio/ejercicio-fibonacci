package ar.com.w3.fibonacci.runner;

import ar.com.w3.fibonacci.parametros.ParametrosInvalidos;
import ar.com.w3.fibonacci.parametros.parsers.InterpreteDeParametros;
import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.TipoParametro;

import java.util.Map;
import java.util.Optional;

public class FibonacciCommandLineExecuter {


    private InterpreteDeParametros interpreteDeParametros = new InterpreteDeParametros();

    public String execute(String[] args) {

        String resultado;
        try {
            resultado = doExecute(args);
        }catch(ParametrosInvalidos pe){
            resultado = "Opción no válida";
        }
        return resultado;
    }

    private String doExecute(String[] args){

        Map<TipoParametro, Parametro>  parametros = interpreteDeParametros.execute(args);
        Integer cantidadNumeros = Integer.valueOf(args[args.length -1]);
        ContextoEjecucion contextoEjecucion = new ContextoEjecucion(cantidadNumeros, parametros);

        return contextoEjecucion
                .obtenerParametro(TipoParametro.TIPO_CALCULO)
                .ejecutar(contextoEjecucion);

    }



}
