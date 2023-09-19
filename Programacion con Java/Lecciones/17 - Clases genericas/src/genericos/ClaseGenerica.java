package genericos;

//En esta clase se usara un T para proporcionar el tipo una vez instanciado un objeto
public class ClaseGenerica<T> {//Se agrega la T entre picoparentesis
    //Se requiere definir el tipo egnerico 
    private T objeto;
    
    public ClaseGenerica(T objeto){//El constructor solo requiere la T en el argumento
        this.objeto = objeto;//Se inicializa el objeto del tipo generico en el constructor
    }
    
    public void obtenerTipo(){
        //Se referencia el objeto y la clase con la variable "objeto"
        System.out.println("El tipo T es: " + objeto.getClass().getSimpleName());
    }
}
