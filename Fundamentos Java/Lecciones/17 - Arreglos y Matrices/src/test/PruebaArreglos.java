package test;

import domain.Persona;

public class PruebaArreglos {
    public static void main(String[] args) {
        //arreglos();
        //modificarElementosDeArreglo();
        //arreglosMasCiclos();
        //arreglosConObjetos();
        syntaxisResumida();
    }
    
    public static void arreglos(){
        //Un arreglo es un conjunto de elementos
            //Existen de tipos primitivos y de tipo Object(i.e. Persona)
        //Cada elemento se almacena en una posicion, comenzando por el indice 0
        //En un arreglo de x elementos (lenght) el ultimo elemnto esta en x-1
        
        //un arreglo en java se define por los corchetes []
            //Cuyos se pueden definir tambien antes de la variable 
            //int[] edades;
        //lo comun es que los [] sean despues de la variable
        int edades[] = new int[3];
        //un arreglo es un objeto en java, por lo tanto requiere instanciarse con new
        //Despues, el tipo de dato del arreglo y entre los corchetes, su tamaño
            //una vez definido su tamaño, este arreglo ya no puede crecer
            
        System.out.println("edades = " + edades);//imprime la referencia, ya que es un objeto en memoria
        //Por default cada posicion tiene 0 dado que es un tipo primitivo
    }
    
    private static void modificarElementosDeArreglo(){
        int edades[] = new int[3];
        
        //Para modificar un elemento del arreglo, hay que escribir el nombre de la variable y el indice del elemento que queremos modificar
        edades[0] = 10;//nuevo valor en el arreglo edades, primera posicion
        System.out.println("edades[0] = " + edades[0]);//Sintaqxys de lectura de valores en arreglos
        edades[1] = 5;
        System.out.println("edades[1] = " + edades[1]);        
        edades[2] = 7;
        System.out.println("edades[2] = " + edades[2]);
        
        //Si queremos acceder a un elem,ento fuera del arreglo...
        //El compilador no marca error, pues es error de nivel tiempo de ejecucion (runtime), no de compilacion (before runtime)
        //edades[3] = 15; //Falla hasta que se ejecuta la aplicacion
    }
    
    private static void arreglosMasCiclos(){
        int edades[] = new int[3];//Definimos un arreglo de longitud 3
        int valorPosicion = 0;//este valor se incrementa con cada vuelta y se asigna a la posicion del arreglo
        
        //Iniciamos un ciclo de limite = elementos del aareglo - 1
        for(int i = 0; i < edades.length; i++){//Si usa <=, saltara a un elemento mas del tamaño real = error
            edades[i] = valorPosicion += 2;//La posicion del arreglo contendra el valor sumatorio de la vuelta
            
            //StringBuilder Practice
            StringBuilder sb = new StringBuilder();
            sb.append("Edades elemento: ").append(i);//variable del indice de la vuelta del ciclo
            sb.append(": ").append(edades[i]);//Imprime el valor de la posicion del numero de la vuelta
            
            System.out.println(sb.toString());
        }
    }
    
    private static void arreglosConObjetos(){
        //Es comun que el nombre de los arreglos se defina en plural
        //Se instancia el arreglo de forma igual
        Persona[] personas = new Persona[2];
        
        personas[0] = new Persona("Javier");
        System.out.println("personas[0] = " + personas[0]);
        
        personas[1] = new Persona("Natalia");
        System.out.println("personas[1] = " + personas[1]);
        
        //iterar objetos
        for(int i = 0; i < personas.length; i++){
            System.out.println("persona ciclo " + i + ": " + personas[1]);
        }
       
    }
    
    public static void syntaxisResumida(){
        //Con sintaxys resumida, se puede crear un arreglo con valores de una vez
        String frutas[] = {"Manzana", "Naranja", "Uva", "Melon", "Papaya", "Kiwi"};//Se crea un arreglo con 3 valores iniciales
        //El tamaño queda con 3 y cada uno con un valors... EN lugar d eusa [] se usa {}
        
        //iteramos el arreglo de sintaxis resumida
        for(int i = 0; i < frutas.length; i++){
            System.out.println("fruta ciclo " + i + ": " + frutas[i]);
        }
    }
}
