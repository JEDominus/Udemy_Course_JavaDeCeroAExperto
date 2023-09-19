package test;

import java.util.Scanner;
import manejoarchivos.ManejoArchivos;

/*
    El amnejo de archivos requiere varias operaciones
    Fundamentos en ManejoArchivos.java
*/

public class TestManejoArchivos {
    public static void main(String[] args) {
        //crearArchivo();
        //agregarInformacionAlArchivo();//Sobreescribe lo anterior
        //concatenarInformacion();
        lecturaDeArchivos();
    }
    
    public static void crearArchivo(){
        //creacion de archivo mediantellamad a ametodo estatico (Sin instanciar)
        
        //Vamos a pedir el nombre mediante la consola para practicar Scanner
        Scanner consola = new Scanner(System.in);
        System.out.println("Inserta el nombre del archivo para crear:");
        String nombreArchivo = consola.nextLine() + ".txt";//requiere la extension
        //Se puede especificar la ruta del archivo en el nombre que pasamos
            //Tipo String nombreArchivo = "C:\\bla\\bla\\bla\\file.txt" - windows requiere doble diagonal inversa
            //De momento, en las propiedades del archivo (IDE) podemos ver su ruta
        ManejoArchivos.crearArchivo(nombreArchivo);
    }
    
    public static void agregarInformacionAlArchivo(){
        //ahora vamos a escribir informacion en el archivo
        String nombreArchivo = "JE-File.txt";
        String contenido = "Hello World from Java IO";
        
        //Llamamos al metodo estatico
        ManejoArchivos.escribirArchivo(nombreArchivo, contenido);
        //Multiples llamada sobreescriben el contenido
            //Seguramente hay que traer el contenido antes de agregar lo nuevo 
    }
    
    public static void concatenarInformacion(){
        //este metodo ahora mantiene lo anterior ya que usa un FileWritter con append = true
        ManejoArchivos.anexarInformacion("JE-File.txt", "Hello World from Java IO");
            //Siempre agrega con salto de linea
    }
    
    public static void lecturaDeArchivos(){
        //LLamamos al meotdo, en este caso, el archivo si debe de existir
        ManejoArchivos.leerArchivo("JE-File.txt");//Imprime el contenido del archivo linea por linea
    }
}
