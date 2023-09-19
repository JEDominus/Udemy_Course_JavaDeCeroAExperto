package test.defaultmod;

import privatemod.paquete1.PrivateClase1;
import protectedmod.paquete2.ProtectedClase2;
import publicmod.paquete1.PublicClase1;

public class TestModificadores {
    public static void main(String[] args) {
        //modificadorPublic();
        //modificadorProtected();
        //modificadorDefaultPackage();
        modificadorPrivate();
    }
    
    public static void fundamentals(){
        //Los modificadopres de acceso pueden segun lo establecido a continuacion
        /* Clases     Variables     Metodos     Constructores
            SI          SI            SI            SI          public ...Menos restrictivo
            NO          SI            SI            SI          protected
            SI          SI            SI            SI          default / package - Ausencia de modificadpor
            NO          SI            SI            SI          private ...Mas restrictivo
        */
    }
    
    public static void modificadorPublic(){//Modificador menos restrictivo
        //Las clases publicas son accesible der cualquier clase del proyecto
        //Ya sean el mismo paquete o paquetes diferentes
        //La clase se puede suar sin restriccion por ser publica

        //Se puede acceder al constructor publico desde cualquier clase
        PublicClase1 clasePub1 = new PublicClase1();//Imprime constructo publico
        //Se puede acceder al objeto de clase publica sin problemas
        System.out.println("Objeto de clase publica = " + clasePub1);//Imprime ref
        //Se puede acceder a los atributos publicos desde cualquier lugar
        System.out.println(clasePub1.atributoPublico);//Imprime atributo publico
        //Se puede acceder a los metodos publicos desde cualquier clase
        clasePub1.metodoPublico();//Imprime metodo publico 
    }

    public static void modificadorProtected(){
        //Va a permitir a las clases hijas poder acceder a los atributos, constructores y metodos del padre
        //Lo protected no se accede mediante hijos

       //No se puede usar el constructor dado que esta clase no hereda de ProtectedClase1, y no es accesible 
           //ProtectedClase claseProt1 = new ProtectedClase1();//Marca error
       //Mientras no herede de ProtectedClase, no puede acceder a nada protected

       //POdemos crear objetos de la clase hija
       //Podemos usar el constructor publico del hijo
       ProtectedClase2 claseProt2 = new ProtectedClase2();//Constructor del hijo accede al constructor protected del apdre
       //Solo con el constructor, se imprime el constructor, atributo y metodo protected del padre
    }

    public static void modificadorDefaultPackage(){//Este modificador tambien vuelve mas segura la clase default
        //Este modificador se aplica cuando no se establece ningun modificador
        //Las clases definidas como default, no pueden usarse fuera de su mismo paquete
            //La clase del paquete test-defaultMod esta disponible solo porque esta clase esta dentro del mismo paquete
        //No requiere el import ya que estan en la misma clase
        DefaultClase1 claseDefault = new DefaultClase1();    
        //Tambien se puede acceder a atributos y metodos por estar en el mismo paquete
        System.out.println(claseDefault.atributoDefault);
        claseDefault.metodoDefault();
        
        //IMPORTANTE: En caso de que esta clase heredara de una clase default, mientars esten el mismo paquete, tambien se puede acceder
    }
    
    public static void modificadorPrivate(){
        //Todo lo que sea publico SOLO es accesible mediante la misma clase
        //No es accesib le nisiquiera para hijos
        
        //Esta clase es publica, y solo tiene un cosntructo publico que llamada a todo lo privado internamente
        PrivateClase1 clasePriv1 = new PrivateClase1("VPN");
        
        //este constructor publico, llama a todo lo demas
        //Si queremos accederr al constructor, atributo o metodo privado, marca error
    }
}
