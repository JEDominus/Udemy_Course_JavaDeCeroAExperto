package mx.com.gm.peliculas.negocio;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.datos.IAccesoDatos;
import mx.com.gm.peliculas.excepciones.AccesoDatosException;

//Implementa una interfaz, si no es clase abstracta, debe implementar sus metodos
public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;

    //Bajo acoplamiento y alta cohesion... Udar el tipo de dato de interfaz 
    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    //Implementacion de metodos de intrfaz
    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if (this.datos.existe(nombreArchivo)) {//Si ecxiste,s e recrea el catalogo
                this.datos.borrar(nombreArchivo);
                this.datos.crear(nombreArchivo);
            } else {//Si no, se rcea por primera vez
                this.datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosException ex) {//Se usa el mas generico ya que envuelve  los hijos diferentes de cada metodo
            System.out.println("Error Al inciiar el catolog de pelicuilas");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        //Se instancia la pelicula para poder usarla en ambos flujos de la validacion
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;//Definimos una variable para saber si se va a sobreescribir un archivo o si se va a crear

        try {
            anexar = this.datos.existe(nombreArchivo);//P¨reguntamos si existe el archivo
            this.datos.escribir(pelicula, nombreArchivo, anexar); //Se escribe o crea si noe xiste
        } catch (AccesoDatosException ex) {
            System.out.println("Error de acceso a datos, recurso inexistente");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        List<Pelicula> peliculas;
        try {
            peliculas = this.datos.listar(nombreArchivo); //Llama al listado de peliculas
            System.out.println("\nPeliculas del catalogo '" + nombreArchivo + "':");
            peliculas.forEach(pelicula -> {//Se itera la lista e imprime cada pelicula
                System.out.println("   " + pelicula.getNombre());
            });
        } catch (AccesoDatosException ex) {//Se maneja un nivel ams altod e la jerarquia de herencia para un error mas generico
            //Aqui ya no se propaga la exceptiona la capa de presentacion
            System.out.println("Error de acceso a datos, recurso inexistente");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String nombrePelicula) {
        try {
            System.out.println(this.datos.buscar(nombreArchivo, nombrePelicula));//imprime el resultado de la bsuqueda de pelicula
        } catch (AccesoDatosException ex) {//Se maneja un nivel ams altod e la jerarquia de herencia para un error mas generico
            //Aqui ya no se propaga la exceptiona la capa de presentacion
            System.out.println("Error de acceso a datos, recurso inexistente");
            ex.printStackTrace(System.out);
        }
    }

}
