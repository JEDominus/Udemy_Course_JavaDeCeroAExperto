package test;

import datos.Conexion;
import datos.IPersonaDAO;
import datos.PersonaDAO;
import domain.PersonaDto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestPoolConexionesJDBC {
    /* Pool de conexion con JDBC
        - Permite agilizar el proceso de obtener una conexion por cada clase de java que requiere una
        - Su objetivo es tener lista varias conexiones a la Base para que sea mas eficinete el proceso de obtener y liberar conexiones
        - El proceso de administracion de conexiones se le delega al pool
            - Por ello ya no requerimos abrir y cerrar conexiones, pues el pool se encarga
        - Se puede crear un pool con java, utilizar JDBC de apache, servidor de aplicaciones java tomcat
    
        - Para obtener un pool de conexiones, podremos apoyarnos de apache commons
            - Proyecto que contiene varias librerias comunes para proyectos java
            - Revisar el pom para mas detalles
    */
    public static void main(String[] args){
        poolDeConexionesJDBC();
    }
    
    //6.- Ahora todo deberia seguir funcionando igual
    public static void poolDeConexionesJDBC(){
        Connection conexion = null;
        
        try {
            //7.- Ahora esta conexion la gestiona el pool de conexiones
             conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            IPersonaDAO personaDao = new PersonaDAO(conexion);
            List<PersonaDto> personas = personaDao.seleccionarTodo();
            personas.forEach(persona -> {
                System.out.println(persona); 
            });
            
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
}
