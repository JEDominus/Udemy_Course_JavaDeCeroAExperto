package mx.com.gm.peliculas.excepciones;

//Checked exception ya que hereda de otra checked
public class EscrituraDeDatosException extends AccesoDatosException {

    public EscrituraDeDatosException(String message) {
        super(message);//Llamada a constructor padre AccesoDatosException y pasa el parametro
    }

}
