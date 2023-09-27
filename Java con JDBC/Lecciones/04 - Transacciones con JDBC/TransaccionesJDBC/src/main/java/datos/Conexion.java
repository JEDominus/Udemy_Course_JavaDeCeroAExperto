package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&iseTomezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    
    //Metodo para hacer la conexion con la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
    
    //sobrecargar el metodo de close
    public static void close(ResultSet resultSet) throws SQLException {//Reportamos las exxceptions que puedan surgir
        resultSet.close();
    }
    
    public static void close(Statement statement) throws SQLException {
        statement.close();
    }
    
    public static void close(PreparedStatement statement) throws SQLException {
        statement.close();
    }
    
    public static void close(Connection connection) throws SQLException {
        connection.close();
    }
}
