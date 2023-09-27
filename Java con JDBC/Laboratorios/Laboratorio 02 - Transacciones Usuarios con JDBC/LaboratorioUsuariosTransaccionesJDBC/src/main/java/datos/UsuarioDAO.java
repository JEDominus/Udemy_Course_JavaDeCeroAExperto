package datos;

import domain.*;
import java.sql.*;
import java.util.*;

import static datos.ConexionDB.*;

public class UsuarioDAO {
    public static final String SQL_INSERT = "INSERT INTO usuarios(nombre, password) VALUES(?, ?)";
    public static final String SQL_SELECT_ALL = "SELECT * FROM usuarios";
    public static final String SQL_SELECT_ONE = "SELECT * FROM usuarios WHERE id_usuario = ?";
    public static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, password = ? WHERE id_usuario = ?";
    public static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";
    public static final String SQL_DUMP = "DELETE FROM usuarios";
    
    
    //1.- Definimos el atributo de conexionTransaccional
    private Connection conexionTransaccional = null;
    
    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private int registros = 0;
    
    //2.- Instanciamos los cosntructores requeridos
    public UsuarioDAO(){
        
    }
    
    public UsuarioDAO(Connection conexionTransaccional){//Este se usara para menajar las transacciones
        this.conexionTransaccional = conexionTransaccional;
    }
    
    private void iniciar(String sql){
        try{
            //3.- Manejamos el instanciamiento segun la llamada 
            this.cn = this.conexionTransaccional != null ? this.conexionTransaccional : getConexion();
            this.ps = this.cn.prepareStatement(sql);
            this.registros = 0;              
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    //$.- Propagamos la exception de cierre a la capa antyeyrior para hacer rollback
    private void closeAll(){
        try{
            //Cerramjos primero el resultado si hubo por parte de un select
            if(this.rs != null){
                close(this.rs);
            }
            close(this.ps);
            
            //Cerramos la conexion solo si no es de tipo transaccional
            if(this.conexionTransaccional == null){
                close(this.cn);
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    //4.- Quitamos el manejo de exceptiones de esta capa y las propagamos firmandolas en el metodo
    public int insertarUsuario(Usuario usuario) throws SQLException{
        try{
            this.iniciar(SQL_INSERT);
            this.ps.setString(1, usuario.getUsuarioNombre());
            this.ps.setString(2, usuario.getUsuarioPassword());
            
            this.registros = ps.executeUpdate();//ejecutamos la instruccion
            System.out.println("Usuarios agregados: " + this.registros);
        } finally {
            this.closeAll();
        }
        
        return this.registros;
    }
    
    public List<Usuario> sleccionarTodosLosUsuarios()throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        
        try{
            this.iniciar(SQL_SELECT_ALL);
            this.rs = this.ps.executeQuery();
            
            while(this.rs.next()){
                Usuario usuario = new Usuario(
                        this.rs.getInt(1), 
                        this.rs.getString(2), 
                        this.rs.getString(3));
                
                usuarios.add(usuario);
            }
        } finally {
            this.closeAll();
        }
        
        return usuarios;
    }
    
    public Usuario seleccionarUnUsuario(Usuario usuario) throws SQLException {
        try {
            this.iniciar(SQL_SELECT_ONE);
            this.ps.setInt(1, usuario.getUsuarioId());
            this.rs = this.ps.executeQuery();
            this.rs.next();
            
            usuario.setUsuarioNombre(this.rs.getString(2));
            usuario.setUsuarioPassword(this.rs.getString(3));
            
        } finally {
            this.closeAll();
        }
        
        return usuario;
    }
    
    public int actualizarUsuario(Usuario usuario) throws SQLException {
        try {
            this.iniciar(SQL_UPDATE);
            this.ps.setString(1, usuario.getUsuarioNombre());
            this.ps.setString(2, usuario.getUsuarioPassword());
            this.ps.setInt(3, usuario.getUsuarioId());
            
            this.registros = ps.executeUpdate();  
            System.out.println("Usuarios actualizados: " + this.registros);          
        } finally {
            this.closeAll();
        }
        
        return this.registros;
    }
    
    public int eliminarUsuario(Usuario usuario) throws SQLException {
        try{
            this.iniciar(SQL_DELETE);
            this.ps.setInt(1, usuario.getUsuarioId());
            
            this.registros = this.ps.executeUpdate();
            System.out.println("Usuarios eliminados: " + this.registros);
        } finally {
            this.closeAll();
        }
        
        return this.registros;
    }
    
    public int eliminarRegistros() throws SQLException {
        try{
            this.iniciar(SQL_DUMP);
            this.registros = this.ps.executeUpdate();
            System.out.println("Usuarios eliminados: " + this.registros);
        } finally {
            this.closeAll();
        }
        
        return this.registros;
    }
}
