
package Proyecto;
import UI.CargaRed_1;


/**
 *Clase Main que permite el inicio del proyecto.
 */
public class Main{
    /**
     * Inicia el proyecto.
     * @param args 
     */
    public static void main(String[] args) {
        CargaRed_1 ui  = new CargaRed_1();
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
    }
    
}
