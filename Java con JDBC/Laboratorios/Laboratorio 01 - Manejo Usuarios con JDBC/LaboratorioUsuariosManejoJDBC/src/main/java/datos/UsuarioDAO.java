package datos;

import domain.*;
import java.sql.*;
import java.util.*;

import static datos.ConexionDB.*;

//Clase que accede a la DB usando objeto de dominio de proyecto Usuario
public class UsuarioDAO {
    public static final String SQL_INSERT = "INSERT INTO usuarios(nombre, password) VALUES(?, ?)";
    public static final String SQL_SELECT_ALL = "SELECT * FROM usuarios";
    public static final String SQL_SELECT_ONE = "SELECT * FROM usuarios WHERE id_usuario = ?";
    public static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, password = ? WHERE id_usuario = ?";
    public static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";
    public static final String SQL_DUMP = "DELETE FROM usuarios";
    
    private Connection cn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private int registros = 0;
    
    //Metodos para apertura de conexiones
    private void iniciar(String sql){//recibimos el query segun corresponda con la operacion
        try{
            this.cn = getConexion(); //Obtenemos la conexion con nuestra url y las credenciales de SQL
            this.ps = this.cn.prepareStatement(sql);//Preparamos la instruccion pasando el query
            this.registros = 0;              
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Metodo para cierre de conexiones
    private void closeAll(){
        try{
            //Cerramos el changarro
            close(this.cn);
            close(this.ps);
            if(this.rs != null){
                close(this.rs);
            }
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    //Metodo que inserta un nuevo registro en la tabla usuarios
    public int insertarUsuario(Usuario usuario){
        try{
            this.iniciar(SQL_INSERT);//Metodo de inicio
            this.ps.setString(1, usuario.getUsuarioNombre());//Agregamos los valores de los parametros
            this.ps.setString(2, usuario.getUsuarioPassword());
            
            this.registros = ps.executeUpdate();//ejecutamos la instruccion
            System.out.println("Usuarios agregados: " + this.registros);
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();//Metodo de cierre
        }
        
        return this.registros;
    }
    
    //metodo que se trae todos los registros de la tabla usuarios
    public List<Usuario> sleccionarTodosLosUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        
        try{
            this.iniciar(SQL_SELECT_ALL);
            this.rs = this.ps.executeQuery();
            
            while(this.rs.next()){
                //Mapeamos un objeto con los resultados obtenidos
                Usuario usuario = new Usuario(
                        this.rs.getInt(1), 
                        this.rs.getString(2), 
                        this.rs.getString(3));
                
                usuarios.add(usuario);//Lo agregamos a la lista
            }
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
        
        return usuarios;
    }
    
    //metodo que se trae un registro especifico de la tabla de usuarios
    public Usuario seleccionarUnUsuario(Usuario usuario) {
        try {
            this.iniciar(SQL_SELECT_ONE);
            this.ps.setInt(1, usuario.getUsuarioId());
            this.rs = this.ps.executeQuery();
            this.rs.next();//Para posicionarnos en el primer registro encontrado
            
            //Sobreescritura de parametro entrante
                //Solo sobreescribimos los valores nullos hasta ahora
            usuario.setUsuarioNombre(this.rs.getString(2));
            usuario.setUsuarioPassword(this.rs.getString(3));
            
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            this.closeAll();
        }
        
        return usuario;
    }
    
    //Metodo que actualiza un usuario
    public int actualizarUsuario(Usuario usuario){
        try {
            this.iniciar(SQL_UPDATE);
            //es el orden de los parametros en la query, al final en el WHERE va el ID
            this.ps.setString(1, usuario.getUsuarioNombre());
            this.ps.setString(2, usuario.getUsuarioPassword());
            this.ps.setInt(3, usuario.getUsuarioId());
            
            this.registros = ps.executeUpdate();  
            System.out.println("Usuarios actualizados: " + this.registros);          
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            this.closeAll();
        }
        
        return this.registros;
    }
    
    //metodo que elimina un usuario
    public int eliminarUsuario(Usuario usuario){
        try{
            this.iniciar(SQL_DELETE);
            this.ps.setInt(1, usuario.getUsuarioId());
            
            this.registros = this.ps.executeUpdate();
            System.out.println("Usuarios eliminados: " + this.registros);
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            this.closeAll();
        }
        
        return this.registros;
    }
    
    //meotdo que elimina todos los registros de la tabla
    public int eliminarRegistros(){
        try{
            this.iniciar(SQL_DUMP);
            this.registros = this.ps.executeUpdate();
            System.out.println("Usuarios eliminados: " + this.registros);
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            this.closeAll();
        }
        
        return this.registros;
    }
}
