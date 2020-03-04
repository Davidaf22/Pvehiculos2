
package pvehiculos2;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import org.bson.Document;


public class conexionMongo {

    public static MongoClient client;
    public static MongoDatabase database;
    public static MongoCollection<Document> colecion;


    public static void  conectar_a_servidor(){
        client = new MongoClient("localhost",27017);
    } 
    public static void  conectar_a_base(String nomebase){
        database = client.getDatabase(nomebase);
    }
    public static void  conectar_a_unha_colecion(String coleccion){
        colecion = database.getCollection(coleccion);
    }
    
    public static void cerrar_conexion(){
        client.close();
    }
    
    public static Clientes sacarNome(String dni){
        
        Clientes cliente = new Clientes();
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", dni);
        
        FindIterable<Document> cursornovo = colecion.find(query);
        MongoCursor<Document> iterator = cursornovo.iterator();
        while (iterator.hasNext()){
            Document next = iterator.next();
                String nome = next.getString("nomec");
                double nCompras = next.getDouble("ncompras");
                
                int nCompras2 = (int)nCompras;
                
                cliente.setNombre(nome);
                cliente.setnCompras(nCompras2);
            }
        return cliente;      
    }
    
    public static Vehiculos sacarVeh(String codveh){
        
        Vehiculos vehiculo = new Vehiculos();
        
        BasicDBObject query = new BasicDBObject();
        query.put("_id", codveh);
        
        FindIterable<Document> cursornovo = colecion.find(query);
        MongoCursor<Document> iterator = cursornovo.iterator();
        while (iterator.hasNext()){
            Document next = iterator.next();
                String nomeveh = next.getString("nomveh");
                double precio = next.getDouble("prezoorixe");
                double ano = next.getDouble("anomatricula");
                
                int precio2 = (int)precio;
                int ano2 = (int)ano;
                
                vehiculo.setNomveh(nomeveh);
                vehiculo.setPrecioorixe(precio2);
                vehiculo.setAnomatricula(ano2);
            }
        return vehiculo;      
    }
}
