package datos;

import java.sql.*;

public class ConexionDB {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&iseTomezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String USER_NAME = "root";
    public static final String USER_PASSWORD = "admin";
    
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER_NAME, USER_PASSWORD);
    }
    
    public static void close(Connection con) throws SQLException {
        con.close();
    }
    
    public static void close(PreparedStatement stm) throws SQLException {
        stm.close();
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
}
