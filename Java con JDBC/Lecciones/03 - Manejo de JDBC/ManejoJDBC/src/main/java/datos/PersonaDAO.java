package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

//Esta clase maneja las operaciones basicas de MySQL sobre la clase entidad Persona
    //A este tipo de clases se les conoce como Data Acces Object (DAO) Patron de diseño
public class PersonaDAO { //Se le agrega el DAO al nombre de la clase de entidad que se usa    
    //Parte de las buenas practicas es definir las operaciones al inicio de la clase
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET email = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    
    //Ahora definimnos los metodos que procesan los objetos
    public List<Persona>  seleccionarTodo(){//trae todos los registros, los mapea en objetos Persona y regresa la lista
        //Definimos todas las variables que vamos a utilizar
        Connection conexion = null;//Conexion a la base de datos
        PreparedStatement statement = null;//Objeto que ejecutara la sentencia que creemos
        ResultSet resultado = null;//Aqui se recibe el resultado de la sentencia 
        Persona persona = null; //Clase entidad
        List<Persona> personas = new ArrayList<>(); //Aqui se almacenaran todos los registros encontrados en forma de persona
        
        try {
            //Esta llamada es estatica a conexion
            conexion = getConnection();//llamamos a la conexion de nuestra clase Conexion
            statement = conexion.prepareStatement(SQL_SELECT);//Se le pasa el select al statement
            resultado = statement.executeQuery();//ejecutamos la query y cachamos el resultado
            
            //Iteramos el resultado de la query
            while(resultado.next()){
                    //esta es la funcionalida basica de hibernate... Mapear valores de tablas y regresar objetos
                //Mapeamos el objeto actual del set de resultasdos
                int idPersona = resultado.getInt("id_persona");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                
                //Creamos el objeto java con la informacion de la base de datos
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                
                //Agregamos el objeto actual mapeado a la lista
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //Agregamos otro tryCatch por si el metodo close lanza una exception
            try {
                //Por eso se declaran las variables fuera del trycatch, para cerrarlas en el finally 
                //Con el import statico, no es necesario llamar el nombre de la clase
                close(resultado);
                close(statement);
                close(conexion);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }//En este punto, no es nbecesario propagar la exception ya que aqui se cachan todas
        
        return personas;
    }
    
    public int insertarPersona(Persona persona){
        Connection conexion = null;//Conexion a la base de datos
        PreparedStatement statement = null;//Objeto que ejecutara la sentencia que creemos
        int registros = 0;//Aqui se recibe el resultado de la sentencia 
        
        try {
            conexion = getConnection();
            statement = conexion.prepareStatement(SQL_INSERT);
            //ahora llamamos a statemente setString(por el tipo de dato) y pasamos los valores del objeto Perons
                //Si fuera otro tipo de dato, podria ser setInt
            //Se selecciona el index del parametro en la constante SQL_INSERT y su valor
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getEmail());
            statement.setString(4, persona.getTelefono());
            
            //Ahora ejecutamos la query con Update ya que es un insert y no una consulta como un select
                //Esto actualizara el estadod e la base de datos... Soporta UPDATE, INSERT y DELETE
            registros = statement.executeUpdate();//Retorna los registros afectados
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try{
                //cerramos el changarro
                close(statement);
                close(conexion);
            } catch(SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int actualizarRegistro(Persona persona){
        Connection cn = null;
        PreparedStatement ps = null;
        int registros = 0;
        
        try{
            cn = getConnection();//creamos la conexion
            ps = cn.prepareStatement(SQL_UPDATE);//Preparamos la instruccion la sentencia
            ps.setString(1, persona.getEmail());//establecemos el nuevo valor en la query
            ps.setInt(2, persona.getIdPersona());//Le pasamos el Id a la query
            
            //Ejecutamos la query
            registros = ps.executeUpdate(); 
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            try {
                //cerramos el changarro
                close(ps);
                close(cn);
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return registros;
    }
    
    public int eliminarRegistro(Persona persona){
        Connection cn = null;
        PreparedStatement ps = null;
        int registros = 0;
        
        try {
            cn = getConnection();//Abrimos la conexion
            ps = cn.prepareStatement(SQL_DELETE);//Insertamos la query en la instruccion
            ps.setInt(1, persona.getIdPersona());//Pasamos el aprametro a la query
            
            //Ejecutamos la query
            registros = ps.executeUpdate();//cachamos lo registros eliminados
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(ps);
                close(cn);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
}
