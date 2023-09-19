package test;

import java.util.*;

    /* java.util
                Collection(I)                            Map(I)
            Set(I)|         |List (I)                        |
    HashSet(C)|      ArrayList(C)| |Vector(C)      HashMap(C)|
    
    ---------------------------------------------------------------------------
        La interfaz Set y List implementan la interfaz Collection
            La I.Set se impl. en C.HashSet y I.List en C.ArrayList y C.Vector
        Asi mismo, la interfaz map se implementa en la clase hashMap
    */
    
public class TestAPICollections {
    public static void main(String[] args) {
        //interfaceList();//Lambda
        //interfaceSet();
        interfaceMap();
    }
    
    public static void interfaceList(){
        //La clase array List implementa la interfaz List, que a su vez implementa Collection
            //Collection es la interfaz Padre de List, y List de ArrayList
                
        //Creamos un objeto de tipo List - Polimorfica 
        List myList = new ArrayList();//importar de java.util, no de java.awt
        //Si no se especifica un tipo, la myList recibe tipo Object
        
        //Una myList se comporta igual que un array, solo que es de tamaño dinamico
            //No hay que definirsu tamaño al instanciarlo y mantiene el orden en que los agregamos
                //A diferencia de los Set, que no mantienen el orden
        myList.add("Lunes");//Se puede agregar cualquier Object, asi que puede ser un string
        myList.add("Martes");
        myList.add("Miercoles");
        myList.add("Jueves");
        myList.add("Viernes");
        myList.add("Viernes");//Permite elementos repetidos
        
//        //Para imprimir la myList, podemos usar el foreach
//        for(Object dia: myList){//Como la myList es de tipo Object, ese es el tipo de la unidad
//            System.out.println(dia);
//        }//Imprime los valores en orden
        
        //A partir de Java 8 se pueden usar lambdas (arrow functions) con la funcionalidad del for
        
        //Impresion de Collec tion polimorficamente
        imprimirCollection(myList);
    }
    
    public static void interfaceSet(){
        //Esta interfaz no mantiene el orden de los elementos, por lo tanto es mas rapida al agregar elementos
            //Tampoco permite la adicion de elmentos repetidos
        Set mySet = new HashSet();//La clase mas comun que implementa interfaz Set
        //El metodo add tambien puede 
        mySet.add("Lunes");//el metodo add es de la itnerfaz padre Collection, por eso la usa list y set
        mySet.add("Martes");
        mySet.add("Miercoles");
        mySet.add("Jueves");
        mySet.add("Viernes");
        mySet.add("Viernes");//El Set no permite la adicion de elementos repetidos
        //Por lo tanto este ultimo viernes no loa grego
        
        //Imprimimos con metodo polimorfico, implementa lambda
        imprimirCollection(mySet);
        
    }
    
    public static void imprimirCollection(Collection collection){//Polimorfia requiere el tipo padre de las formas (clases)
        System.out.println("Impresion polimorfica de tipo Collection (List o Set)");
        collection.forEach(item -> {//Comienza el cuerpo de la funcion anonima
            System.out.println("item = " + item);//El parametro se puede usar dentro del cuerpo
        });//Termina el cuerpod e la funcion
    }
    
    public static void interfaceMap(){
        //Un mapa es una coleccionde elemento bajo el concepto key:valu pair
        Map myMap = new HashMap();
        //Dado que esta interfaz no ehreda de Collection, para agregar elemento se usa:
        myMap.put("Nombre1","Javier");//Tanto la llave como el valor puede ser de tipo Object
        myMap.put("Nombre2","Natalia");
        myMap.put("Nombre3","Mario");
        
        //Para acceder a los valores del mapa se usa 
            //Downcasting - Requiere casteo explicido
                //Tambien puede ser variable de tipo object
        String elemento = (String) myMap.get("Nombre1");//Se debe recibir en variable del mismo tipo 
        System.out.println("elemento = " + elemento);
        
        //Para traer todos los keys, se usa keySet() que retorna un set de solo keys
        Set mapValues = myMap.keySet();
        imprimirCollection(mapValues);//Imprime Nombre1, Nombre2 y Nombre3
        
        //Para traer todos los valores, se usa values() que retorna uns et de solo valores
        imprimirCollection(myMap.values());//imprime Javier, Natalia Mario
    }
}
