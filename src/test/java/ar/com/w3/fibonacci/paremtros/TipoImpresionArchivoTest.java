package ar.com.w3.fibonacci.paremtros;

import ar.com.w3.fibonacci.parametros.tipos.Parametro;
import ar.com.w3.fibonacci.parametros.tipos.ParametroTipoImpresion;
import ar.com.w3.fibonacci.parametros.tipos.TipoParametro;
import ar.com.w3.fibonacci.parametros.tipos.estrategias.impresion.EstrategiaImpresionEnArchivo;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TipoImpresionArchivoTest {

    @Before
    public void borrarArchivo() throws IOException {
        String rutaArchivo = crearNombreArchivo();
        if(Files.exists(Paths.get(rutaArchivo)))
            Files.delete(Paths.get(rutaArchivo));
    }

    private void givenQueExisteUnArchivoConElMismoNOmbrePrevio(String rutaArchivo) throws IOException {

        Path filePath = Paths.get(rutaArchivo);

        Files.createFile(filePath);
        Files.write(filePath,"uncontenido".getBytes("UTF-8"), StandardOpenOption.APPEND);

    }

    private String crearNombreArchivo() {
        Path resourceDirectory = Paths.get("src","test","resources");

        return resourceDirectory.toFile().getAbsolutePath()+"/resultado.txt";
    }

    @Test
    public void seCreaElArchivoCorrectamente() throws IOException {
        String rutaArchivo = crearNombreArchivo();
        String resultado = "0 1 1 2 3";
        ParametroTipoImpresion p = new ParametroTipoImpresion(new EstrategiaImpresionEnArchivo());
        p.setOpciones(Arrays.asList(rutaArchivo));
        Map<TipoParametro, Parametro> parametrosMap = new HashMap<>();
        parametrosMap.put(TipoParametro.TIPO_IMPRESION, p);

        ContextoEjecucion c = new ContextoEjecucion(4,parametrosMap);
        c.setResultadoFinal(resultado);

        assertEquals(rutaArchivo,p.ejecutar(c));
        Path filePath = Paths.get(rutaArchivo);
        assertEquals(resultado, Files.readString(filePath));

    }

    @Test
    public void seCreaElArchivoCorrectamenteCuandoYaExistiaUnoPrevioQueSeLLamabaIgual() throws IOException {
        String rutaArchivo = crearNombreArchivo();

        givenQueExisteUnArchivoConElMismoNOmbrePrevio(rutaArchivo);

        String resultado = "0 1 1 2 3";
        ParametroTipoImpresion p = new ParametroTipoImpresion(new EstrategiaImpresionEnArchivo());
        p.setOpciones(Arrays.asList(rutaArchivo));
        Map<TipoParametro, Parametro> parametrosMap = new HashMap<>();
        parametrosMap.put(TipoParametro.TIPO_IMPRESION, p);

        ContextoEjecucion c = new ContextoEjecucion(4,parametrosMap);
        c.setResultadoFinal(resultado);

        assertEquals(rutaArchivo,p.ejecutar(c));
        Path filePath = Paths.get(rutaArchivo);
        assertEquals(resultado, Files.readString(filePath));

    }



}
