
package mx.edu.uaz.is.poo2.gb.gannetapp.persistencia.exceptions;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.edu.uaz.is.poo2.gb.gannetapp.logica.Agroquimico;
import mx.edu.uaz.is.poo2.gb.gannetapp.persistencia.exceptions.exceptions.NonexistentEntityException;


public class ControladoraPersistencia {
    // Crea un objeto de la clase AgroquimicoJpaController para realizar las operaciones  del CRUD
   AgroquimicoJpaController agroJpa = new AgroquimicoJpaController();
     //Método para agregar un agroquímico a la base de datos.
    public void agregarAgroquimico(Agroquimico agro) {
        agroJpa.create(agro);
    }
//  Método para traer todos los agroquímicos de la base de datos.

    public List<Agroquimico> traerAgroquimicos() {
      
       return agroJpa.findAgroquimicoEntities();
        
        
    }
// Método para borrar un agroquímico por su ID.
    public void borrarAgroquimico(int idAgro) {
        //usamos un ty o catch por si el id que no existe, cuando ejecute el distroy va a captar esa exepcion o detener el proceso
        try {
            
            agroJpa.destroy(idAgro);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
// Método para traer un agroquímico por su ID.
    public Agroquimico traerAgroquimico(int idAgro) {
        
       return agroJpa.findAgroquimico(idAgro);

    }
//Método para modificar un agroquímico existente.
    public void modificarAgroquimico(Agroquimico agro) {

        try {
            agroJpa.edit(agro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
