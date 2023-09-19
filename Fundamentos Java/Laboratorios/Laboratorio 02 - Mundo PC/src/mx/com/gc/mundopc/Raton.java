package mx.com.gc.mundopc;

public class Raton extends DispositivoEntrada {
    private final int idRaton;//Final para hacerlo inmutable
    private static int contadorRatones;
    
    public Raton(String tipoEntrada, String marca){
        super(tipoEntrada, marca);
        this.idRaton = ++Raton.contadorRatones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Raton{");
        sb.append("idRaton=").append(this.idRaton);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
}
