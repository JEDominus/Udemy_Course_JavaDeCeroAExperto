package palabrathis;

public class PalabraThis {
    public static void main(String[] args) {
        palabraThis();
    }
    
    public static void palabraThis(){
        //Esta es otra forma valida pero innecesaria de crear string
        //Java tiene algo llamado pool stream donde almacena las referencias de cadenas previamente creadas
            //Si llegamos a crear otra cadena con los mismo caracteres(mismo valor) la toma de ahi
            //Si la referencia a MOta es @1234 y vuelvo a crear una cadena con el valor "Mota", me regresa la referencia del pool stream de la cadena anteriormente creada
            //Pero si la creo con el new String().. aunque tenga el mismo valor, ya va a tener otra referencia
            //Por usar la palabra new, ya se crea otra referencia en memoria 
            //Es mas eficiente no usar el new dado el pool stream... hace mas eficiente el uso de cadenas
        Persona persona1 = new Persona(new String("Javier"), "Mota");
        System.out.println("persona1 = " + persona1);
        System.out.println("persona1 = " + persona1.nombre);//Se puede acceder a atributos dado que la clase es default/package
    }
}

//Se pueden tener clases dentro de otras clases
//Solo la primer clase puede tener el Public
//Todas las demas clases ya no pueden ser publicas dentro de este mismo paquete
//Tambien se le conoce como default class Persona Y package class Persona
    //Esto debido a que solo se pueden usar a esa altura
//Esta clase solo se puede acceder mediante las clases que esten dentro de este mismo paquete
class Persona {
    //Attributo default/package, por lo que no requiere el public
    String nombre;
    String apellido;
    
    //Tampoco requiere el modificador publico
    Persona(String nombre, String apellido){
        //Aqui aunque no se vea, hay una llamada a la clase padre
        //Ese super es el que crea el espacio en memoria y crea la referencia... daq acceso a this
        //super();//Constructor de la clase padre Object... Reserva el espacio en memoria
        this.nombre = nombre;
        this.apellido = apellido;
        //this se usa para referenciar el objeto en cuestion
        System.out.println("object = " + this);//Impriome el objeto creado usando este constructor
        //imprime el objeto que se esta creando en ese momento con la palabra this 
        
        //Referencia this es tipo persona porque estamos en la clase Persona
        new Imprimir().imprimir(this);//this aqui vale persona... dentro de imprimir, vale el objeto imprimir
        //This equivale al objeto de la clase donde se llama el this
    }
}

class Imprimir{
    public void imprimir(Persona persona){
        System.out.println("persona desde imprimir = " + persona);//imprime el objeto recibido
        //Referencia this es de tipo imprimir porque estamos en la clase imprimir
        System.out.println("operador this desde imprimir = " + this);//este imprime el objeto en ejecucion, imprimir
    }
}
