
package mx.edu.uaz.is.poo2.gb.gannetapp.logica;

import java.util.List;
import mx.edu.uaz.is.poo2.gb.gannetapp.persistencia.exceptions.ControladoraPersistencia;


public class Controladora {
    //creamos unsa instancia de la controladoraPersistencia, la cual se encarga de interactuar con la BD
     ControladoraPersistencia controlPersis = new ControladoraPersistencia();
//metodo para agregar un agroquimico, se crea el objeto agroquimico con los datos proporcionados y es mandado a la capa de persistencia
    public void agregarAgroquimico(String nombre, String categoria, String tipoPlaga, int precio, int alcance, int capacidad) {
        
        Agroquimico agro = new Agroquimico();
        agro.setNombre(nombre);
        agro.setCategoria(categoria);
        agro.setTipoPlaga(tipoPlaga);
        agro.setPrecio(precio);
        agro.setAlcance(alcance);
        agro.setCapacidad(capacidad);
           // Manda el objeto a la capa de persistencia para guardarlo en la base de datos
            controlPersis.agregarAgroquimico(agro);
    }

  
//metodo para obtener todos los agroquimicos guardados
     // Devuelve una lista de objetos Agroquimico obtenidos de la capa de persistencia.
    public List<Agroquimico> traerAgroquimicos() {
              return controlPersis.traerAgroquimicos();

    }
 
     // Método para eliminar un agroquímico de la BD.
    
    public void borrarAgroquimico(int idAgro) {
         //la logica le tiene que mandar id a la persistencia para eliminar el agroquimico
            controlPersis.borrarAgroquimico(idAgro);
    }
//metodo para traer un agroquimico por su id
    public Agroquimico traerAgroquimico(int idAgro) {
          // Llama a la capa de persistencia para obtener un agroquímico por su ID
        return controlPersis.traerAgroquimico(idAgro);

    }
//metodo para modificar un agroquimico
    public void modificarAgroquimico(Agroquimico agro, String nombre, String categoria, String tipoPlaga, int precio, int alcance, int capacidad) {
   // Actualiza los atributos del agroquímico con los nuevos datos   
        agro.setNombre(nombre);
        agro.setCategoria(categoria);
        agro.setTipoPlaga(tipoPlaga);
        agro.setPrecio(precio);
        agro.setAlcance(alcance);
        agro.setCapacidad(capacidad);
        // le pido a la persistensia que lo modifique
        controlPersis.modificarAgroquimico(agro);
       
    }
    
    
}
