package datos;

import domain.*;
import java.sql.*;
import java.util.*;

import static datos.ConexionDB.*;

//3.- Implementamos la interfaz recien creada
public class UsuarioDAO implements IUsuarioDAO {
    public static final String SQL_INSERT = "INSERT INTO usuarios(nombre, password) VALUES(?, ?)";
    public static final String SQL_SELECT_ALL = "SELECT * FROM usuarios";
    public static final String SQL_SELECT_ONE = "SELECT * FROM usuarios WHERE id_usuario = ?";
    public static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, password = ? WHERE id_usuario = ?";
    public static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";
    public static final String SQL_DUMP = "DELETE FROM usuarios";
    
    
    private Connection conexionTransaccional = null;
    
    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private int registros = 0;
    
    public UsuarioDAO(){
        
    }
    
    public UsuarioDAO(Connection conexionTransaccional){
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
    
    private void closeAll(){
        try{
            if(this.rs != null){
                close(this.rs);
            }
            close(this.ps);
            
            if(this.conexionTransaccional == null){
                close(this.cn);
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    @Override //4.- Implementamos los metodos de la itnefaz
    public int insertarUsuario(UsuarioDto usuario) throws SQLException {
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
    
    @Override
    public List<UsuarioDto> sleccionarTodosLosUsuarios() throws SQLException {
        List<UsuarioDto> usuarios = new ArrayList<>();
        
        try{
            this.iniciar(SQL_SELECT_ALL);
            this.rs = this.ps.executeQuery();
            
            while(this.rs.next()){
                UsuarioDto usuario = new UsuarioDto(
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
    
    @Override
    public UsuarioDto seleccionarUnUsuario(UsuarioDto usuario) throws SQLException {
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
    
    @Override
    public int actualizarUsuario(UsuarioDto usuario) throws SQLException {
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
    
    @Override
    public int eliminarUsuario(UsuarioDto usuario) throws SQLException {
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
    
    @Override
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
