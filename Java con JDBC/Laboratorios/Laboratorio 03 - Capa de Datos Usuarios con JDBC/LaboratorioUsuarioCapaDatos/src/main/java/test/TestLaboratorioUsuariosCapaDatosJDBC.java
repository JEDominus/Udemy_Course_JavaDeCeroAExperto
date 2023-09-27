package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.List;

public class TestLaboratorioUsuariosCapaDatosJDBC {
    public static void main(String[] args) {
        implementacionCapaDeDatos();
    }
    
    public static void implementacionCapaDeDatos(){
        Connection conexion = null;
        
        try {
            conexion = ConexionDB.getConexion();
            conexion.setAutoCommit(false);
            
            //5.- Creamos la variable de tipo interfaz con la implementacion como instancia y hacemos un select
            IUsuarioDAO usuarioDao = new UsuarioDAO(conexion);
            //6.- Llamamos a la capa de datos para traer los usuarios
            List<UsuarioDto> usuarios = usuarioDao.sleccionarTodosLosUsuarios();
            //7.- Iteramos e imprimios cada usuario en la consola
            usuarios.forEach(usuario -> {
                System.out.println(usuarios);
            });
            //8.- El commit no es necesario ya que no se esta alterando la base de datos en esta transaccion
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
