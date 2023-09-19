package domain;

public class Gerente extends Empleado{
    //Atributo extra de clase hija
    private String departamento;
    
    public Gerente(String nombre, double sueldo, String departamento){
        super(nombre, sueldo);
        this.departamento = departamento;
    }
    
    //Para la spobreescritura de metodos se usa la anotacion Override
        //Tambien se debe llamar igual y retornar el mismop tipo de dato
    //Esta anotacion modicia el comportamiento del metodo a continuacion
        //Le indica al compilador que el metodo esta sobreescribiendo de la clase padre
        //A la izquierda se puede ver la o que indica que esta sobreescribiendo
    @Override
    public String detalles(){
        //el uso de super es para trae y usar lo que ya esta implementado en la clase padre sin tener que hacerlo de nuevo
        return new StringBuilder().append(super.detalles())
                .append(", Departamento: ").append(this.departamento)
                .toString();
    }
}
