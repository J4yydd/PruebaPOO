
package mx.edu.uaz.is.poo2.gb.gannetapp.igu.mensajes;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

//clase que muestra los mensajes de error
public class Mensajes {
    public void mostrarMensaje(String mensaje, String tipo, String titulo){
        JOptionPane optionPane = new JOptionPane(mensaje);
        if(tipo.equals("Info")){
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        }
        else if(tipo.equals("Error")){
             optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog =optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    
    }
    
}
