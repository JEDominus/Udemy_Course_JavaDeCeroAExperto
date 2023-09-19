package test;

import domain.Empleado;

public class PruebPalabra {
    public static void main(String[] args) {
        palbraFinalEnvariablesClasesMetodos();
        palabraFinalEnObjetos();
    }
    
    public static void palbraFinalEnvariablesClasesMetodos(){
        //El uso de la palabra final se puede aplicar a clases, metodos y variables... Tambien conocida como constantes
            //El uso en clases es para que no se puedan crear subclases
            //el uso en metodos es para que las clases hijas no puedan sobreescribir ese metodo
            //El uso en variables es para que su valor no cambie
        //En conjunto con static, ahora no solo es inmutable, si no que tambien se puede acceder desde la clase
            //Por ejemplo la clase Math... todo es static final, como Math.PI
            
        //Una vez que se le asigna el valor a un final, ya no se puede modificar
        final int myVariable = 10;
        System.out.println("myVariable = " + myVariable);
        //myVariable = 5; //Error, nose puede modificar el valor
        
        Empleado empleado1 = new Empleado();
        empleado1.imprimir();//Imporime mediante la clase padre Empleado, el metodo final imprimir
        
        System.out.println("Mi_constante = " + Empleado.MI_CONSTANTE);//Imprime la constante final + static de Empleado
        //Empleado.MI_CONSTANTE = 0; //Marca error dado que es final y no se puede modificar
    }
    
    public static void palabraFinalEnObjetos(){
        final Empleado empleado1 = new Empleado();//se crea objeto con variable nombre pero sin valor
        //empelado1 = new Empleado();//Marca error ya que empleado1 es final, no se puede reasignar valor
        empleado1.setNombre("Javier");//Aun asi, si se puede modificar el contenido del objeto
        System.out.println("empleado1.getNombre(); = " + empleado1.getNombre());
        empleado1.setNombre("Natalia");
        System.out.println("empleado1.getNombre(); = " + empleado1.getNombre());
        //Se puede moficiar el contenido del objeto, mas no el objeto en si por se final
        //Si los atributos del objeto fueran final, tampoco sre deberian de poner cambair 
    }
}
