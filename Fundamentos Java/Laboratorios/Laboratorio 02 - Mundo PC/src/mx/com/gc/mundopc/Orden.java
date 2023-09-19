package mx.com.gc.mundopc;

public class Orden {
    private final int idOrden;
    private Computadora[] computadoras;
    private int contadorComputadoras;
    private static int contadorOrdenes;
    public static final int MAX_COMPUTADORAS = 10;
    
    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }
    
    public void agregarComputadora(Computadora computadora){
        if(this.contadorComputadoras < Orden.MAX_COMPUTADORAS){
            //Contador aumenta hasta la siguente adicion dado el postincremento, hasta la siguiente lectura
            this.computadoras[this.contadorComputadoras++] = computadora;
        }else{
            System.out.println("Esta orden no puede recibir mas computadoras");
        }
    }
    
    public void mostrarOrden(){
        System.out.println("Orden #: " + this.idOrden);
        System.out.println("Computadoras de la orden #: " + this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) {
            System.out.println(this.computadoras[i]);//Imprime toString automaticamente
        }
    }
}
