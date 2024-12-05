
package mx.edu.uaz.is.poo2.gb.gannetapp.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agroquimico implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String nombre;
    private String categoria;
    private String tipoPlaga;
    private int precio;
    private int alcance;
    private int capacidad;
     public Agroquimico() {
    }

    public Agroquimico(int id, String nombre, String categoria, String tipoPlaga, int precio, int alcance, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipoPlaga = tipoPlaga;
        this.precio = precio;
        this.alcance = alcance;
        this.capacidad = capacidad;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoPlaga() {
        return tipoPlaga;
    }

    public void setTipoPlaga(String tipoPlaga) {
        this.tipoPlaga = tipoPlaga;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
    
    
    
   
    
    
    

    
    
}
