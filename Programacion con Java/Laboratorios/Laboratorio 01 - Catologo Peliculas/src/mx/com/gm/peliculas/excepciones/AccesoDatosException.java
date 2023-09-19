package mx.com.gm.peliculas.excepciones;

//Hereda de cheked exception... Hay que firmar o cachar en try-catch
public class AccesoDatosException extends Exception {

    public AccesoDatosException(String message) {
        super(message);//Llamada a constructor padre Exception y pasa el parametro
    }

}
