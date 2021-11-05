package ar.com.w3.fibonacci.parametros.tipos.estrategias.orientacion;

import java.util.Collections;
import java.util.List;

public class EstrategiaOrdenInverso extends EstrategiaOrden {

    @Override
    public List<Integer> ordenar(List<Integer> lista) {
        Collections.reverse(lista);
        return lista;
    }
}
