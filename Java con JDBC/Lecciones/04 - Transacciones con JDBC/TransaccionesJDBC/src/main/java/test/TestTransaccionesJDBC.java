package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;

public class TestTransaccionesJDBC {
    /* Transacciones en JDBC
        - Conjunto de instrucciones SQL, varias y diferentes operaciones agrupadas en un bloque de ejecucion
        - Si una consulta falla, se puede hacer una rollback de todo el bloque sin alterar la base de datos
        - Si todo es correcto, se guardan los cambios haciendo cmit del bloque ejecutado

        - Una transaccion es un conjunto de instrucciones agrupadas en un bloque
        - Se puede configurar autocimmit true o false
            - Commit: guarda los cambios del bloque en la DB
            - Rollback: revierte los cambios realizados
        - Pordefault autocommit esta ent rue
        - Si cerramos la conexion con la DB, se hace commit aunque este por drfault = false
        - Es comun encerrar los bloques en trycatch y hacer rollback en las excepciones
*/
    public static void main(String[] args){
        introduccionTransaccionesJSBC();
    }
    
    public static void introduccionTransaccionesJSBC(){
        //Se deb inicializar aqui para acceder en ella en el catch
        Connection conexion = null;
        
        try {
            //1.- e genera la conexion con la DB ahora en lugar de la clase DAO
             conexion = Conexion.getConnection();      
            //2.- Revisamos el valor de autocommit
            if(conexion.getAutoCommit()){
                //3.- Sobreescribimos para eviotar que el commit se haga automaticamente... Debemos hacerlo manualmente
                conexion.setAutoCommit(false);
            }
            
            //4.- Usamos el constructor para asignar la conexion transaccional que acabamos de crear/validar
            PersonaDAO personaDao = new PersonaDAO(conexion);
            
            //5.- llamamos a todas las instrucciones que queramos para la transaccion
                //Aqui es donde se permitira hacer multiples consultas sql en un solo bloque con la misma conexion
                //Comenzando por hacer una modificacion
            //Hay que crear el objeto con los valores actualizados
            Persona personaCambio = new Persona(6, "Enelida", "Martinez", "testCambio@gail.com", "1234567890");
            personaDao.actualizarRegistro(personaCambio);
            //HAsta aqui termina el UPDATE
            
            //6.- Ahora podemos hacer otra consulta, por ejemplo, un insert
                //Insert que falla por cantidad de caracteres... dispara rollback
            //Persona nuevaPersona = new Persona("Jose", "Camaernaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "test5@gmail.com", "7891234560");
                //Ejecucion del bloque transaccional exitosa
            Persona nuevaPersona = new Persona("Jose", "Camaerna", "test5@gmail.com", "7891234560");
            personaDao.insertarPersona(nuevaPersona);
            
            //7.- Si hasta aqui todo funciona, se deben ejecutar las sentencias y guardar los cambios
                //Hacemos el commit manualmente
            conexion.commit();
            
        } catch(SQLException e) {//Para que entre asqui, hay que quitar el catch del metodo que va a tronar y solo propagarlo en la firma del metodo
            e.printStackTrace(System.out);
            System.out.println("Problemas al ejecutar el bloque transaccional, haciendo rollback...");
            
            try {
                //Con este rollback, el update e insert no se van a reflejar en la DB
                    //Para hacer que falle, hay que agregar ams de 45 caracteres en algun parametro de la sentencia
                    //Esto porque el campo de la tabla solo soporta 45
                conexion.rollback();
                    //Al caer en este rollback, no se ha reflejado el update que se jecuto al principio
            } catch(SQLException e2){
                e2.printStackTrace();
            }
        }
    }
}
