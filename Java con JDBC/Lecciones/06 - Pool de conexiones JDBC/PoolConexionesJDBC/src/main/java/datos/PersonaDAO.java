package datos;

import domain.PersonaDto;
import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

public class PersonaDAO implements IPersonaDAO {
    private Connection conexionTransaccional;
    
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    
    public PersonaDAO() {
    }

    public PersonaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    @Override
    public List<PersonaDto>  seleccionarTodo() throws SQLException{
        System.out.println("Ejecutando: " + SQL_SELECT);
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;
        PersonaDto persona = null;
        List<PersonaDto> personas = new ArrayList<>();
        
        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            statement = conexion.prepareStatement(SQL_SELECT);
            resultado = statement.executeQuery();
            
            while(resultado.next()){
                int idPersona = resultado.getInt("id_persona");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                
                persona = new PersonaDto(idPersona, nombre, apellido, email, telefono);
                
                personas.add(persona);
            }
            
            System.out.println("Registros Encontrados: " + personas.size());
        } finally {
            try {
                close(resultado);
                close(statement);
                if(this.conexionTransaccional == null){ 
                    close(conexion);
                }
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return personas;
    }
    
    @Override
    public int insertarPersona(PersonaDto persona) throws SQLException{
        System.out.println("Ejecutando: " + SQL_INSERT);
        Connection conexion = null;
        PreparedStatement statement = null;
        int registros = 0;
        
        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            statement = conexion.prepareStatement(SQL_INSERT);
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getEmail());
            statement.setString(4, persona.getTelefono());
            
            registros = statement.executeUpdate();
            System.out.println("Registros insertados: " + registros);
        } finally {
            try{
                close(statement);
                if(this.conexionTransaccional == null){ 
                    close(conexion);
                }
            } catch(SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }
    
    @Override
    public int actualizarRegistro(PersonaDto persona) throws SQLException{
        System.out.println("Ejecutando: " + SQL_UPDATE);
        Connection conexion = null;
        PreparedStatement ps = null;
        int registros = 0;
        
        try{
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            ps.setInt(5, persona.getIdPersona());
            
            registros = ps.executeUpdate(); 
            System.out.println("Registros actualizados: " + registros);
        } finally {
            try {
                close(ps);
                if(this.conexionTransaccional == null){ 
                    close(conexion);
                }
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return registros;
    }
    
    @Override
    public int eliminarRegistro(PersonaDto persona) throws SQLException{
        System.out.println("Ejecutando: " + SQL_DELETE);
        Connection conexion = null;
        PreparedStatement ps = null;
        int registros = 0;
        
        try {
            conexion = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, persona.getIdPersona());
            
            registros = ps.executeUpdate();
            System.out.println("Registros eliminados: " + registros);
        } finally {
            try {
                close(ps);
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
