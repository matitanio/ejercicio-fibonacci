package ar.com.w3.fibonacci.parametros.tipos.estrategias.impresion;

import ar.com.w3.fibonacci.runner.ContextoEjecucion;

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
