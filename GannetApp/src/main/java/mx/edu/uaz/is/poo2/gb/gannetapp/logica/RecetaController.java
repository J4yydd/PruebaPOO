
package mx.edu.uaz.is.poo2.gb.gannetapp.logica;

import java.util.List;
import java.util.Random;
import mx.edu.uaz.is.poo2.gb.gannetapp.logica.Agroquimico;
import mx.edu.uaz.is.poo2.gb.gannetapp.logica.Controladora;
public class RecetaController {
    private Controladora controladora;

    // Constructor para inicializar la controladora
    public RecetaController() {
        controladora = new Controladora();
    }

    // Método para traer los agroquímicos de la base de datos
    public List<Agroquimico> traerAgroquimicos() {
        return controladora.traerAgroquimicos();
    }

    // Método para obtener un agroquímico aleatorio que coincida con la categoría y tipo de plaga
    public Agroquimico obtenerAgroquimicoAleatorio(String categoria, String tipoPlaga) {
        List<Agroquimico> agroquimicos = traerAgroquimicos();  // Traemos todos los agroquímicos
        Random random = new Random();
        
        // Buscar agroquímicos que coincidan con la categoría y tipo de plaga
        for (Agroquimico agro : agroquimicos) {
            if (agro.getCategoria().equalsIgnoreCase(categoria) && agro.getTipoPlaga().equalsIgnoreCase(tipoPlaga)) {
                return agro;  // Devolvemos el primer agroquímico que coincida con los datos llenados
            }
        }
        return null;  // Si no se encuentra
    }

    // Método para calcular la cantidad de producto que se necesita
    public int calcularCantidadProducto(double hectareas, Agroquimico agroquimico) {
        return (int) (hectareas * agroquimico.getAlcance());  // Hectáreas multiplicadas por el alcance
    }

    // Método para calcular el precio total
    public int calcularPrecioTotal(int cantidadProducto, Agroquimico agroquimico) {
        return cantidadProducto * agroquimico.getPrecio();  // Cantidad multiplicada por el precio 
    }
    
}
