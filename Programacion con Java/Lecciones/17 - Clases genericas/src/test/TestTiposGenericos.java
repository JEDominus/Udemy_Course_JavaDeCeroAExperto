package test;

import genericos.ClaseGenerica;
import java.util.*;

/*  Tipos Genericos
        Los tipos genericos son comodines que no especifican el tipo de datod e una clase
        Hast que se va a instanciar un objeto de dicvha clase, se especifica el tipo
    
    Nomenclatura    
        T - type: utilizado para tipos, osea clases
        E - element: usado para frameworks de Collections "Interface Collection<E>" es decir List o Set
        K - key: utilizado para Maps
        V - value: utilizado en Maps
        N - number: utilizado para numeros
        S,U,V - otros tipos
*/

public class TestTiposGenericos {
    public static void main(String[] args) {
        //genericoType();
        //genericCollections();
        genericoMap();
    }
    
    public static void genericoType(){
        //Para usar la clase genericda se debe de instanciar con el nombre de la clase generica y definimos el tipo de clase
            //El tipo puede ser cualquiera que herede de Object, pues es el apdre de cada clase en java
        //No se puede usar tipos primitvos, asi que debemos usar la clase wrapper que se vio en unboxing y autoboxing
        ClaseGenerica<Integer> objetoInteger = new  ClaseGenerica(15);//En el constructor le pasamos el valor del objeto
        //Al usar el constructor, automaticamente se hace un autoboxing del 15 con la clase Integer
        objetoInteger.obtenerTipo();//Imprime el tipo Integer
        
        //Como aplica para cualquier tipo Object, se puede aplicar a nuestros propios tipos
            //De momento, usaremos otra clase de tipo Object
        //El tipo indicado entre picoparentesis debe coincidir con el valor dado en el constructor
            //Al ser tipo compatible, tambien se puede suar polimorfismo con clases e interfaces
        
            //i.e. ClaseGenerica<Persona> objetoString = new ClaseGenerica(empleado);
        ClaseGenerica<String> objetoString = new ClaseGenerica("Javier");
        objetoString.obtenerTipo();//Imprime el tipo String
    }
    
    public static void genericCollections(){
        //Asi com se le establecio el tipo de dato al instanciar una clase generica con <>
        //Tambien se puede establecer el tipo de lista y Set, por ejemplo, lista de tipó string
        List<String> myStringList = new ArrayList<>();//Ya no se agrega el tipo aqui ya que es redundante
        myStringList.add("Lunes");//ahora con contrl espacio vemos que la lista ya no es de tipoo Object si no string
        myStringList.add("Martes");
        myStringList.add("Miercoles");
        imprimirCollection(myStringList);//impresion polimorfica
        //Otra ventaja de establecer el tipo de dato a la colleccion es que ademas de validar el tipo de dato...
            //Ya no se tiene que realizar el casteo (Downcastin/Upcasting) a la hora de consultar los datos
        String strngRecuperado = myStringList.get(0);//No requiere conversion
        
        //Lo mismo aplica para el caso de set
        Set<String> myStringSet = new HashSet<>();
        myStringSet.add("Lunes");//El set ya no es de tipoo Object si no string
        myStringSet.add("Martes");
        myStringSet.add("Miercoles");
        imprimirCollection(myStringSet);//impresion polimorfica
        //Lo mismo para validacion, recuperacion y omision de downcasting
    }
    
    //Para agregar mas validaciones al tipo de dato de coleccion se especifica la coleccion y el tipo
    public static void imprimirCollection(Collection<String> collection){//Se puede modificar el tipo de elementos de la coleccion
        collection.forEach(element ->{
            System.out.println("element = " + element); 
        });
    }
    
    public static void genericoMap(){
        //Map no es la escepcion, se puede definir tipo apra llave y valor
        Map<String, String> myStringMap = new HashMap<>();
        myStringMap.put("Trabajador1", "Javier");
        myStringMap.put("Trabajador2", "Natalia");
        myStringMap.put("Trabajador3", "Mario");
        myStringMap.put("Trabajador3", "Enelida");//En este caso, se sustitulle el valor de llave dada
        //Su valor pasa de ser Mario a ser enelida
        
        //De igual forma ya no requiere downcasting para la recuperacion de llave y valro
            //En este caso, el set debera de ser de tipo String si no falla, porque el base es object
        Set<String> conversionLlave = myStringMap.keySet();
        imprimirCollection(conversionLlave);//Imprime polimorficamente
        
        //Para los valores individuales no se requiere downcasting
        String valor = myStringMap.get("Trabajador1");
        System.out.println("valor = " + valor);//Trae el nombre
    }
}
