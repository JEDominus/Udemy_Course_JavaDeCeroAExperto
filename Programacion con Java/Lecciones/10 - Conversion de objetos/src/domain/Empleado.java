package domain;

public class Empleado {
    protected String nombre;
    protected double sueldo;
    
    public Empleado(){}

    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    
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

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';
    }
}
