package domain;

public class Empleado {
    protected String nombre;
    protected double sueldo;

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    
    //Este es el metodo que se va a sobreescribir en la clase hgija
    //COmportamiento de clase padre 
    public String detalles(){
        return new StringBuilder().append("Nombre: ").append(this.nombre)
                .append(", Sueldo: ").append(this.sueldo)
                .toString();
    }

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
    
    //To string pendiente ya que usamos detalles()
}
