package pvehiculos2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oracle
 */
public class conexionOrcacle {
    
    public static Connection conexion=null;
     
     public static Connection getConexion() throws SQLException{
        String usuario = "hr";
        String password = "hr";
        String host = "localhost"; 
        String puerto = "1521";
        String sid = "orcl";
        String ulrjdbc = "jdbc:oracle:thin:" + usuario + "/" + password + "@" + host + ":" + puerto + ":" + sid;  
           
            conexion = DriverManager.getConnection(ulrjdbc);
            return conexion;
        }
     
     public static void closeConexion() throws SQLException {
         
        conexion.close();
        
      }
     
     public static ResultSet sacarDatos() throws SQLException{
        Connection con = conexion;
         
        PreparedStatement stmt = con.prepareStatement("Select * from vendas");
                
        ResultSet rs = stmt.executeQuery();
        
        return rs;
     }    
}
