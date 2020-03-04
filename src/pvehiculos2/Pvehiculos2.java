package pvehiculos2;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author David Alonso
 */
public class Pvehiculos2 {

    public static void main(String[] args) throws SQLException {
        conexionOrcacle.getConexion();
        ResultSet rs = conexionOrcacle.sacarDatos();
        
        while(rs.next()) {
            
            int id = rs.getInt("id");
            String dni = rs.getString("dni");
            
            java.sql.Struct x = (java.sql.Struct) rs.getObject("vehf");
            Object[] campos = x.getAttributes();
            String codveh = (String) campos[0];
            java.math.BigDecimal tasas = (java.math.BigDecimal) campos[1];
            
            conexionMongo.conectar_a_servidor();
            conexionMongo.conectar_a_base("basevehiculos");
            conexionMongo.conectar_a_unha_colecion("clientes");
            Clientes cliente = conexionMongo.sacarNome(dni);
            conexionMongo.conectar_a_unha_colecion("vehiculos");
            Vehiculos vehiculo = conexionMongo.sacarVeh(codveh);
            conexionMongo.cerrar_conexion();
                 
            int pf = 0;
            if (cliente.getnCompras() == 0) {
                pf = vehiculo.getPrecioorixe() - ((2019 - vehiculo.getAnomatricula()) * 500) + tasas.intValue();
            } else {
                pf = vehiculo.getPrecioorixe() - ((2019 - vehiculo.getAnomatricula()) * 500) - 500 + tasas.intValue();
            }
            
            Venfin venfin = new Venfin(id,dni,cliente.getNombre(),vehiculo.getNomveh(),pf);
            System.out.println(venfin.toString());
            
            conexionObjectDB.conectar_a_servidor();
            conexionObjectDB.insertFinalveh(venfin);
            conexionObjectDB.cerrar_conexion();
        }  
        conexionOrcacle.closeConexion();
    }
    
}
