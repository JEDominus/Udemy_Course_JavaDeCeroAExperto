package test;

import exceptions.OperacionException;
import static aritmetica.Aritmetica.*;

public class TestExcepcions {
    /*Exceptiones resumen
      Checked Exception                      Unchecked Exception
        - Hereda de Exception                  - Hereda de RuntimeException
        - Requiere throws en metodo            - No requiere throws en metodo
        - Requiere blocke try-catch            - No requiere bloque try catch
        - Exception mas limpia                 - Exception clasica
        - Permite continuar con el programa    - Programa termina abruptamente
        - exceptionPersonalizada()             - runtimeExceptionPersonalizada()
    */
    
    public static void main(String[] args){
        //manejoDeExceptions1();
        //tiposDeExceptions();
        //exceptionPersonalizada();
        //runtimeExceptionPersonalizada();
        tryCatchDetalles();
    }
    
    public static void manejoDeExceptions1(){
        //Sintaxis basica para el manejo de una exception
        
            //ejemplo de una division entre 0
        //int resultado = 10/0;//Lanza aritmetic exception
        //El log muestra la clase y la linea en que se ha mandado la exception (Donde ha tronado)
            //El programa termina de manera abrupta
            //Hay que buscar la forma de recuperarse de ese tipo de errores 
        
        //1.- definimos una variable resultado fuera del bloque try catch para poder usarla al final del mismo
        int resultado = 0;
        
        try{//Se envuelve dentro del bloque lo que puede tronar con la exception
            resultado = 10/0;
        }catch(ArithmeticException e){//Se define la exception que puede presentarse - Hereda de Runtime 
            //Se puede agregar un mensaje al eror
            System.out.println("Ocurrio un error");
            //Esta clase de exception ya existe en java, epro son personalizables
                //Una exception puede generar otras
            e.printStackTrace(System.out);//Con esto se imprime la pila de exceptiones.. 
                //Despues se define donde la queremos imprimir (No requerido)
        }
        //El resultado impreso el el de default, ya que el programa no se rompio, se cacho la exception y continuo sin problemas
        System.out.println("resultado = " + resultado);
        //Ahora ya no se tiene nada en rojo, si no que muestra la exception y termina el programa normalmente
            //Aun asi, no se co,mpleto la operacion, pero se manejo bien la exception y el programa continuo
    }
    
    public static void tiposDeExceptions(){
        //La clase padre de las exceptiones es Throwable (Object pero en exceptios) 
            //Sin embargo, esa clase no se usa en el codigo, la siguiente inmediata a ella es "Exception"
        //Throwable  ->  Exception(clase padre)... ... ... A aprtir de aqui podemos crear nuestras exceptions
        //    SQLException|    |RuntimeException
        //                                 |NullPointerException
        
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Existen 2 clasificaciones de exceptions
            //1.- Checked exception   - Si hereda de "Exception"... Compilador obliga a agregar try catch o propagarla (Firma del metodo con throws)
            //2.- Unchecked exception - Si hereda de "RuntimeException"... Compilador no obliga try catch o reportar la exception
        //Dado que la AritmetiException hereda de runtime, es una unchecked exception y el compilador no la marca
            //Son las exceptionsd que ocurren en tiempo de ejecucion solamente
    }
    
    //Dado que se llama a un metodo que tira la OperacionException de la clase Aritmetica
    public static void exceptionPersonalizada() {//No fue necesario agregarla en la firma ya que se tiene un try con el tipo generico Exception
        //Revisar clase aritmetica y OperacionException para detalles de la implementacion
        
        double result = 0;
        
        try{
            //este metodo puede tirar la OperacionException
                //Importado estaticamente del metodo
            result = divisionException(10, 0);
        }catch(Exception e){//Se puede cachar la exception padre de la hija que esta en el bloque try
            //Se lanza nuestra exception personalizada dado que se definio eso en la clase aritmetica
            System.out.println("Ocurrio un error");
            e.printStackTrace(System.out);
            //Con el metodo get message podemos obtener el mensaje solamente
            System.out.println(e.getMessage());//Impresion adicional del mensaje "Division entre 0"
        }
        
        System.out.println("result = " + result);
    }
    
    public static void runtimeExceptionPersonalizada(){
        //Debido a que la exception de runtime no requiere de la firma de la exception en el metodo
            //Tambien se puede omitir el bloque try catch y no marcara problema el compilador
        double result = divisionRuntimeException(10, 0);
        System.out.println("result = " + result);
        
        //Se recomienda usar Exception cuando estemos seguros que una exception puede ocurrir
        //Usar Runtime cuando no para mantener el codigo mas limpio 
    }
    
    public static void tryCatchDetalles() {//Hereda de Exception, no se firma dado bloque try catch
        //La estructura try catch puede agregar un finally al final que siempre se ejecuta 
        //independientemewnte si pasa el try o cae en catch
            
        double result = 0;
            
        try{//Hereda de Exception, requiere try-catch
            //Puede arrojar una o mas exceptions
            result = divisionException(10, 0);
        }catch(OperacionException e){//Se pueden procesar mas de un catch en un mismo try
            //Se recomienda procesar primero las exceptions de menor jerarquia
            System.out.println("Ocurrio un error de tipo " + e.getClass().getSimpleName());//operacionException class
            e.printStackTrace(System.out);
        }catch(Exception e){
            System.out.println("Ocurrio un error de tipo " + e.getClass().getSimpleName());//Exception class
            e.printStackTrace(System.out);
        }finally{
            //Se usa mas para cerrar recursos como conexiones o archivos
            System.out.println("Ejecutando bloque finally");
        }
        
        System.out.println("result = " + result);
    }
}
