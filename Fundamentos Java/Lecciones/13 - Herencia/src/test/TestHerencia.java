package test;

import domain.Cliente;
import domain.Empleado;

public class TestHerencia {
    public static void main(String[] args) {
        //ejercicioHerencia();
        //herenciaContructorHibrido();
        //herenciaCliente();
        sobrecargaDeConstructores();
    }
    
    public static void ejercicioHerencia(){
        //Los constructores de las clases padre se puede acceder emdiante SUPER()
        //El constructor a escoger depende de sus argumentos
        Empleado empleado1 = new Empleado();//creamos la clase empleado (Clase vacia pero heredando)
        System.out.println("empleado1 = " + empleado1);//Imprime el tostring de persona, de quien hereda
        //La impreasion amrca que es de tipo persona, dado que de ahi se toma el ToString
    }
    
    public static void herenciaContructorHibrido(){
        Empleado empleado1 = new Empleado("JAVIER", 37000);
        System.out.println("empleado1 = " + empleado1);//Imprime la info del Empleado creado + la de Persona
    }
    
    public static void herenciaCliente(){
        Cliente cliente1 = new Cliente("JAVIER", true);
        System.out.println("cliente1 = " + cliente1);
        Cliente cliente2 = new Cliente("ENELIDA", true);
        System.out.println("cliente2 = " + cliente2);
        
        Cliente cliente3 = new Cliente();//Aunque sea un constructo vacio, se setea el ID y la fecha automaticamente
        System.out.println("cliente3 = " + cliente3);
        
        Cliente clienteFull = new Cliente(true, "JAVIER", 'H', 25, "MEXCALLI");
        System.out.println("clienteFull = " + clienteFull);
    }
    
    public static void sobrecargaDeConstructores(){
        //basicamente es cuando se tien mas de un constructor en una clase con diferentes argumentos
            //Tener diferentes versiones de constructores de una misma clase
        //i.e un solo constructor en clase no aplica sobrecarga de constructores
        //i.e la clase Empleado tiene ams de un constructor, aplica sobrecarga de constructores     
        
        //Se rcea un Empleaqdo que internamente llama a otro constructor de la clase empleado
        Empleado empleado1 = new Empleado(37000);
        System.out.println("empleado1 = " + empleado1);//Se observa que se crea con sueldo y Id, 1 llamada a constructor internamente
        
        //ahora se construye un empleado seteando valores del super y a la vez llamando al constructor interno de empleado
        Empleado empleado2 = new Empleado(37000, "Mexcalli 278");
        //El constructor interno setea el id, el atributo se seta en el objeto super y se setea el atributo de empleado
        System.out.println("empleado2 = " + empleado2);//Solo se requiere hacer una llamada directa al atributo del padre en el primer constructor
        //este seteo del atributo del padre es gracias a que es de tipo protected
    }
}
