package mx.com.gm.peliculas.negocio;

public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "peliculas.txt";

    //public accessor redundante ya que todo en una interfaz es constante (estatico + publico + final)    
    void iniciarArchivo(String nombreArchivo);

    void agregarPelicula(String nombrePelicula, String nombreArchivo);

    void listarPeliculas(String nombreArchivo);

    void buscarPelicula(String nombreArchivo, String buscar);

}
