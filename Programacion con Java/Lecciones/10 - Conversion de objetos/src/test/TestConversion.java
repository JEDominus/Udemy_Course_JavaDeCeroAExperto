package test;

import domain.*;

public class TestConversion {
    public static void main(String[] args) {
        conversionDeObjetos();
    }
    
    public static void conversionDeObjetos(){
            //Convertir referencias al tipo
        //Upcasting   - Conversion de ref a una clase padre mas alta (Object)
        //Downcasting - Conversion de ref a una clase hija mas baja (Correcto)
        
        //creamos una variable de tipo empleado pero creamos el objeto de tipo escritor
        //NOTA: Podemos asignar objetos de las clases hijas a las referencias de tipo clase padre
        Empleado empleado = new Escritor("Javier", 37000, TipoEscritura.CLASICO);//Aqui se llama al constructor del enumerador 
        System.out.println("empleado = " + empleado);//Imprime el toString del padre con super y el atributo Tipo escritura del tipo hijo
        
        //Este print a pesar de ser referencia empleado, el objeto es de tipo Escritor, por eso imprime la escritura 
            //Esto es debido al polimorfismo... Se pueden ejecutar los metodos en comund de ambas clases
            //Pero se va a ejecutar el del tipo que este en memoria heap, en este caso, new Escrito creo de tipo Escritor
        System.out.println(empleado.detalles());//COn ctrl clik nos lleva a la clase padre...
            //A nivel de compilacion, no se puede definir el polimorfismo, solo en runtime ya que consulta el tipo en memoria
            
        //Si definimos un nuevo metodo en la clase escritor
            //El compilador detecta que ese metodo no lo tienen en comun ambas clases, si no que se leeria hasta evr la memoria
            //La memoria se lee en tiempo de ejecucionb y el error lanza a nivel compilador
        //System.out.println(empleado.getTipoEscritura());//ERROR - Metodo no en comun
        
        //Para poder llamarlo tendriamos que realizar una conversion de objetos (casting)
            //Aqui ya se cponfirte la "REFERENCIA" de tipo padre a la tipo hija "Downcasting"
            //Ahora ya se puede acceder a este metodo que no tienen en comun gracias a la conversion
        Escritor escritor = (Escritor)empleado;//EL CASTEO ES SOLO PARA DOWNCASTING
        //Ahora ya podemos acceder al metodo getTipoEscritura
        
        //Al asignar una avriable de tipo hija a tipo padre...
        Empleado empleado2 = escritor;//NO PIDE EL CASTEO POR SER UPCASTING - De hijo a padre
        //Al igual que con primitivos, los tipos de mayor bytes aceptan la conversion a los de menor bytes, pero no al reves sin la conversion explicita
        
        //Ahora se pueden acceder a los metodo en comun solamente por ser upcasting
        System.out.println(empleado2.detalles());
    }
}
