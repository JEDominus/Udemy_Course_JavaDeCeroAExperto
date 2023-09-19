package laboratorio;

public class Caja {
    int ancho;
    int alto;
    int profundo;
    
    public Caja(){
        System.out.println("Ejecutando constructor vacio");
    }
    
    public Caja(int ancho, int alto, int profundo){
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
        System.out.println("Ejecutando constructor parametrizado");
    }
    
    public int calcularVolumen(){
        return this.alto * this.ancho * this.profundo;
    }
}
