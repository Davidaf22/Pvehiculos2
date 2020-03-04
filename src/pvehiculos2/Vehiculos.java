
package pvehiculos2;
/**
 *
 * @author David Alonso
 */
public class Vehiculos {
    
    public String nomveh;
    public int precioorixe;
    public int anomatricula;
    
    public Vehiculos(){}
    
    public Vehiculos(String nome, int precio, int ano){  
        this.nomveh=nome;
        this.precioorixe=precio;
        this.anomatricula=ano;
    }

    public String getNomveh() {
        return nomveh;
    }

    public void setNomveh(String nomveh) {
        this.nomveh = nomveh;
    }

    public int getPrecioorixe() {
        return precioorixe;
    }

    public void setPrecioorixe(int precioorixe) {
        this.precioorixe = precioorixe;
    }

    public int getAnomatricula() {
        return anomatricula;
    }

    public void setAnomatricula(int anomatricula) {
        this.anomatricula = anomatricula;
    }

    @Override
    public String toString() {
        return "Vehiculos{" + "nomveh=" + nomveh + ", precioorixe=" + precioorixe + ", anomatricula=" + anomatricula + '}';
    }
}
