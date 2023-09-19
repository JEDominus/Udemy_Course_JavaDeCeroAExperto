package exceptions;

//Al cambior de Exception a RuntimeException... Particularmente en esta clase no hay problema
    //Habria que revisar el comportamiento a la hora de lanzarla o cacharla
public class OperacionRuntimeException extends RuntimeException{//No obliga a poner bloque TryCatch o firmarlas en metodo
    public OperacionRuntimeException(String mensaje){
        super(mensaje);
    }
}
