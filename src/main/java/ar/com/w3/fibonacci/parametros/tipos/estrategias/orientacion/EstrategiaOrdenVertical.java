package ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion;

import java.util.List;

public class EstrategiaOrdenVertical extends EstrategiaOrientacion {
    @Override
    public String orientar(List<Integer> lista) {
        return imprimir(lista, "\n");
    }
}
