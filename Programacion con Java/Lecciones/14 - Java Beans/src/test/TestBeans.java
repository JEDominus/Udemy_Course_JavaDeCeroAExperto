package test;

import domain.Persona;

public class TestBeans {
    public static void main(String[] args) {
        //Como definir una clase para que sea un bean utilizable para tecnologias avanzadas
        javaBeans();
    }
    
    public static void javaBeans(){
        //Para que una clase en java se considere un bean:
            //Constructor vacio
            //Cada atributo tiene que ser privado
                //Cada uno debe tener getter y setter
            //Debe implementar la intertfaz Serializable para poder enciarse por la red a diferentes dispositivos
                //Esta interfaz permite enviar la clase entre diferentes equipos (servidores)
                //permite convertir el objeto a 0 y 1 para enviarlo por la red 
                    //Concepto de serializacion y deserializacion
        //FW como Spring, Hibernate ys ervidores requieren que nuestra clase tenga implementado serializable
        
        //FORMALIZACION DEL USO DE JAVA BEAN
        //Creamos objeto de tipo con constructor vacio
            //Podemos crear objetos sin saber sus atributos - Tecnologias avanzadas usaran este
        Persona persona = new Persona();//Usamos su constructor vacio
        //Asignamos valores al objeto con los setters
        persona.setNombre("Javier");
        persona.setApellido("Mota");
        
        //Imprimir objeto con toString (Todo el objeto)
        System.out.println("persona = " + persona);
        
        //Imprimir valores por separado (con getters)
        System.out.println("persona.getNombre() = " + persona.getNombre());
        System.out.println("persona.getApellido() = " + persona.getApellido());
    }
}
