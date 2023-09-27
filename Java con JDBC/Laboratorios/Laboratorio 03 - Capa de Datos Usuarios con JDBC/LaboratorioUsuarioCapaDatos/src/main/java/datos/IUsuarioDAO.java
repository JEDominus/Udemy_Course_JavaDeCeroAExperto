package datos;

import domain.UsuarioDto;
import java.sql.SQLException;
import java.util.List;

//2.- Creamos la interfaz que se implementara en UsuariosDao
public interface IUsuarioDAO {
    
    int insertarUsuario(UsuarioDto usuario) throws SQLException;
    
    List<UsuarioDto> sleccionarTodosLosUsuarios() throws SQLException;
    
    UsuarioDto seleccionarUnUsuario(UsuarioDto usuario) throws SQLException;
    
    int actualizarUsuario(UsuarioDto usuario) throws SQLException;
    
    int eliminarUsuario(UsuarioDto usuario) throws SQLException;
    
    int eliminarRegistros() throws SQLException;
}
