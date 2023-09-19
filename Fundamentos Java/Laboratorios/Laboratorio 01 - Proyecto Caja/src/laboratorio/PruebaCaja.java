package laboratorio;

public class PruebaCaja {
    public static void main(String[] args) {
        Caja caja1 = new Caja();
        caja1.ancho = 3;
        caja1.alto = 2;
        caja1.profundo = 6;
        int volumen = caja1.calcularVolumen();
        System.out.println("volumen caja 1 = " + volumen);
        
        Caja caja2 = new Caja(3, 2, 6);
        volumen = caja2.calcularVolumen();
        System.out.println("volumen caja 2 = " + volumen);
    }
}
