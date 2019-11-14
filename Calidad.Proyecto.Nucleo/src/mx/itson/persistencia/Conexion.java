
package mx.itson.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    
    

 private static Connection conexion;
    private static String stringConexion = "jdbc:mysql://localhost:3306/pruebas?useLegacyDatetimeCode=false&serverTimezone=UTC";    
    private static String driver = "com.mysql.cj.jdbc.Driver";   
    private static String usuario = "root";   
    private static String password = "root";

    /**
     * Obtiene una conexión activa a la base de datos en MySQL con los parámetros señalados.
     * @return Conexión activa con los atributos necesarios para realizar queries. Si no es posible conectar, retorna null.
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            try {
                conexion = DriverManager.getConnection(stringConexion, usuario, password);
            } catch (SQLException ex) {
                System.out.println("Ocurrió un error al conectar: " + ex.getMessage()); 
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Ocurrió un error: " + ex.getMessage()); 
        }
        return conexion;
    
    }
}