package pasoporreferencia;

import clases.Persona;

public class PasoPorReferencia {
    public static void main(String[] args) {
        pasoPorReferencia();
    }
    
    public static void pasoPorReferencia(){//Aplica a variables de tipo objeto
        //Variables de tipo primitivo y de tipo Objct para las demass clases
        Persona persona1 = null;
        cambioDeValor(persona1);//Se envia la referencia a un objeto null
        
        persona1 = new Persona();//Variable tipo Object inicializa en la referencia
        persona1.nombre = "JAVIER";//Valor inicial del atributo nombre del objeto referenciado persona 1
        System.out.println("persona1 = " + persona1);//MISMA REFERENCIA
        System.out.println("persona1.nombre = " + persona1.nombre);
        
        //Se retorna tipo persona 
        persona1 = cambioDeValor(persona1);//Se pasa la referencia del objeto en memoria hep
        
        System.out.println("persona1.nombre (nuevo) = " + persona1.nombre);//Imprime el nuevo nombre quie se cambio en la referencia
    }
    
    //USO DE LA PALBRA RETURN
    //Retorna un tipo Object
    public static Persona cambioDeValor(Persona persona){//Se recibe la referencia al objeto en heap
        if(persona == null){//Si la persona no tiene valor
            //Si entra aqui, ya no se ejecuta lo demas
            System.out.println("Valor de persona invalido");
            return null;//retorna del metodo al anterior
        }
        
        System.out.println("persona = " + persona);//MISMA REFERENCIA
        persona.nombre = "ENELIDA";//Cambia el valor en el mismo objeto dada su referencia
        //En este punto si cambia el valor ya que no es una copia del valor, si no la referencia del objeto
        
        //Retorna el objeto completo de tipo persona despues de modificar
        return persona;//Se retorna la referencia del obejto recibida
        
        //Para metodos void, se puede retrna de la siguiente manera
        //De forma implicita, siempre esta al final del metodo aunque no se vea
        //return ; //Sin embargo no es requeridpo, ya que se infiere automaticamente
        
        //Usar el return en lineas superiores, las de abajo ya no se ejecutan 
    }
}
