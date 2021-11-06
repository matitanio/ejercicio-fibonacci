package ar.com.w3.fibonacci.parametros.tipos.estrategias.output;

import ar.com.w3.fibonacci.parametros.ParametrosInvalidos;
import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoImpresion;
import ar.com.w3.fibonacci.parametros.tipos.TipoParametro;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EstrategiaImpresionEnArchivo extends EstrategiaImpresion {

    FileWritter fw = FileWritter.getInstance();

    public void setFileWritter(FileWritter fw){
        this.fw = fw;
    }

    @Override
    public String imprimir(ContextoEjecucion contextoEjecucion) {
        String filePathName = contextoEjecucion.getResultadoPorConsola(this);
        fw.crearArchivo(contextoEjecucion, filePathName);
        return filePathName;
    }


}
