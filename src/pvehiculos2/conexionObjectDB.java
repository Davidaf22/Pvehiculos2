package pvehiculos2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class conexionObjectDB {
    
    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    public static void  conectar_a_servidor(){
        emf = Persistence.createEntityManagerFactory("objectdb/db/vehicli.odb");
        em = emf.createEntityManager();
    } 
    
    public static void insertFinalveh(Venfin venfin){
        
        em.getTransaction().begin();
        em.persist(venfin);
        em.getTransaction().commit();
        
        System.out.println("Objeto insetado");
    }    
    
    public static void cerrar_conexion(){
        em.close();
        emf.close();
    }   
}
