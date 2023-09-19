package operaciones;

public class PruebAritmetica {
    public static void main(String[] args) {
        //metodosEnJava();
        //constructoresEnJava();
        //alcanceDeVariables();
        memoriaStackYHeap();
    }
    
    private static void metodosEnJava(){
        //Llamada al constructor vacio
        Aritmetica aritmetica1 = new Aritmetica();
        aritmetica1.a = 3;
        aritmetica1.b = 2;
        aritmetica1.sumar();
        
        int resultado = aritmetica1.sumarConRetorno();
        System.out.println("resultado con retorno = " + resultado);
        
        //Metodo que recibe argumentos
        resultado = aritmetica1.sumarConRetornoYArgumentos(5, 3);//Parametro cuando se da valor al llamar
        System.out.println("resultado con argumentos = " + resultado);
        
        //Operador this
            //Al debugear, la palabra this contiene la informacion del objeto ejecutado en ese momento
            //Se puede usar el operador this para referirse a atributos del objeto que se ejecuta en ese momento
            //El operador this apunta a la direccion de memoria del objeto en cuestion @asy3sd
            //El operador this es OPCIONAL, pero es una buena practica 
            //Nos permite saber que es un atriobuto de clase y no una variable local... Ya que se puede confundir 
            //Acostumbrarse a usarlo en los atributos... 
            //Es usual que los argumentos de un metodo se llamen igual que sus atributos
                //Para ello se diferencia el attriuto del argumento con this.a = a;
                //Recordad ejemplo de goblins al cambiar un valor de toda la clase 
            //Dentro de un metodo estatico no se puede acceder al operador this
    }
    
    private static void constructoresEnJava(){
        Aritmetica aritmetica1 = new Aritmetica();//Uso de constructoir vacio... Imprime ejecutando constructor
        System.out.println(" aritmetica1 a = " +  aritmetica1.a);//imprime valores por defecto
        System.out.println(" aritmetica1 b = " +  aritmetica1.b);
        
        Aritmetica aritmetica2 = new Aritmetica(3, 5);//Imprime ejecutando constructor sobrecargado
        System.out.println(" aritmetica2 a = " +  aritmetica2.a);//imprime valores asignados en el constructor sobrecargado
        System.out.println(" aritmetica2 b = " +  aritmetica2.b);
    }
    
    private static void alcanceDeVariables(){
        //Variables locales
        var a = 10;//Solo s pueden utilizar en el metodo creado 
        var b = 2;
        otroMetodo();//Al debugear, se ve que ya no se tiene acceso a a y b
    }
    
    private static void otroMetodo(){
        //Variable fuera de alcance dado que esta en otro metodo
        //a = 10; //Las variable no existe ya que solo se cxrea y destruye en otro metodo  
        System.out.println("Otro metodo");
    }
    
    private static void memoriaStackYHeap(){
        //Existen 2 tipos de variables: Locales se destruyen al terminar el metodo
        //De tipo object, se destruyen al terminar el programa...
        
        //Memoria stack - Alamcena la variables locales, contiene la referencia del objeto
        //La referencia apunta a la memoria donde se almacenan los objetos, que es la memoria Heap
            //Stack contiene la referencia a heap, heap el objeto y sus atributos
            
        int a = 10;//Se almacenan en memoria stack
        //"aritmetica" guarda la referencia del objeto en stack
        Aritmetica aritmetica = new Aritmetica();//new crea y guarda el objeto en heap, su referencia esta en stack
        
        //Objeto ya no contiene referencia 
        aritmetica = null;//candidato a ser eliminado con el  gc
        //Objeto pesado que no se debe llamar a cada rato
        System.gc(); // Garbace Collector... Recolecta los objetos no referenciados y los elimina
        
        //Al terminarse de ejecutar este metodo, la referencia en stack del objeto se elimina
            //El objeto queda sin referenciar pero permanece almacenado en la memoria heap
            //En ese momento, el objeto queda candidato para limpieza
    }
            
}
