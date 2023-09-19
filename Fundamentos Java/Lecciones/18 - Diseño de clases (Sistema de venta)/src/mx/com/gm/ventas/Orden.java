package mx.com.gm.ventas;

public class Orden {
    private int idOrden;
    private Producto productos[];
    private static int contadorOrdenes;
    public static final int MAX_PRODUCTOS = 10;//static + final = constante accesible nivel clase
    
    public Orden(){
        this.idOrden = ++this.contadorOrdenes;//Asignacion de id por preincremento de variable estatica a nivel clase
        this.productos = new Producto[MAX_PRODUCTOS];//Inicializacion de vector de tamaño constante
    }
    
    public void agregarProducto(Producto producto){
        System.out.println("...Agregando producto '" + producto.getNombre() + "' a la orden " + this.idOrden + "...");
        
        boolean aniadido = false;//Indicador de falta de espacio
        String mensaje;//Mensaje a desplegar
        
        //validar disponibilidad e espacio
        for(int i = 0; i < this.productos.length; i++){//Recorrer todo el arreglo de productos
            if(this.productos[i] == null){//Preguntar por posiciones disponibles
                this.productos[i] = producto;//Añadir en posicion disponible
                aniadido = true;//Cambiar el indicador de espacio
                break;//Salir del ciclo
            }            
        }
        
        //establecer mensaje segun lo ocurrido
        mensaje = aniadido ? "Producto '" + producto.getNombre() + "' añadido exitosamente" : "No queda espacio para productos en esta orden";
        System.out.println(new StringBuilder().append(mensaje).append("\n").toString());
    }
    
    public double calcularTotal(){
        System.out.println("...Calculando total...");
        
        double total = 0;//Alamacena el total actual de la orden
        int punteroProducto = 0;//Indica el indice a la hora de recorrer el arreglo de productos
        
        while(punteroProducto < MAX_PRODUCTOS && this.productos[punteroProducto] != null){//mientras haya productos en el arreglo
            total += this.productos[punteroProducto].getPrecio();//Agrega a la sumatoria el precio del producto actual
            punteroProducto++;//Incrementa el contador del indice
        }
        
        System.out.println(new StringBuilder()
                .append("El total de la orden: ").append(this.idOrden)
                .append(" es de: $").append(total).append("\n").toString());
        
        return total;//retorna el total de la orden
    }
    
    public void mostrarOrden(){
        System.out.println("...Mostrando orden actual...");
        
        System.out.println("Numero de orden: " + this.idOrden + "\nProductos:");
        
        for (int i = 0; i < this.productos.length; i++){
           if(this.productos[i] == null){//validando ecistencia de producto para evitar NPE
               break;
           }
           
           String descripcionProducto = new StringBuilder()
                   .append("Id: ").append(this.productos[i].getIdProducto()).append(", ")
                   .append("Nombre: ").append(this.productos[i].getNombre()).append(", ")
                   .append("Precio: ").append(this.productos[i].getPrecio())
                   .toString();           
           
           System.out.println(descripcionProducto);
        }
        
        //Total sout se depliega en calcular total
        this.calcularTotal();
    }
}
