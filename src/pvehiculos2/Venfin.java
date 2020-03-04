
package pvehiculos2;

import java.io.Serializable;
import javax.persistence.*;
@Entity
public class Venfin implements Serializable{
    private static final long serialVersionUID = 1L; 
    @Id 
    int id;
    String dni  ;		
    String nomec ;
    String nomevh ; 
    int prezof; 

    public Venfin() {
    }

    public Venfin(int id, String dni, String nomec, String nomevh, int prezof) {
        this.id = id;
        this.dni = dni;
        this.nomec = nomec;
        this.nomevh = nomevh;
        this.prezof = prezof;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNomec() {
        return nomec;
    }

    public void setNomec(String nomec) {
        this.nomec = nomec;
    }

    public String getNomevh() {
        return nomevh;
    }

    public void setNomevh(String nomevh) {
        this.nomevh = nomevh;
    }

    public int getPrezof() {
        return prezof;
    }

    public void setPrezof(int prezof) {
        this.prezof = prezof;
    }

    @Override
    public String toString() {
        return "Venfin{" + "id=" + id + ", dni=" + dni + ", nomec=" + nomec + ", nomevh=" + nomevh + ", prezof=" + prezof + '}';
    }
    
}
