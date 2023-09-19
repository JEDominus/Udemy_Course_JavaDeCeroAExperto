package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosException;
import mx.com.gm.peliculas.excepciones.EscrituraDeDatosException;
import mx.com.gm.peliculas.excepciones.LecturaDeDatosExcepcion;

public interface IAccesoDatos {

    //public accessor redundante ya que todo en una interfaz es constante (estatico + publico + final)
    void crear(String nombreArchivo) throws AccesoDatosException;//Ecepcion de tipo apdre mas generica

    boolean existe(String nombreArchivo) throws AccesoDatosException;

    void escribir(Pelicula pelicula, String nombreArcivo, boolean anexar) throws EscrituraDeDatosException;//Exception mas especifica

    List<Pelicula> listar(String nombre) throws LecturaDeDatosExcepcion;//Exception ams especifica

    String buscar(String nombreArchivo, String buscar) throws LecturaDeDatosExcepcion;

    void borrar(String nombreArchivo) throws AccesoDatosException;
}
