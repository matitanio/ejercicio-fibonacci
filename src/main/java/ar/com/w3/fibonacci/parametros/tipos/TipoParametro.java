package ar.com.w3.fibonacci.parametros.tipos;

import ar.com.w3.fibonacci.parametros.ParametrosInvalidos;

public enum TipoParametro {
    TIPO_ORIENTACION("-o"), TIPO_IMPRESION("-f"),TIPO_CALCULO("-m");

    private String literal;
    TipoParametro(String literal){
        this.literal = literal;
    }

    public static TipoParametro buscarPorLiteral(String literal){

        for(TipoParametro tp : values()){
            if(tp.literal.equals(literal))
                return tp;
        }
        throw new ParametrosInvalidos();
    }

}
