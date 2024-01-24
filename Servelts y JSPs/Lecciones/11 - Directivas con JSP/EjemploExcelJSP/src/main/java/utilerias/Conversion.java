package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

//Esta clase se va a utilizar directamente desde el JSP
//Se va a encargar de recibir una fecha y convertirla a string usando un formateador y una constante definida
public class Conversion {
    public static final String FORMATO_FECHA = "dd-MM";
    
    public static String format(Date fecha){
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
}
