package mx.com.gm.ventas.test;

import mx.com.gm.ventas.Orden;
import mx.com.gm.ventas.Producto;

public class VentasTest {
    public static void main(String[] args) {
        pruebas();
        //ordenCompleta();
        //ordenSobrecargada();
    }
    
    public static void pruebas(){//PASSED
        Orden orden = new Orden();//Crear orden
        
        Producto producto1 = new Producto("verdura", 150);//crear producto
        Producto producto2 = new Producto("fruta", 320);
        Producto producto3 = new Producto("carne", 430);
        
        orden.agregarProducto(producto1);//Agregar producto a la orden
        orden.agregarProducto(producto2);
        orden.agregarProducto(producto3);
        
        //calcular total va implicito en la siguiente linea
        orden.mostrarOrden();//ver toda la orden        
    }
    
    public static void ordenCompleta(){//PASSED  
        Orden orden = new Orden();//crear orden
        
        for (int i = 0; i < 10; i++){//repetir 10 veces...
            Producto producto1 = new Producto("verdura", 150);//crear producto nuevo
            orden.agregarProducto(producto1);//Agregarlo a la orden
        }
        
        orden.mostrarOrden();//ver 10 productos con diferente ID
    }
    
    public static void ordenSobrecargada(){//PASSED   
        Orden orden = new Orden();//crear orden
        
        for (int i = 0; i < 50; i++){//repetir 50 veces...            
            Producto producto = new Producto("stuffs", 150);
            orden.agregarProducto(producto);//A partir de la vez 11, no deberia agregar producto
        }
        
        orden.mostrarOrden();//Deberia desplegar 10 productos, no 50
    }
}
