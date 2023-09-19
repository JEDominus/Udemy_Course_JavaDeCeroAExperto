package mx.com.gm.ventas;

public class Producto {
    //final dado solo se puede leer una vez establecido
    private final int idProducto;//Id nivel objeto obtenido del contadorProducto estatico
    private String nombre;
    private double precio;
    private static int contadorProductos;//Contador nivel clase que se incrementa con cada objeto
    
    //Privado, accesible desde constructor parametrizado
    private Producto(){
        this.idProducto = ++Producto.contadorProductos;//preincremento de valor antes de ser asignado... LLamart a la clase
    }
    
    //Sobrecarga de constructores... accede al constructor privado
    public Producto(String nombre, double precio){
        this();//Llamada al constructor privado sin argumentos
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {//Encapsulamiento
        return this.idProducto;//sobreescritura this. por buena practica en getters
    }
    
    //setIdProducto no esta permitido, variable final 

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {//To string usando String Builder
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("idProducto=").append(this.idProducto);
        sb.append(", nombre=").append(this.nombre);
        sb.append(", precio=").append(this.precio);
        sb.append('}');
        return sb.toString();
    }
}
