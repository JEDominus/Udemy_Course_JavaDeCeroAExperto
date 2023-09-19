package domain;

import java.util.Objects;

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
    
    //Al implementar, el IDE suguiere implementar ambos metodos

    //Generar un valor entero unico con los atroibutos de la clase
    //El calculo de este metodo varia de IDE enn IDE
    @Override//Regresa tipo entero
    public int hashCode() {
        int hash = 7;//Numero hash, se utiliza para el calculo interno con los atributos
        hash = 31 * hash + Objects.hashCode(this.nombre);//Hace un calculo con el atributo del objeto para generar int unico
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.sueldo) ^ (Double.doubleToLongBits(this.sueldo) >>> 32));
        return hash;
    }

    //Compara basandose en la referencia this
    @Override//Retorna true o false
    public boolean equals(Object obj) {//Trabaja con el tipo mas generico de java
        if (this == obj) {//Pregunta por la referencia en memoria
            return true;//Ambos objetos son iguales
        }
        if (obj == null) {//En automatico son distintos si no existe
            return false;//Ya que obj es nulo y eso ya es diferente de this
        }
        if (getClass() != obj.getClass()) {//get class tambien esta en clase Object... Pregunta por tipos de clase iguales
            return false;//Si son diferentes, entonces no son equals
        }
        //Una vez validado todo loa nterior, se castea con seguridad el objeto dado al tipo de esta clase
        final Empleado other = (Empleado) obj;
        //Luego empieza a comparar los atributos de la clase con el obj recien creado
        if (Double.doubleToLongBits(this.sueldo) != Double.doubleToLongBits(other.sueldo)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);//Compara contenidos de variables
    }
    
}
