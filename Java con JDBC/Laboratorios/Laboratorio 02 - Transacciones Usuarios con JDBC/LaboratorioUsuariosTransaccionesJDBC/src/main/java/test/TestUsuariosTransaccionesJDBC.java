package test;

import datos.*;
import domain.*;
import java.sql.*;

public class TestUsuariosTransaccionesJDBC {
    public static void main(String[] args) {
        actualizarEInsertar();
    }
    
    public static void actualizarEInsertar(){
        //1.- Deifnimos la conexion fuera del bloque para llamar el rollback en el catch
        Connection conexion = null;
        
        try {
            //2.- Creamos conexion y desactivamos el autocommit
            conexion = ConexionDB.getConexion();
            conexion.setAutoCommit(false);
            
            //3.- Instanciamos el dao con la conexion transaccional usando el constructor parametrizado creado
            UsuarioDAO usuarioDao = new UsuarioDAO(conexion);
            
            //4.- procedemos con las sentencias que deseemos para esta transaccion
                //4.1.- Actualizaremos un registro
            Usuario usuarioCambio = new Usuario(14, "Javier", "000");
            usuarioDao.actualizarUsuario(usuarioCambio);
            
                //4.2.- insertamos un nuevo usuario
                    //4.2.1.- Hacemos tronar la query para que se ejecute rollback
            //Usuario usuarioNuevo = new Usuario("Meliodaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaas", "300");
                    //4.2.2.- Ejecutamos el bloque transaccional correctamente
            Usuario usuarioNuevo = new Usuario("Meliodas", "300");
            usuarioDao.insertarUsuario(usuarioNuevo);
            
            //5.- Hacemos commit
            conexion.commit();
        } catch(SQLException e) {
            e.printStackTrace();
            
            try{
                System.out.println("Ejecutando Rollback de la transaccion");
                conexion.rollback();
            } catch(SQLException e2) {
                e2.printStackTrace(System.out);
            }
        }
    }
}
