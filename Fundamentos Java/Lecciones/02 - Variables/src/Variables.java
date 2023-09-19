import java.util.Scanner;


public class Variables {

    public static void main(String[] args) {
        //variablesPrimitivas();
        //variablesReferenciadas();
        //inferenciaDeTipoDeDatos();
        //valoresPermitidosAlNombrarVariables();
        //concatenacionDeCadenas();
        //caracteresEspeciales();
        claseScanner();
    }

    private static void variablesPrimitivas() {
        // Variable primitiva de tipo entero
        System.out.println("Imprimiendo variables enteras");
        int myIntVar = 10;
        System.out.println(myIntVar); // Debe imprimir el valor 10        
        myIntVar = 5; // El valor cambio de 10 a 5
        System.out.println(myIntVar); // Debe imprimir el valor de 5
    }

    private static void variablesReferenciadas() {
        // Variable referenciada de Java tipo cadena
        System.out.println("Imprimiendo variables de cadenas");
        String myStringVar = "Saludos";
        System.out.println(myStringVar);
        myStringVar = "Adios";
        System.out.println(myStringVar);
    }

    private static void inferenciaDeTipoDeDatos() {
        // Inferencia de tipo de dato en Java - var
        System.out.println("Imprimiendo variables inferidas");
        var myIntVar2 = 20; // A partir de java 10, var infiere el tipo de dato 
        System.out.println(myIntVar2);

        var myStringVar2 = "Un string inferida";
        System.out.println("myStringVar2 = " + myStringVar2); // soutv+tab
    }

    private static void valoresPermitidosAlNombrarVariables() {
        // Valores permitidos al nombrar variables
        var myVar = 1; // solo nombre
        var _myVar = 1; // guion bajo
        var $myVar = 1; // simbolo de dolar 
        System.out.println(myVar + _myVar + $myVar);
    }

    private static void concatenacionDeCadenas() {
        // Concatenacion de cadenas 
        var usuario = "Javier";
        var titulo = "Ingeniero";
        var union = titulo + " " + usuario;
        System.out.println("union = " + union);

        var i = 3;
        var j = 4;
        System.out.println(i + j); // Suma los numeros
        System.out.println(i + j + union); // Suma numeros y concatena
        System.out.println(usuario + i + j); // Concatena sin sumar dado el contexto cadena (hay uns tring primero)
        System.out.println(usuario + (i + j)); // Concatena y suma dada la prioridad de parentesis 
    }

    private static void caracteresEspeciales() {
        // Caracteres especiales
        var nombre = "Javier";
        System.out.println("Nueva linea: \n" + nombre); // Nueva linea
        System.out.println("Tabulador: \t" + nombre); // Agrega Tabulador
        System.out.println("Retroceso: \b\b" + nombre); // Retrocede 1 caracter, puede reemplazar
        System.out.println("Comilla simple: \'" + nombre + "\'"); // Poner comillas simples
        System.out.println("Comilla simple: '" + nombre + "'"); // Poner comillas simples alternativa
        System.out.println("Comilla doble: \"" + nombre + "\""); // Poner comillas dobles
    }
    
    private static void claseScanner() {
        System.out.println("Escriba su nombre:");
        Scanner consola = new Scanner(System.in); // .in trae el input de la consola gracias a System
        var usuario = consola.nextLine();// Lee la linea completa de la consola, se detiene hasta que el usuario escriba, luego se asigna  
        System.out.println("usuario = " + usuario);
        System.out.println("Escribe tu titulo:");
        var titulo = consola.nextLine(); // consola.nextLines se usa para pedir informacion cada vez que se requiera
        System.out.println(titulo + " " + usuario);
        
        tareaScanner();
    }
    
    private static void tareaScanner() {
        Scanner consola = new Scanner(System.in);
        System.out.println("Proporciona el titulo");
        var titulo = consola.nextLine();
        System.out.println("Proporciona el autor");
        var autor = consola.nextLine();
        System.out.println(titulo + " fue escrito por " + autor);
    }

}
