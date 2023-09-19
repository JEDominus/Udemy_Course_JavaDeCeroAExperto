package aritmetica;

import exceptions.*;

public class Aritmetica {
    
    //Dado que posiblemente el metodo arroja una exception (throw new ....) debemos indicar la exception en la firma
        //Para ello suamos throw en el metodo
    public static double divisionException(double numerador, double denominador) throws OperacionException{//Con esto ya indicamos la posible exception
        //por default ya sabemos que podemos caer en un AritmeticException, pero debemos validarlo con nuestra exception 
        if(denominador == 0){
            //throw indica que esta exception se va a arrojar 
            throw new OperacionException("Division entre 0");//Error si hereda de Exception y no se firma en el metodo
        }
        return numerador / denominador;
    }
    
    //Por ser RuntimeException, ya no obliga a firmarla al final del nombre del metodo, coo la anterior
        //Codigo un poco mas limpio
    public static double divisionRuntimeException(double numerador, double denominador){
        //Aun asi se debe de crear la exception y lanzarla
        if(denominador == 0){
            //throw indica que esta exception se va a arrojar 
            throw new OperacionRuntimeException("Division entre 0");//No amrca error al no firmar en metodo pues es de runtoime
        }
        return numerador / denominador;
    }
}
