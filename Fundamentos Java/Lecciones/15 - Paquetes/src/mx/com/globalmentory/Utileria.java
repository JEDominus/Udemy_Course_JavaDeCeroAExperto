//El dominio de esta aplicacion seri globalmentory.com.mx
//El nombre de paquete es invertir el orden de las palabras del dominio, por eso empiza con mx
//Esto solo ayuda a diferenciar las aplicaciones, no es que se conecte a internet
//Cada punto en el paquet marca una subcarpeta que se crea en el proyecto
    //i.e. C:/.../15 - Paquetes/src/mx/com/globalmentory
package mx.com.globalmentory;
//Dentro de este paquete es donde se encuentra la clase actual

//Esta clase solo tendra un metodo estatico que imprimira el argumento dado
public class Utileria {
    
    //Metodo estatico para no tener que instanciar
    public static void imprimir(String cadena){
        System.out.println("cadena = " + cadena);
    }
}
