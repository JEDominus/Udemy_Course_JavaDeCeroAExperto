package test;

import dominio.*;//Esto no carga todas las clases en memoria, si no solo las utilizadas

public class PruebPersona {
    public static void main(String[] args) {
        //encapsulamiento();
        metodoToString();
    }
    
    public static void encapsulamiento(){
        Persona persona1 = new Persona("Javier", 37000, false);        
        System.out.println("Persona 1 nombre: " + persona1.getNombre());
        //Ahora podemos acceder a los campos
        //persona1.nombre = "Emmanuel"; //Ya no se puede acceder de esta forma dado nque es private
        persona1.setNombre("Emmanuel");//Se setea un nuevo valor 
        System.out.println("Persona 1 nombre (cambio): " + persona1.getNombre()); 
        System.out.println("Persona 1 sueldo: " + persona1.getSueldo());
        System.out.println("Persona 1 eliminado: " + persona1.isEliminado());
        
        //Practica
        Persona persona2 = new Persona("Enelida", 25000, true);
        System.out.println("Persona 2 nombre() = " + persona2.getNombre());
        System.out.println("Persona 2 sueldo() = " + persona2.getSueldo());
        System.out.println("Persona 2 eliminado() = " + persona2.isEliminado());
    }
    
    public static void metodoToString(){        
        Persona persona1 = new Persona("Javier", 37000, false);  
        System.out.println("persona1 = " + persona1.toString());//Metodo que imprime la informaciond el estado actual
        
        persona1.setNombre("Emmanuel");
        //Si nos encontramos dentro del metodo system.println, y la clase persona tiene definido el metodo toString...
        System.out.println("persona1 = " + persona1);//No se requiere llamar explicitamente, solo con el objeto es suficiente
    }
}
