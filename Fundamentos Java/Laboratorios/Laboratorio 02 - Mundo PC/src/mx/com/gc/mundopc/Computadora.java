package mx.com.gc.mundopc;

public class Computadora {
    private final int idComputadora;
    private String nombre;
    private Monitor monitor;
    private Teclado teclado;
    private Raton raton;
    private static int contadorComputadora;
    
    private Computadora(){
        this.idComputadora = ++Computadora.contadorComputadora;
    }
    
    //Sobrecarga de constructores
    public Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton){
        this();
        this.nombre = nombre;
        this.monitor = monitor;
        this.teclado = teclado;
        this.raton = raton;
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Teclado getTeclado() {
        return this.teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }

    public Raton getRaton() {
        return this.raton;
    }

    public void setRaton(Raton raton) {
        this.raton = raton;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Computadora{");
        sb.append("idComputadora=").append(this.idComputadora);
        sb.append(", nombre=").append(this.nombre);
        sb.append(", monitor=").append(this.monitor);
        sb.append(", teclado=").append(this.teclado);
        sb.append(", raton=").append(this.raton);
        sb.append('}');
        return sb.toString();
    }
}
