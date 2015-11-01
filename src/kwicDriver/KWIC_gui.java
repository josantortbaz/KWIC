/*
 * Clase para probar el GUI del proyecto.
 */
package kwicDriver;

import vistas.VistaKWIC;
import java.util.ArrayList;
/**
 *
 * @author Jortizbazaga
 */
public class KWIC_gui {
    
    public static void main(String[] args) {
        ArrayList<String> listaIdiomas = new ArrayList<String>();
        listaIdiomas.add("Español");
        listaIdiomas.add("Inglés");
        VistaKWIC vista = new VistaKWIC(listaIdiomas);
    }
}
