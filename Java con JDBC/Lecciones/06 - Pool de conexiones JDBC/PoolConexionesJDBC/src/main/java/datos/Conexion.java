package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&iseTomezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    
    //1.- Ahora debemos crear un nuevo emtodo que se encarge de inicializar el objeto que gestiona el pool de conexiones
        //Este mismo metodo lo llamaremos para obtener conexiones a la base de datos
    public static DataSource getDataSource(){
        BasicDataSource dataSource = new BasicDataSource();//clase de dependencia apache commons
        
        //2.- Ahora configuramos el pool de conexiones
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        //3.- definimos el tamaño del pool.. Hay que ser cuidadoso ya que consume muchos recursos
        dataSource.setInitialSize(5);
        
        //4.- Retornamos el objeto dataSource
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException {
        //5.- En lugar de usar DriverManager, usaremos el metodo getDataSource para obtener la conexion (El metodod e arriba)
            //Ya no hay que configurar parametros porque se configuraron en el metodo de ariba
            //Esto retornara el pool y podremos llamar a la conexion 
        return getDataSource().getConnection();
    }
    
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
