package test;

import accesodatos.*;

public class TestInterfaces {
    public static void main(String[] args) {
        //Clase abstracta - caracteristicas en comun (Figuras tienen lados, areas, etc)
        //Interfaz - comportamiento en comun (DB inserta, lee, actualiza, etc)
        interfaces();
    }
    
    public static void interfaces(){
        //Una interfaz es muy parecida a una clase abstracta - sus metodos tampoco tienen implementacion
            //Todos los metodo de un interfaz son abstractos, en cambio la clase abs puede tener metodos normales
            //Todos lso atributos de una interfaz siempre son constantes (public+static+final), los de la clase no siempre
        //Diferencias entre /Cuando utilizar interfaz y clase abstracta
            //Relacion entre clases por caracteristica de herencia (atributos) === Usar Clase bstracta
                //Usar clase cuando se heredfe a otra (Solo una herencia)
            //Relacion entre clases por comportamiento (metodos) === Usar Interfaz
                //Usar interfaz para multiples implementaciones
        //el ejemplo de DB utiliza un interfaz ya que ambas DB tienen metodos (comportamientos) de insersion, lectura, remocion, etc
        //La interfaz es un nuevo tipo de clase en Java (Java class / Java interface) 
        
        //Asi como podemos usar polimorfismo con clases abstractas del tipo padre creando de tipo hijo
            //Figura = new Rectangulo... Lo mismo ocurre con las interfaces... Se pueden crear variables de tipo interfaz
        //Permite la creacion de codigo generico
            //No se puede instanciar una interface con new IAccesoDatos() al igual que las clases abstractas
        //Para trabajar con esos metodos, debemos tomar una implementacion al igual que en el polimorfismo y las clases abstractas
        IAccesoDatos datos = new MySQLImp();
        //Una vez con la variable ya podemos aplicar polimorfismo
        datos.insertar();//Insertando desde SQL...Se ejecuta el metodo al que apunta el objeto en memoria, es decir, de la clase
        imprimir(datos);
        
        datos = new OracleImp();//una variable de tipo interfaz puede apuntar a diferentes implementaciones dado el tipo de la variable datos (interfaz)
        datos.insertar();
        imprimir(datos);//Lista desde oracle
    }
    
    public static void imprimir(IAccesoDatos datos){
        //Se ejecuta el metodo segun al que la variable datos este apuntando en memoria
            //En la primer llamada apunta a la implementacion de MySQL y en la segunda a la de Orale
        datos.listar();
    }
}
