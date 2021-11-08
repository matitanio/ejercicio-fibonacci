package ar.com.w3.fibonacci;

import ar.com.w3.fibonacci.parametros.tipos.estrategias.impresion.FileWritter;
import ar.com.w3.fibonacci.runner.ContextoEjecucion;
import ar.com.w3.fibonacci.runner.FibonacciCommandLineExecuter;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FibonacciCommandLineTests {



    @Test
    //java -jar fibo.jar -o=h 4
    public void seInvocaALaLineaDeComandoConLaOpcionOigualh(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();

        String[] args = {"-o=h", "4"};

        assertEquals("0 1 1 2",commandLineExecuter.execute(args));
    }

    @Test
    //java -jar fibo.jar -o=hd
    public void seInvocaALaLineaDeComandoConLaOpcionOigualhd(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();

        String[] args = {"-o=hd", "4"};

        assertEquals("0 1 1 2",commandLineExecuter.execute(args));
    }


    @Test
    //java -jar fibo.jar -o=v
    public void seInvocaALaLineaDeComandoConLaOpcionOigualv(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();

        String[] args = {"-o=v", "4"};

        assertEquals("0\n1\n1\n2",commandLineExecuter.execute(args));
    }

    @Test
    //java -jar fibo.jar -o=v
    public void seInvocaALaLineaDeComandoConLaOpcionOigualvd(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();

        String[] args = {"-o=vd", "4"};

        assertEquals("0\n1\n1\n2",commandLineExecuter.execute(args));
    }

    @Test
    //java -jar fibo.jar -o=v
    public void seInvocaALaLineaDeComandoConOpcionesIncorrectas(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();


        String[] args = {"-o=dv", "4"};
        String error = "Opción no válida";
        assertEquals(error,commandLineExecuter.execute(args));

        String[] args2 = {"-j", "4"};
        assertEquals(error,commandLineExecuter.execute(args2));

        String[] args3 = {"-dh", "4"};
        assertEquals(error,commandLineExecuter.execute(args3));

        String[] args4 = {"-o=dv"};
        assertEquals(error,commandLineExecuter.execute(args4));

        String[] args5 = {"-m=j"};
        assertEquals(error,commandLineExecuter.execute(args5));

    }


    @Test
    //java -jar fibo.jar 4
    public void seInvocaALaLineaDeComandoSinLaOpcionO(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();

        String[] args = {"4"};

        assertEquals("0 1 1 2",commandLineExecuter.execute(args));
    }

    @Test
    //java -jar fibo.jar  -v=hi 4
    public void seInvocaALaLineaDeComandoConLaOpcionOigualhi(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();

        String[] args = {"-o=hi", "4"};

        assertEquals("2 1 1 0",commandLineExecuter.execute(args));
    }


    @Test
    //java -jar fibo.jar  -v=hi -m=s 4
    public void seInvocaALaLineaDeComandoConLaOpcionOigualhiYSumatoria(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();

        String[] args = {"-o=hi","-m=s","5"};

        assertEquals("7",commandLineExecuter.execute(args));
    }

    @Test
    //java -jar fibo.jar  -v=hi 4
    public void seInvocaALaLineaDeComandoConLaOpcionOigualhiYmIgualaLista(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();

        String[] args = {"-o=hi", "-m=l", "4"};

        assertEquals("2 1 1 0",commandLineExecuter.execute(args));
    }

    @Test
    //java -jar fibo.jar  -v=hi 4
    public void seInvocaALaLineaDeComandoConLaOpcionGuardarEnUnArchivo(){

        FibonacciCommandLineExecuter commandLineExecuter= new FibonacciCommandLineExecuter();
        FileWritter fileWriterMock = mock(FileWritter.class);
        try (MockedStatic<FileWritter> utilities = Mockito.mockStatic(FileWritter.class)) {
            utilities.when(FileWritter::getInstance).thenReturn(fileWriterMock);

            String rutaArchio= "/resultado.txt";
            String[] args = {"-o=hi", "-m=l","-f="+rutaArchio, "4"};

            assertEquals(rutaArchio,commandLineExecuter.execute(args));

            verify(fileWriterMock, times(1)).crearArchivo(ArgumentMatchers.isA(ContextoEjecucion.class),ArgumentMatchers.eq(rutaArchio));
        }


    }




}
