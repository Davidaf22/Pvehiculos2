package pvehiculos2;
/**
 *
 * @author David Alonso
 */
public class Clientes {
    
    public String nombre;
    public int nCompras;
    
    public Clientes(){}
    public Clientes(String nombre, int nCompras){
        this.nombre=nombre;
        this.nCompras=nCompras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getnCompras() {
        return nCompras;
    }

    public void setnCompras(int nCompras) {
        this.nCompras = nCompras;
    }

    @Override
    public String toString() {
        return "Clientes{" + "nombre=" + nombre + ", nCompras=" + nCompras + '}';
    }
}
