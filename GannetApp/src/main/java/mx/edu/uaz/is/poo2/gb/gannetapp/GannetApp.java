

package mx.edu.uaz.is.poo2.gb.gannetapp;

import mx.edu.uaz.is.poo2.gb.gannetapp.igu.Principal;


public class GannetApp {
//llamamos y hacemos que sea visible nuestra IGU
    public static void main(String[] args) {
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
    }
}
