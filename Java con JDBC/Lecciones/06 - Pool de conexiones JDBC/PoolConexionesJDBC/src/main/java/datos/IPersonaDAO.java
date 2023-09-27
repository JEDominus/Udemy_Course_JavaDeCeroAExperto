package datos;

import domain.PersonaDto;
import java.sql.SQLException;
import java.util.List;

//Se ha creado esta interfaz para que la implemente PersonDAO
public interface IPersonaDAO {
    
    List<PersonaDto>  seleccionarTodo() throws SQLException;
    
    int insertarPersona(PersonaDto persona) throws SQLException;
    
    int actualizarRegistro(PersonaDto persona) throws SQLException;
    
    int eliminarRegistro(PersonaDto persona) throws SQLException;
}
