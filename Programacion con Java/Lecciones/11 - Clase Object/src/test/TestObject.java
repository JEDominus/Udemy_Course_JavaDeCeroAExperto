package test;

import domain.Empleado;

public class TestObject {
    public static void main(String[] args) {
        claseObject();
    }
    
    public static void claseObject(){
        //Todas las clases en java heredan de la clase Object, que es la clase padre absoluta
        //Esta clase tiene 3 metodos importantes
            //toString() r String - retorna el objeto en tipo cadena
            //equals() r boolean - compara el contenido de 2 objetos para saber si son iguales
            //hashCode r int - tambien compara el contenido de 2 objetos...
                //Esta comparacion se genera un intero que se asigna a cada entero segun lso atroibutos de la clase
                //Se compara ese int unico de cada objeto para saber si son iguales
                    //Si se sobreescribe el hascode, tambien se debe sobreescribir el equals
                    //Ya que hay puede dar conflictos con algoritmos de ordenamiento
        
        //Comenzamos con comparacion de 2 objetos con la misma informacion
        Empleado empleado1 = new Empleado("Javier", 37000);
        Empleado empleado2 = new Empleado("Javier", 37000);
        
        //Los obejtos almacenados retornan referencia en memoria cuando se sua el "new"
        
        //El == compara la referencia en memoria y no el contenido
        if(empleado1 == empleado2){
            System.out.println("Objetos con MISMA referencia en memoria");
        }else{
            //hasta aqui, la condicional entra aqui
            System.out.println("Objetos con DISTINTA referencia en memoria");
        }
        
        //El metodo equals pregunta por la referencia y el contenido
        if(empleado1.equals(empleado2)){//true or false
            //Hasta aqui, la condicional entra aqui ya que tienen el mismo contenido pero no son los mismos objetos
            System.out.println("Equals - Objetos con MISMO contenido");
        }else {
            System.out.println("Equals - Objetos con contenido DIFERENTE");
        }
        
        //De mismo modo comenzamos con el hasChode()
            //Si equals retorna true para ambos objetos, dado que es por contenido, hashCode tambien deberia retornar igual
        if(empleado1.hashCode() == empleado2.hashCode()){//regresa valor de tipo entero
            //hasta aqui, el hashcode es igual en ambos
            System.out.println("HashCode - Valor de hashCode IGUAL");
        }else {
            System.out.println("hasCode - Valor de hashCode DIFERENTE");
        }//Por coincidencia, equals podria ser false pero el hasshcode seria igual, solo por coincidencia 
    }
}
