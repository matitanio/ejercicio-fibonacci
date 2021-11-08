package ar.com.w3.fibonacci.parametros.tipos.estrategias.impresion;

import ar.com.w3.fibonacci.parametros.ParametrosInvalidos;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileWritter {

    private static FileWritter instance;
    private FileWritter(){}
    public static FileWritter getInstance() {

        if(instance == null)
            instance = new FileWritter();
        return instance;
    }

    public void crearArchivo(ContextoEjecucion resultado, String filePathName) {

        Path filePath = Paths.get(filePathName);
        try {
            eliminarSiYaExiste(filePathName);
            Files.createFile(filePath);
            Files.write(filePath,resultado.getResultadoFinal().getBytes("UTF-8"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new ParametrosInvalidos();
        }
    }

    private void eliminarSiYaExiste(String filePathName) throws IOException {

        if(Files.exists(Paths.get(filePathName)))
             Files.delete(Paths.get(filePathName));
    }
}
