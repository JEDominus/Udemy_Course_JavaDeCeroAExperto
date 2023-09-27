package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

public class PersonaDAO { 
    /*  Para el manejo de transacciones se pueden hacer multiples sentencias sobre diferentes tablas
        Por ello, no deberiasmoa de abrir y cerrar conexion conc ada uno de los metodosl, ya que podriamos requerir mas de uno
        Para que la transaccion pueda hacer rollback, debe ser la misma conexion con la DB y no abrir y cerrar en cada una
        Para ello, definimos la conexion como un atributo de clase
    */
    private Connection conexionTransaccional;
    
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    
    //Va a requerir un constructor para dicha conexion
    public PersonaDAO() {
    }

    //Con esto la transaccion se abre, se hace commit/rollback y se cierra desde otra clase
    public PersonaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Persona>  seleccionarTodo() throws SQLException{//Se propagar para que se haga el rollback en la clase de test
        System.out.println("Ejecutando: " + SQL_SELECT);
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            //ahora la conexion se crea en el metodo solo si la transaccional no fue creada
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            statement = conexion.prepareStatement(SQL_SELECT);
            resultado = statement.executeQuery();
            
            while(resultado.next()){
                int idPersona = resultado.getInt("id_persona");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                
                personas.add(persona);
            }
            
            System.out.println("Registros Encontrados: " + personas.size());
        
        //Se removio el bloque catch para que se propage a la clase de test
        } finally {
            try {
                close(resultado);
                close(statement);
                //Solo cerrar la conexion si se creo en este metodo 
                if(this.conexionTransaccional == null){ 
                    close(conexion);
                }
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return personas;
    }
    
    public int insertarPersona(Persona persona) throws SQLException{//Se propagar para que se haga el rollback en la clase de test
        System.out.println("Ejecutando: " + SQL_INSERT);
        Connection conexion = null;
        PreparedStatement statement = null;
        int registros = 0;
        
        try {
            //ahora la conexion se crea en el metodo solo si la transaccional no fue creada
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            statement = conexion.prepareStatement(SQL_INSERT);
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getEmail());
            statement.setString(4, persona.getTelefono());
            
            registros = statement.executeUpdate();
            System.out.println("Registros insertados: " + registros);
        //Se removio el bloque catch para que se propage a la clase de test
        } finally {
            try{
                close(statement);
                //Solo cerrar la conexion si se creo en este metodo 
                if(this.conexionTransaccional == null){ 
                    close(conexion);
                }
            } catch(SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    public int actualizarRegistro(Persona persona) throws SQLException{//Se propagar para que se haga el rollback en la clase de test
        System.out.println("Ejecutando: " + SQL_UPDATE);
        Connection conexion = null;
        PreparedStatement ps = null;
        int registros = 0;
        
        try{
            //ahora la conexion se crea en el metodo solo si la transaccional no fue creada
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            ps.setInt(5, persona.getIdPersona());
            
            registros = ps.executeUpdate(); 
            System.out.println("Registros actualizados: " + registros);
        
        //Se removio el bloque catch para que se propage a la clase de test
        } finally {
            try {
                close(ps);
                //Solo cerrar la conexion si se creo en este metodo 
                if(this.conexionTransaccional == null){ 
                    close(conexion);
                }
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return registros;
    }
    
    public int eliminarRegistro(Persona persona) throws SQLException{//Se propagar para que se haga el rollback en la clase de test
        System.out.println("Ejecutando: " + SQL_DELETE);
        Connection conexion = null;
        PreparedStatement ps = null;
        int registros = 0;
        
        try {
            //ahora la conexion se crea en el metodo solo si la transaccional no fue creada
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, persona.getIdPersona());
            
            registros = ps.executeUpdate();
            System.out.println("Registros eliminados: " + registros);
        
        //Se removio el bloque catch para que se propage a la clase de test
        } finally {
            try {
                close(ps);
                //Solo cerrar la conexion si se creo en este metodo 
                if(this.conexionTransaccional == null){ 
                    close(conexion);
                }
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
}
