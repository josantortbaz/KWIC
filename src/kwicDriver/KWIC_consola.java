/*
 * Clase para realizar pruebas del proyecto KWIC para consola
 */
package kwicDriver;

import KWIC.KWIC;

/**
 *
 * @author Jortizbazaga
 */
public class KWIC_consola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto =  "El color del dinero\n" +
                        "Color púrpura\n" +
                        "Misión: imposible\n" +
                        "La misión\n" +
                        "La rosa púrpura del Cairo\n" +
                        "El dinero llama al dinero\n" +
                        "La rosa del azafrán\n" +
                        "El nombre de la rosa\n" +
                        "Toma el dinero y corre";
        String noSig = "al el la los las del un una unos unas y o a ante bajo cabe con "
                    + "contra de desde en entre hacia hasta para por según sin "
                    + "sobre tras si no";
        // Creamos una instancia de KWIC
        KWIC kwic = new KWIC(texto, noSig);
        System.out.println(kwic);
    }
    
}
