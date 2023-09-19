package domain;

public class Empleado { //Extends Persona { //Marca error ya que la clase Persona es final... no se puede heredar
    
    //static y final se acostumbran a poner juntas, dado que ya no se modifica el valor, entonces no se re  quiere instancia 
    //Final + static = constante
    //Las constantes se definen en mayuscula y se separa por _ 
    public static final int MI_CONSTANTE = 1;
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public final void imprimir(){
        System.out.println("Imprimiendo desde empelado, metodo final");
    }
    
    
}
