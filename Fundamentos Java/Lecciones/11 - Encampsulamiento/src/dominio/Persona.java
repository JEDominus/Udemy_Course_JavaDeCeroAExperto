package dominio;

public class Persona {
    private String nombre;
    private double sueldo;
    private boolean eliminado;
    
    public Persona(String nombre, double sueldo, boolean eliminado){
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.eliminado = eliminado;
    }

    //Click / inset code / Getters y Setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    //El getter de tipo boolean es "is" en lugar de "set"
    public boolean isEliminado() {
        return this.eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
    //El metodo toString nos permitira imprimir el estado del objeto   
        //Convierte en cadena cada atributo de nuestro objeto
    public String toString(){
        return "Persona [nombre: " + this.nombre + "]"
                + ", [sueldo: " + this.sueldo + "]"
                + ", [eliminado: " + this.eliminado + "]";
    }
}
