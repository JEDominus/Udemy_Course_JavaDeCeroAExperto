package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;

public class TestLaboratorioUsuariosManejoJDBC {
    public static void main(String[] args) {
        //crearUsuarioNuevo();
        //traerTodosLosUsuario();
        //traerUnUsuario();
        //actualizarUsuario();
        //eliminarUnUsuario();
        eliminarTodosLosRegistros();
    }

    public static void crearUsuarioNuevo(){
        UsuarioDAO usuarioDao = new UsuarioDAO(); 
        Usuario usuario = new Usuario("javier", "a89x7987sa");
        int resultado = usuarioDao.insertarUsuario(usuario);
    }
    
    public static void traerTodosLosUsuario(){
        UsuarioDAO usuarioDao = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDao.sleccionarTodosLosUsuarios();
        
        System.out.println("Usuarios actuales en la base de datos: " + usuarios.size());
        usuarios.forEach(usuario -> {
            System.out.println(usuario.getUsuarioId() + ", " + usuario.getUsuarioNombre() + ", " + usuario.getUsuarioPassword()); 
        });
    }
    
    public static void traerUnUsuario(){
        UsuarioDAO usuarioDao = new UsuarioDAO(); 
        Usuario usuario = new Usuario(5);        
        usuario = usuarioDao.seleccionarUnUsuario(usuario);
        
        System.out.println("Usuario encontrado!");
        System.out.println(usuario.getUsuarioNombre() + ", " + usuario.getUsuarioPassword()); 
    }
    
    public static void actualizarUsuario(){
        UsuarioDAO usuarioDao = new UsuarioDAO(); 
        Usuario usuario = new Usuario(1, "enelida", "a8iausfy897sfa");
        usuarioDao.actualizarUsuario(usuario);
        System.out.println("Usuario con id: " + usuario.getUsuarioId() + " actualizado");
    }
    
    public static void eliminarUnUsuario(){
        UsuarioDAO usuarioDao = new UsuarioDAO(); 
        Usuario usuario = new Usuario(1);        
        usuarioDao.eliminarUsuario(usuario);
        System.out.println("Usuario eliminado!");
    }
    
    public static void eliminarTodosLosRegistros(){
        UsuarioDAO usuarioDao = new UsuarioDAO(); 
        System.out.println("Registros eliminados");
    }
}
