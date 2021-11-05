package ar.com.w3.fibonacci;

import ar.com.w3.fibonacci.runner.Fibonacci;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FibonacciTests {


    @Test
    public void elPrimerNumeroDeLaSerieEs0(){

        Integer[] expected = {0};

        assertArrayEquals(expected,toArray(1));
    }

    @Test
    public void losDosPrimerosDeLaSerieSon0y1(){

        Integer[] expected = {0,1};

        assertArrayEquals(expected,toArray(2));
    }

    @Test
    public void losTresPrimerosDeLaSerieSon0y1y1(){

        Integer[] expected = {0,1,1};

        assertArrayEquals(expected,toArray(3));
    }

    @Test
    public void fibonacciEn4(){

        Integer[] expected = {0,1,1,2};

        assertArrayEquals(expected,toArray(4));
    }

    @Test
    public void fibonacciEn5(){

        Integer[] expected = {0,1,1,2,3};

        assertArrayEquals(expected,toArray(5));
    }

    @Test
    public void fibonacciEn7(){

        Integer[] expected = {0,1,1,2,3,5,8};

        assertArrayEquals(expected,toArray(7));
    }

    @Test
    public void fibonacciEn9(){

        Integer[] expected = {0,1,1,2,3,5,8,13,21};

        assertArrayEquals(expected,toArray(9));
    }

    private Integer[] toArray(Integer cantidad){

        List<Integer> serie = Fibonacci.getInstance().calcular(cantidad);
        return serie.toArray(Integer[]::new);
    }

}
