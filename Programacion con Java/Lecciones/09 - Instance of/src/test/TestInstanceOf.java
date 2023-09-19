package test;

import domain.Empleado;
import domain.Gerente;

public class TestInstanceOf {
    public static void main(String[] args) {
        instanceOfJava();
    }
    
    public static void instanceOfJava(){
        Empleado empleado = new Empleado("Javier", 37000);        
        Gerente gerente = new Gerente("Javier", 37000, "IT");
        
        determinarTipo(gerente);
        //determinarTipo(empleado);
        
    }
    
    public static void determinarTipo(Empleado empleado){
        //El uso de la palabra instance of, es para poder determinjar rel itpo de objeto en tiempo de ejecucion
        //Permite rpeguntar de que tipo es la referencia ala que apunta cierta variable
            //normalmente se usa para preguntar en sentencias de control
        //Se comienza pregunta desde la clase hija mas lejana a la padre y asi consecutivamente 
        if(empleado instanceof Gerente){
            System.out.println("Objeto de tipo Gerente");
        }else if(empleado instanceof Empleado){
            System.out.println("Objeto de tipo Empleado");
        }else if (empleado instanceof Object){
            System.out.println("Objeto de tipo Object");//Objeto menos especifico
        }
        
        //Si fueran solo ifs y no else ifs, en el caso de Gerente, seria verdadero para cada validacion
            //Ya que es de tipo gerente, tambien de tipo Empleado y  ala vez de tipo Object
            
        //Tambien se puede utilizar instaceof para convertir objetos
            //Por ejemplo, si queremos acceder al departamento desde un objeto Empleado (No accesible)
        if(empleado instanceof Gerente){
            //Observamos que hace un casto al tipo de dato que SI tiene ese atributo
            ((Gerente) empleado).getDepartamento();
            //De esta forma genera un error --- empleado.getDepartamento()
                //Para ello debemos convertir el tipo ¿empleado a gerente y hay 2 formas 
            
            //1.- crear variable local de tipo hijo y asignarla del argumento haciendo el casteo
            Gerente conversion1 = (Gerente) empleado;
                //ahora ya podemos acceder al departamento
            System.out.println("Gerente de" + conversion1.getDepartamento());
            //Se usa instance of para saber si pdoemos hacer este casteo o no
        }else if(empleado instanceof Empleado){
            //En este caso, el compilador no marca ningun problema...
                //Pero en tiempo de ejecucion, esto falla ya que no se puede convertir una clase padre a una hija
                //Esto porque ya validamos que la instancia no es de tipo gerente
            Gerente conversionErronea = (Gerente) empleado;
        }
         
        
    }
}
