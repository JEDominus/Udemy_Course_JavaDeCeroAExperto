package test;

import domain.Persona;

public class PersonaPrueba {
    //Este metodo es estatico ya que el compilador no va a crear una instancia de esta clase para correr el programa
    //Asi solo usa el nombre de la clase y el metodo main .... PruebaPersona.main(...);
    public static void main(String args[]){
        //contextoEstatico();
        metodoEstaticos();
    }
    
    public static void contextoEstatico(){
        //Existen 2 contextos, estaticos y dinamico
        //El contexto estatico es cuando trabajamos con las clases
        //Una vez cargadas las clases en memoria y comenzamos a usar objetos, se conoce como contexto dinamico
            //Contexto estatico - carga de clases en memoria
            //Contexto dinamico - uso de objeto de clases en memoria 
        //El contexto estatico no puede acceder al contexto dinamico, ya que se requiere de clase spara crear objetos
        //El contexto dinamico si puede acceder al estatico, ya que trabajando con objetos,s e puede acceder a las clases
        
        //La palabra static en los metodos y attributos se asocian con la clase y no con los objetos
        //Si no usamos la palabra static, se asocia con los objetos, es decir, contexto dinamico
        
        //Lo que se defina con static, sera accesible para cualquier objeto, es decir, el obj1 y obj2, podran acceder a esos metodos o atrivbutos con static
            //Es por ello cuando se llama a un metodo o atributo estatico, no se requiere de una instancia(objeto) porque se asocia con la clase
            //i.e. en luigar de nombre del objeto, se usa el no,mbre de la clase...  NombreCLase.metodoEstatico / ...attributoEstatico
        
        Persona persona1 = new Persona("Javier");//Se llama al constructor con 1 argumento (El id se setea solo)
        System.out.println("persona1 = " + persona1);//Se imprime el objeto, dado que tien el toString, asi es syuficiente
        
        Persona persona2 = new Persona("Enelida");
        System.out.println("persona2 = " + persona2);//El valor idPersona ahora vale 2 dado su incremento en el constructor
        //Si el contador no fuera estatic, se reiniciaria a 1 cada que se crea ujn objeto nuevo
        
        Persona persona3 = new Persona("Meliodas");
        System.out.println("persona3 = " + persona3);//Contador e Id incrementa a 3
    }
    
    public static void metodoEstaticos(){
        Persona persona1 = new Persona("Javier");
        Persona persona2 = new Persona("Enelida");
        
        imprimir(persona1);
        imprimir(persona2);
        
        //IMPORTWNTE: No se puede utiliozar la palabra this dentro de un metodo estatico debido a 
            //this hace referencia a un objeto, lo estatico a nivel clase
            //This es contexto dinamico, static estatico... contexto esstatico no accede al dinamico
        //Las variable no estaticas nos e pueden usar dentro de metodos estaticos por el mismo motivo
        //En conclusion: static atributes con static methods... contexto dinamico, this y atributos con metodos no estaticos
    }
    
    //Debe ser estatico ya que se llama dentro de otro emtodo estatico
    //El orden de los modificadores no importa, i.e.
    static public void imprimir(Persona persona){
        System.out.println("persona = " + persona);
    }
}
