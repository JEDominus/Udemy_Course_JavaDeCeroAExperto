package domain;


//Cuando solos e tiene un constructor no aplica la sobrecarga de constructor
public class Empleado extends Persona{
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;
    
    //Constructor sobrecargado
    //Constructor vacio que emplea el incremento del ID del empleado
    public Empleado(){//Se puede suar dentro de otros constructores de esta misma clase
        //super();//De nuevacuenta aqui se llama al cosntrucotr super de la clase Persona
        this.idEmpleado = ++Empleado.contadorEmpleado;  
    }

    public Empleado(String nombre, double sueldo) {
        //super(nombre);//Solo se puede utilizar super o this, pero no ambos
        //De esta forma se llama a un constructor de esta misma clase...Setea el Id
        this();//Al igual que super, se llama al constructor en este caso sin argummentos, que es el que esta arriba
        //Dado que ahora ya no podemos inicializar el constructor padre con super (Dado this())
        this.nombre = nombre; //Podemos llamar directamente al atributo protected de la clase padre
        this.sueldo = sueldo;
    }
    
    public int getIdEmpleado() {
        return this.idEmpleado;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado=").append(this.idEmpleado);
        sb.append(", sueldo=").append(this.sueldo);
        sb.append(", Persona=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
