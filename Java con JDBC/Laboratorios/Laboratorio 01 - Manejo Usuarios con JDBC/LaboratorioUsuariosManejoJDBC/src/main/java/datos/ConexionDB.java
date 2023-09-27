package datos;

import java.sql.*;

//creamos la clase de conexion con la Base de datos
public class ConexionDB {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&iseTomezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String USER_NAME = "root";
    public static final String USER_PASSWORD = "admin";
    
    //Creamos metodo para retornar la conexion con la base de datos como objeto
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER_NAME, USER_PASSWORD);
    }
    
    //Sobrecarga de metodos
    public static void close(Connection con) throws SQLException {//firmamos para cachar en la clase que use estos emtodos
        con.close();
    }
    
    public static void close(PreparedStatement stm) throws SQLException {
        stm.close();
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
}
