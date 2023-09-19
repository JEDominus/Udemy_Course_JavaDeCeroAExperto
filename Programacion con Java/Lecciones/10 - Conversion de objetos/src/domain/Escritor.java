package domain;

public class Escritor extends Empleado {
    final TipoEscritura tipoEscritura;
    
    public Escritor(String nombre, double sueldo, TipoEscritura tipo) {
        super(nombre, sueldo);
        this.tipoEscritura = tipo;
    }
    
    //Sobreescribimos el metodo del padre
    @Override
    public String detalles(){
        //Agregamos al metodo de padre el tipo de escritura
        return super.detalles() + ", " + tipoEscritura.getDescription();
    }
    
    public TipoEscritura getEscritura(){
        return this.tipoEscritura;
    }

    @Override
    public String toString() {
        return super.toString() + ", Escritor{" + "tipoEscritura=" + tipoEscritura + "}";
    }
}
