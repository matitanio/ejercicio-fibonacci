package ar.com.w3.fibonacci;

import ar.com.w3.fibonacci.runner.FibonacciCommandLineExecuter;

public class FibonacciRunner {

    public static void main(String []args){

       System.out.println(new FibonacciCommandLineExecuter().execute(args));
    }
}
