package mundopc;

import mx.com.gc.mundopc.Computadora;
import mx.com.gc.mundopc.Monitor;
import mx.com.gc.mundopc.Orden;
import mx.com.gc.mundopc.Raton;
import mx.com.gc.mundopc.Teclado;

public class MundoPC {
    public static void main(String[] args) {
        //prueba();
        //ordenCompleta();
        ordenSobrecargada();
    }
    
    public static void prueba(){//PASSED
        //crear teclado, raton y moonitor
        Teclado teclado = new Teclado("USB 2.0", "Logitech");
        Raton raton = new Raton("USB 3.0", "Dell");
        Monitor monitor = new Monitor("LG", 25.5);
        
        //crear computadora
        Computadora computadora = new Computadora("HP Pavillion", monitor, teclado, raton);
        
        //crear orden, agregar computadora y mostrar orden
        Orden orden = new Orden();
        orden.agregarComputadora(computadora);
        orden.mostrarOrden();
    }
    
    public static void ordenCompleta(){//PASSED
        //crear orden
        Orden orden = new Orden();
        
        for (int i = 0; i < Orden.MAX_COMPUTADORAS; i++) {
            //crear computadora completa, agregar a la orden
            Teclado teclado = new Teclado("USB 2.0", "Logitech");
            Raton raton = new Raton("USB 3.0", "Dell");
            Monitor monitor = new Monitor("LG", 25.5);
            Computadora computadora = new Computadora("HP Pavillion", monitor, teclado, raton);
            
            orden.agregarComputadora(computadora);
        }
        
        //mostrar orden
        orden.mostrarOrden();//Debe deplegar las 10 computadoras
    }
    
    public static void ordenSobrecargada(){//PASSED
        //crear orden
        Orden orden = new Orden();
        
        for (int i = 0; i < Orden.MAX_COMPUTADORAS+5; i++) {
            //crear computadora completa, agregar a la orden
            Teclado teclado = new Teclado("USB 2.0", "Logitech");
            Raton raton = new Raton("USB 3.0", "Dell");
            Monitor monitor = new Monitor("LG", 25.5);
            Computadora computadora = new Computadora("HP Pavillion", monitor, teclado, raton);
            
            //A partir de la vuelta 15 debe mostrar mensaje de error
            orden.agregarComputadora(computadora);
        }
        
        //mostrar orden
        orden.mostrarOrden();//Debe deplegar las 10 computadoras
    }
}
