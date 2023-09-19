package cpjlaboratiofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;
import mx.com.gm.peliculas.negocio.ICatalogoPeliculas;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        catalogoPeliculasManager();
    }

    public static void catalogoPeliculasManager() {//Gestiona los flujos del programa dado el input
        int opcion = -1;
        String nombreCatalogo = "";
        String nombrePelicula = "";
        Scanner consola = new Scanner(System.in);//Consola para lectura dele programa
        
        //Bajo acomplamiento - Menor cantidad de relaciones entre clases... Esta no se comunica con datos
        //Alta cohesion - Cada clase se encarga de su funcion y no mas... negocio no hace cosas de datos
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        StringBuilder menu = new StringBuilder()//Instanciamiento del menu
                .append("Elige una opcion:\n")
                .append("  1 = Crear nuevo catalogo de peliculas\n")
                .append("  2 = Agregar pelicula\n")
                .append("  3 = Listar peliculas\n")
                .append("  4 = Buscar pelicula\n")
                .append("  0 = Salir");

        while (opcion != 0) {//Ciclo que maneja el programa hasta que se decide salir con la opcion 0
            System.out.println(menu.toString());//Despliega el menu
            opcion = validarOpcion(consola);//Captura y valida la opcion

            switch (opcion) {//Numeros validos del 0 al 4...
                case 1://Iniciar catologo
                    System.out.println("Ingrese el nombre del nuevo catalogo de peliculas: ");
                    nombreCatalogo = consola.nextLine();//Captura del nombre del catalogo                    
                    catalogo.iniciarArchivo(nombreCatalogo);//business call
                    break;
                case 2://Agregar pelicula
                    System.out.println("¿Que pelicula quieres agregar?");
                    nombrePelicula = consola.nextLine();//Captura del nombre de pelicula 
                    System.out.println("¿A que catalogo quieres añadir '" + nombrePelicula + "'?");
                    nombreCatalogo = consola.nextLine();//Captura del nombre del catalogo
                    catalogo.agregarPelicula(nombrePelicula, nombreCatalogo);//business call
                    break;
                case 3://Listar peliculas
                    System.out.println("¿Que catalogo de peliculas quieres desplegar?: ");
                    nombreCatalogo = consola.nextLine();//Captura del nombre del catalogo
                    catalogo.listarPeliculas(nombreCatalogo);//business call
                    break;
                case 4://Buscar peliculaSystem.out.println("¿Que pelicula quieres agregar?: ");
                    System.out.println("¿Que pelicula estas buscando?");
                    nombrePelicula = consola.nextLine();//Captura del nombre de pelicula 
                    System.out.println("¿En que catalogo esta '" + nombrePelicula + "'?");
                    nombreCatalogo = consola.nextLine();//Captura del nombre del catalogo
                    catalogo.buscarPelicula(nombreCatalogo, nombrePelicula);//business call
                    break;
                case 0://Salir del programa
                    System.out.println("Hasta pronto!\n");
                    break;
                case 5://Error de tipo de dato, string, float o valor fuera de int
                    System.out.println("Su opcion tiene que ser un numero entero entre 0 y 4\n");
                    break;
                default://Tipo de dato valido pero fuera de rango
                    System.out.println("Opcion: " + opcion + " no existe. Ingrese numero entero del 0 al 4\n");
            }
        }
    }

    public static int validarOpcion(Scanner consola) {
        int opcion = 0;//valor a retornar por la funcion

        try {//Validaciones del input
            opcion = Integer.parseInt(consola.nextLine());//Recibe el valor, si no es un numero, cacha la exception-10
        } catch (NumberFormatException ex) {
            opcion = 5;//Codigo de error: 5
        }

        return opcion;//Regresa entre el numero dado, la opcion 5 es error
    }
}
