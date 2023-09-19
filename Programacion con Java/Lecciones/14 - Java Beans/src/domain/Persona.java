package domain;

import java.io.Serializable;
import java.util.Objects;

//Tambien se acostumbra a nombrar con "...Bean" al final, pero no es necesario
public class Persona implements Serializable{//1.- Implementar serializable
    //2.- Hacer atributos privados
    private String nombre;
    private String apellido;
    
    //3.- Constructor vacio publico
        //Dado que otras aplicaciones como Java Empresarial necesitaran crear este objeto sin saber los atributos
        //Se requiere del constructor vacio
    public Persona(){}
    
    //**.- Opcionalemnte se puede tener mas constructortes
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }    
    
    //4.- getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    //**.- toString, equals y HashCode son opcionales
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.apellido);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.apellido, other.apellido);
    }
    
    //Ahora ya tenemos el java bean!
}
