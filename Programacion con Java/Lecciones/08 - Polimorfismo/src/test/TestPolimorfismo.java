package test;

import domain.*;

public class TestPolimorfismo {
    public static void main(String[] args) {
        /*
        - El polimorfismo es la capacidad que tiene una clase de responder satisfactoriamente a la llamada de un metodo
        con objetos de diferente tipo mientras dicha llamada sea compatible con la respuesta... 
        
        - El polimorfismo es la capacidad de gestionar multiples comportamientos en metodos para diferentes
        tipos de objetos siempre y cuando estos sean compatibles con el mismo
        
        Un metodo puede servir para imprimir la informacion de clases diferentes (que tiene relaciond e herencia) 
        */
        polimorfismo();
    }
    
    public static void polimorfismo(){//polimorfismo... "Multiples comportamientos"
        //Requiere herencia y sobreescritura de metodo de la clase padre
        //el polimorfismo se aprecia mejor en tiempo de ejecucion
        
        //creamos un objeto de la clase padre y llamamos a su metodo con el comportamiento original 
        Empleado empleado = new Empleado("Javier", 37000);
            //System.out.println(empleado.detalles());
        //No accede a departamento ya que es un atributo de la clase hija 
        
        //Se define una variable gerente y se llama a su metodo sobreescrito
        Gerente gerente = new Gerente("Natalia", 25000, "QA");
            //System.out.println(gerente.detalles());
        //hasta aqui no existe nada neuvo --------------------------------------
        
        //Se va a escribir un metodo que mande a llamar "detalles()" peeero...
            //Dependera del objeto que se le pase para saber si se ejecuta de la clase padre o de la clase hija
        //Se llama el metodo que recibe la forma mas basica de la clase, pasando el tipo apdre
        imprimirConPolimorfismo(empleado);//imprime correctamente 2 de los valores como su clase lo define
        
        //Ahora tambiens e puede llamar el mismo metodo con la clase gerente dado que son clases compatoibles con el metodo detalles
        imprimirConPolimorfismo(gerente);
        
        //Podemos ver en ambas implesiones que tambien se agrega el nombre de la clase, y cambia segun el objeto dado
    }
    
    //Se recibe el tipo de la clase padre
        //Se le conocen como tipos compatibles
    public static void imprimirConPolimorfismo(Empleado empleado){
        //Para poder usar la referencia de clase padre e hija, se debe usar el tipo mas generico, el PADRE
        //Este EMPLEADO que se recibe tambien podra comportarse como un GERENTE... ahi aplica el polimorfismo
            //Dado que ambas clases con compatibles con el metodo detalles
        System.out.println("----- Imprimiendo desde metodo polimorfo -----");
        System.out.println(empleado.getClass() + " --- " +empleado.detalles());
        
        //el la referencia recibida ena rgumetno es compatible con el tipo de clase que maneja el metodo...
            //Entonces puede ejecutarlo sin problemas mientras sean compatoibes
        
    }
}
