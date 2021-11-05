package ar.com.w3.fibonacci.parametros.parsers;

import ar.com.w3.fibonacci.parametros.ParametrosInvalidos;
import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.TipoParametro;

import java.util.*;

import static ar.com.w3.fibonacci.parametros.tipos.TipoParametro.*;

public class InterpreteDeParametros {

    Map<TipoParametro, Parametro> parametros = new HashMap<>();
    Map<TipoParametro, ParserParametros> parsers = new HashMap();


    public InterpreteDeParametros(){

        parsers.put(TIPO_ORIENTACION, new ParserParametroTipoOrientacion());
        parsers.put(TIPO_CALCULO, new ParserParametrosTipoCalculo());
        parsers.put(TIPO_IMPRESION, new ParserParametrosTipoImpresion());

    }

    public Map<TipoParametro, Parametro> execute(String[] args) {

        parsearParametros(args);

        return parametros;

    }

    public Map<TipoParametro, Parametro> parsearParametros(String[] args) {

        validarQueElUltimoParametroSeaUnNumero(args);
        List<String> listaParametros= Arrays.asList(args).subList(0,args.length-1);
        Integer cantidadNumerosEnLaSerie = Integer.valueOf(args[args.length-1]);

        for(String parametro : listaParametros){

            String nombreParametro = obtenerNombreParametro(parametro);
            TipoParametro tipoParametro = TipoParametro.buscarPorLiteral(nombreParametro);

            parametros.put(tipoParametro,
                    parsearUnParametro(parametro, tipoParametro, cantidadNumerosEnLaSerie));
        }

        return parametros;
    }

    private Parametro parsearUnParametro(String parametroSinParsear, TipoParametro tipoParametro, Integer cantidaNumerosEnLaSerie) {

        return parsers.get(tipoParametro).ejecutar(parametroSinParsear);
    }

    private String obtenerNombreParametro(String parametro) {

        String[] splitted = parametro.split("=");
        if(splitted.length == 1)
            throw new ParametrosInvalidos();

        return splitted[0];

    }

    private void validarQueElUltimoParametroSeaUnNumero(String[] args) {
        if(args.length == 1 && !args[0].matches("\\d+")){
            throw new ParametrosInvalidos();
        }

    }
}
