package test;

import domain.Empleado;
import domain.Gerente;

public class TestSobreescrutaDeMetodos {
    public static void main(String[] args) {
        sobreescrituraDeMetodos();
    }
    
    public static void sobreescrituraDeMetodos(){
        //Aplica en herencia
        //Es cuando una clase hija modifica el comportamiento de un metodo de la clase padre
       
        //al llamar a la clase apdre, el emtodo se ejecuta con su primera implementacion, mostrando solo el nombre y el sueldo 
        Empleado empleado = new Empleado("Javier", 37000);
        System.out.println(empleado.detalles());
        //con control clikl, nos lleva a la clase padre
        
        //mientras no se sobreescriba el metodo, el siguiente objeto no va a imprimir eld epartamento
        Gerente gerente = new Gerente("Javier", 37000, "IT");
        //Como el metodo ya se sobreescribio, ahora ya tomara el comportamiento modificado en la clase hija
        System.out.println(gerente.detalles());//Se uso la palabra super para tomar el comportamiento padre y agregar en el comportamiento hijo
        //Con control click, nos lleva al metodo sobreescrito de la clase hija
    }
}
