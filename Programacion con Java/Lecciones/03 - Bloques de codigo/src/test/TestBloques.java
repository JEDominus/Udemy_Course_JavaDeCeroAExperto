package test;

import domain.Persona;

public class TestBloques {
    public static void main(String[] args) {
        bloquesDeInicializacion();
    }
    
    public static void bloquesDeInicializacion() {
        //Existen bloques de inicializacion estaticos y no estaticos
            //Estos bloques se ejecutan antes del constructor... Revisar clase Persona
        
        //Al instanciar un objeto de tipo persona...
            //1.- se carga la clase en memoria: contexto estatico
            //2.- se ejecuta bloque dinamico: contexto dinamico
            //3.- ejecutar constructor
        Persona persona = new Persona();//Se imprimen los 3 mensajes, estatico, dinamico, constructor
        System.out.println("persona = " + persona);//imprime el objeto con el Id 1
        //valor incrementado en contexto estatico, asignado en dinamico
        Persona persona2 = new Persona();//Ya no se ejecuta el bloque estatico, se ejecuto con el objeto pasado
        System.out.println("persona2 = " + persona2);//Verificar incremento en otro objeto - imprime el objeto con el Id 3
    }
}
