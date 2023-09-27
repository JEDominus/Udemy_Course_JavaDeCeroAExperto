package test;

import datos.Conexion;
import datos.IPersonaDAO;
import datos.PersonaDAO;
import domain.PersonaDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestCapaDatosJDBC {
    /* Buenas practicas y patrones de diseño

        - La aplicacionse divide en avrias capas
            - Presentacion: Administra el flujod e la presentacion de pantallas en siste,a
            - Negocio: Procesa la logica de negocio t o servicios del sistema
            - Datos: Obtiene y guarda informacion de las fuentes de datos comoa archivos, DB etc
        - Estas capas se comunican para procesar la informacion desde que se inrgesa por el usuario, hasta que se responde de vuelta

        - Buenas practicas: incluyen temas de codificacion
        - Patrones de diseño: Resulven problemas que se presentan recurrentemente	
            - Guia que puede involucrar varias clases
            - Cada capa de aplicacion puede tener diferentes patrones de diseño
            - Presentacion: MVC, Front Controller, FTO
            - Servicio: Business Delegate, Service Locator, DTO
            - Datos: DAO ectrae y almacena informacion en la BD, DTO, etc

        - Cohesion y bajo acomplamiento: Cada quien haga lo suyo y comuniquese lo menos posible
            - Cohesion: medida en la que un componente de software se dedica a ejecutar la tarea pára la que fue creada
            - Acoplamiento: medida en la que cambios de un componente requieren cambios en otros componentes
                - Mide el grado de dependencia de 2 o mas componentes
*/
    public static void main(String[] args){
        introduccionTransaccionesJSBC();
    }
    
    public static void introduccionTransaccionesJSBC(){
        //Mantenemos el codigo base igual que la leccion anterior
        Connection conexion = null;
        
        try {
             conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            //En esta ocasion, el tipo de variable es interface y la instancia es la implementacion
            IPersonaDAO personaDao = new PersonaDAO(conexion);
            //Traemos los objetos con la operacion de selects
            List<PersonaDto> personas = personaDao.seleccionarTodo();
            //Iteramos para imprimir cada una 
            personas.forEach(persona -> {
                System.out.println(persona); 
            });
            
            //Al ser solo un select, el commit no es necesario ya que no estamos modificando el estado de la DB
            conexion.commit();
        } catch(SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Problemas al ejecutar el bloque transaccional, haciendo rollback...");
            
            try {
                conexion.rollback();
            } catch(SQLException e2){
                e2.printStackTrace();
            }
        }
    }
    
    //Con esto ya terminamos la implementacion de la capa de datos de forma interfaz con un DAO y un DTO
}
