package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    //Comenzamos hacienfo constante los valores de la url y las credenciales
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&iseTomezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    
    //Ahora creamos un metodo para hacer la conexion con la base de datos
    public static Connection getConnection() throws SQLException {
        //Esto retorna la conbexion con la abse de datos
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }
    
    //vamos a sobrecargar el metodo de close
    public static void close(ResultSet resultSet) throws SQLException {//Reportamos las exxceptions que puedan surgir
        resultSet.close();
    }
    
    public static void close(Statement statement) throws SQLException {
        statement.close();
    }
    
    //prepareStatment es una clase con mayor perfonmance, lo agregamos porque la usaremos ams 
    public static void close(PreparedStatement statement) throws SQLException {
        statement.close();
    }
    
    public static void close(Connection connection) throws SQLException {
        connection.close();
    }
}
