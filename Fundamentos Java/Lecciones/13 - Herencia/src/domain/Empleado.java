package domain;

//EXTENDS señala que hereda el contenido NO PRIVADO de la clase persona
//Solo existe herencia simple... Solo puede heredar de una clase a la vez
public class Empleado extends Persona{//... ectends Object - Ya no aplica
    //Debido a que esta clase no tendra subclases... Se usa PRIVATE en lugar de PROTECTED
    private int idEmpleado;
    private double sueldo;
    private static int contadorEmpleado;

    //------------------------------------------------------------------------
        //Sobrecarga de constructores
    //Este copnstructor solo inciializa el idEmpleado y es llamado dentro de otrso constructores
    public Empleado() {
        this.idEmpleado = ++Empleado.contadorEmpleado;
    }
    
    //Este constructor llama a otro internamente para setear el idEmpleado
    public Empleado(double sueldo){
        //En lugar de super, con this llamamos a un constructor de esta clase
        this();//De igual manera, llama al constructor sin argumentos que es el que esta arriba
        //no se puede usar super y this al mismo tiempo
        this.sueldo = sueldo;
    }
    
    //Para setear atributos de super y usar this al mismo tiempo, se llama a los atributos del padre directamente
    public Empleado(double sueldo, String direccion){
        this();
        this.direccion = direccion;//Este atributo del padre es accesible gracias a que es protected
        this.sueldo = sueldo;
    }
    
    //------------------------------------------------------------------------
    
    //Insert - constructor - Depsliega los constructores del padre y del hijo disponibles
    //Este es un constructor de la clase padre con todos los argumentos
    public Empleado(String nombre, char genero, int edad, String direccion) { //El constructor es de tipo clase hijo
        //Supper llama al constructor de la clase padre, quienrecibe los argumentos del hijo
        //Si se requiere el constructor vacio del padre, nomas se pone super() sin argumentos
        super(nombre, genero, edad, direccion);//Super hace referencia al construcvtor padre
    }

    //Este es un constructor hibrido, con atributos del padre y del hijo
    public Empleado(String nombre, double sueldo) {//Nombre de la clase padre... Sueldo de la clase Empleado
        super(nombre);//Atributo de la clase padre
        this.idEmpleado = ++Empleado.contadorEmpleado;//Se asigna el ID de empleado con preincremento, +1 antes de asignar
        this.sueldo = sueldo;//Se asigna el suelo pasado por argumento
    }
    
    //Con los atributos de la clase Persona en PROTEC TED, pdoemos generar getters y setters de la clase PERSONA
    //Si los atributos de PERSONA fueran privados, no se generarian getters y setters
    
    public int getIdEmpleado() {
        return this.idEmpleado;
    }
    
    //Se elimina el setIdEmpleado ya que se asigna automaticamente

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override//Sobreescribe el toString de la clase PERSONA
    public String toString() {
        //String builder, clase de java, omite la concatenacion directa
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");//sb.append - concatena el conteido al igual que el +
        sb.append("idEmpleado=").append(this.idEmpleado);
        sb.append(", sueldo=").append(this.sueldo);
        sb.append(", Persona=").append(super.toString());//Se puede acceder a los atributos y metodosdel padre con super
        //Se manda a llamar el metodo de la clase padre completo
        sb.append('}');
        return sb.toString();//Al final regresa el string con el mismo toString
        //Esta es mas rapida ya que por cada + en la otra se crea un objeto de tipo string.
        //Los objetos de tipo string son inmutables, no se pueden cambiar una vez creados
        //sb.append es mas eficiente creando menos strings 
        
        //This accede al objeto actual y los atributos protected del padre
        //Super accede a toda la clase padre
    }
    
    
    
}
