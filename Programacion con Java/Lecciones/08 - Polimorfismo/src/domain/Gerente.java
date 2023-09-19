package domain;

public class Gerente extends Empleado{
    private String departamento;
    
    public Gerente(String nombre, double sueldo, String departamento){
        super(nombre, sueldo);
        this.departamento = departamento;
    }
    
    @Override
    public String detalles(){
        return new StringBuilder().append(super.detalles())
                .append(", Departamento: ").append(this.departamento)
                .toString();
    }
}
