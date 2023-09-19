package test;

import domain.Persona;

public class TestForEach {
    public static void main(String[] args) {
        //forEachFundamentos();
        forEachConObjetos();
    }
    
    public static void forEachFundamentos(){
        //Es un ciclo for mejorado
        //Simplifica la forma de recorrer arreglos y colecciones )Arrays, List, Maps)
        int edades[] = {5,6,7,8,9};//Instanciar array simplificado
        
        //ya no sera necesario definir la variable contador 
            //En lugar de, se define una variable que almacena los valores del arreglo y debe ser del mismo tipo
        for(int edad: edades){//Primero el elemento unidad y despues de los : el arreglo a iterar
            System.out.println("edad = " + edad);//Se imprime el elemento unidad de cada iteracion
        }
    }
    
    public static void forEachConObjetos(){
        //Arreglo de Personas de forma simplificada
        Persona personas[] = {new Persona("Javier"), new Persona("Natalia"), new Persona("Mario")};
        
        //Con objetos es lo mismo que con tipos primitivos
        for (Persona persona: personas){//Primero la unidad y el tipo de datod el arreglo, despues ela rreglo
            System.out.println(persona.toString());
        }
    }
}
