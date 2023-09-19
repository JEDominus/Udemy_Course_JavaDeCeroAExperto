package clases;


public class PruebaPersona {
    public static void main (String args[]){
        clasesEnJava();
    }
    
    private static void clasesEnJava(){
        //Una clase es una plantilla para abstraer informacion del mundo real
        //Posee attributos y metodos 
        //En la clase se definen attributos y metodos, Los objetos obtienen los valores
        //Se puede tener multiples objetos de una clase (instancias)        
        //Un paquete es un "folder" donde podemos clasificar nuestras clases 
        
        //Se requiere crear un objeto a partir de una clase para darle valores
        //Se trabaja con los objetos y no con las clases
        //El navigator tab nos permite ver attributos, metodos y constructores
        
        //una clase es un nuevo tipo definido
        //Se puede compartir con toros proyectos
        
        //variables y objetos se almacenan en lugares diferentes de la memoria 
        Persona persona1;//Declaracion del objeto sin inicializar
        persona1 = new Persona(); //Constructor que inicializa la variable
        
        //Acceso a atributos mediante notacion de .
        persona1.nombre = "JAVIER"; //Asignacion de valores mediante operador
        persona1.apellido = "MOTA";
        persona1.desplegarInformacion();//Llamada a metodo de objeto 
        
        //Los valores hexadecimales en java comienza en 0X para las referencias a objetos en memoria
        Persona persona2 = new Persona();
        //Imprime llso datos del objeto... nombre de paquete, clase, @ y la referencia en memoria
        //persona1 y persona 2 tiene diferentes referencias en memoria dado que son objetos diferentes
        System.out.println("persona1 = " + persona1);
        System.out.println("persona2 = " + persona2);
        
        persona2.desplegarInformacion(); //Despliega null ya que no se les ha asignado valor
        persona2.nombre = "ENELIDA";
        persona2.apellido = "MARTINEZ";
        persona2.desplegarInformacion();//Ahora si muestra los nombres correcta,ente
        
    }
}
