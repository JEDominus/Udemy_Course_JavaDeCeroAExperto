package mx.com.gm.peliculas.domain;

public class Pelicula {

    //Encapsulamiento parte 1
    private String nombre;

    //Sobrecarga de constructor - mas de 1 constructor de clase
    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    //Encapsulamiento parte 2
    public String getNombre() {
        return this.nombre;
    }

    //Encapsulamiento parte 2
    public String setNombre(String nombre) {
        return this.nombre = nombre;
    }

    //Sobreescritura de metodo heredado de Object
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula{");
        sb.append("nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }

}
