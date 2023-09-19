package test;

import domain.Empleado;
import operaciones.Operaciones;

public class TestHerencia {
    public static void main(String[] args) {
        //sobrecargaDeConstructores();
        sobrecargaDeMetodos();
    }
    
    public static void sobrecargaDeConstructores(){
        //basicamente es cuando se tien mas de un constructor en una clase con diferentes argumentos
            //Tener diferentes versiones de constructores de una misma clase
        //i.e un solo constructor en clase no aplica sobrecarga de constructores
        //i.e la clase Empleado tiene ams de un constructor, aplica sobrecarga de constructores     
        
        //Se rcea un Empleaqdo que internamente llama a otro constructor de la clase empleado
        Empleado emplaedoConConstructorThis = new Empleado("Javier", 37000);
        System.out.println("emplaedoConConstructorThis = " + emplaedoConConstructorThis);//Se crea con sueldo y Id, 1 llamada a constructor internamente
        //Tambien imprime el nombre que se asigno a el atributo de la clase padre Persona, pero sin usar super, sino this
        
        //El constructor interno setea el id, el atributo se seta en el objeto super y se setea el atributo de empleado
        //Solo se requiere hacer una llamada directa al atributo del padre en el primer constructor
        //este seteo del atributo del padre es gracias a que es de tipo protected
        
        //Empleado(2 args) llama a Empleado() mediante this() (Que es el constructor sobrecargado)
        //Emplaedo() llamada mediante Empleado(2 args), implicitamente llama a super() de la clase Persona()
        //Persona() implicitamente llama a super() Object()... 
    }
    
    private static void sobrecargaDeMetodos(){//usa la clase Operaciones
        //Es algo similar a la sobrecarga de constructores
        //Basicamente es cuandos e tiene un metodo varias veces pero con diferentes argumentos (Operaciones.java)
        //Estos metodos sobrecargados llevan el mismo nombre, solo varia en argumentos
        //El modificador de acceso y el retorno puede variar entre ellos, pero el nombre debe ser el mismo y los argumentos diferentes
        //Si el primer metodo es publico, no se puede ser mas restrictivo, no puedens er private los que siguen
        
        int sumarConInt = Operaciones.sumar(2, 3);//Se manda a llamar el metodo, si se le pasan ints, se ejecuta el de retorno int
        System.out.println("sumarConInt = " + sumarConInt);//Debe imprimir 5 y sumando con ints 
        
        double sumarConDouble = Operaciones.sumar(3.0, 5.0);//Mismo caso, aqui se usa el metodo de tipo double dados los argumentos double
        System.out.println("sumarConDouble = " + sumarConDouble);//imprime sumar con double y el resultado 8.0
        
        //El primer argumento por inferencia de dato es compatible con int y double
        //Sin embargo, el long ya no es compatible con int pero si con double
        var sumarCon = Operaciones.sumar(4, 7L);//Por lo tanto se manda a llamar sumar con doubles
        System.out.println("sumarCon = " + sumarCon);//Imprime el 11 como double dado el L compatible con double
    }
}
