package test;

import datos.PersonaDAO;
import domain.Persona;
import java.sql.SQLException;
import java.util.List;

public class TestManejoJDBC {
    /* Manejo y buenas practicas de JDBC
        1. Crear una clase en paquete de datos para manejar la conexion ala DB y cerrar los objetos MySQL
            "Conexion.java"
    
        2. Creamos una clase java que representa la tabla de la DB, tambien conocida como clase de entidad
            "Persona.java"
    
        3. Creamos una clase que maneje las operaciones de la abse de datos como un servicio
             "PersonaDAO.jav"
    
        Bajo acomplamiento: cada clase tiene las relaciones minimas necesarias con las demas clases
        Alta cohesion: cada clase realiza unicamente su funcion
    */
    public static void main(String[] args){
        //imprimircomoPersonasLosRegistrosDeLaTabla();
        //insertarDesdePersonaEnLaTabla();
        //actualizarRegistroDesdePersona();
        eliminarRegistroDesdePersona();
    }
    
    public static void imprimircomoPersonasLosRegistrosDeLaTabla(){
        //Instanciamos el DAO que accede a DB y mapea en clase entidad Persona
        PersonaDAO personaDao = new PersonaDAO();
        //Llamamos al metodo que hace un select sobre la DB y mapea los valores en objetos
        List<Persona> personas = personaDao.seleccionarTodo();
        //Iteramos la lista obtenida
        personas.forEach(persona -> {
            System.out.println(persona);
        });
    }
    
    public static void insertarDesdePersonaEnLaTabla(){
        PersonaDAO personaDao = new PersonaDAO();
        Persona persona = new Persona ("Alonso", "Mota", "petocho@gmail.com", "3345781218");
        int registros = personaDao.insertarPersona(persona);
        
        System.out.println("Registros afectados = " + registros);
        imprimircomoPersonasLosRegistrosDeLaTabla();
    }
    
    public static void actualizarRegistroDesdePersona(){
        PersonaDAO personaDao = new PersonaDAO();
        imprimircomoPersonasLosRegistrosDeLaTabla();//imprimimos valores en tabla antes de actualizacion
        //Se crea un objeto indicando el Id ya que lo requiere el update y cambiamos el correo
        Persona persona = new Persona (5, "Alonso", "Mota", "petocho.nuevo@gmail.com", "3345781218");
        int registros = personaDao.actualizarRegistro(persona);//Actualizamos
        System.out.println("Registros actualizados = " + registros);//Imprimimos los registros modificados
        imprimircomoPersonasLosRegistrosDeLaTabla();//Volvemos a llamar a todos los registros para ver el cambio 
    }
    
    public static void eliminarRegistroDesdePersona(){
        PersonaDAO personaDao = new PersonaDAO();
        imprimircomoPersonasLosRegistrosDeLaTabla();//imprimimos valores en tabla antes de actualizacion
        Persona persona = new Persona(4);//Solo se pasa el Id porque es lo que necesita para borrar
        System.out.println("Registros eliminados: " + personaDao.eliminarRegistro(persona));
        imprimircomoPersonasLosRegistrosDeLaTabla();
    }
}
