/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.*;
import java.util.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import vistas.VistaKWIC;

/**
 * @version 0.1
 * @author jortizbazaga
 */
public class MainControlador implements ActionListener {
    
    public static final String ELEMENTO_COMBO_IDIOMA = "elementoComboIdioma",
            ACCION_COMBO_IDIOMA = "accionComboIdioma";

    private VistaKWIC vista;    // Vista que vamos a controlar.
    private Locale localizacion;   // Ubicación para saber que idioma tenemos que usar. 
    private Map<String,String> elementosAcciones; // Mapa con el elemento y la acción definidos en este controlador.
    
    /**
     * Constructor que creará la ventana y le pasará los idiomas que se van a controlar.
     */
    public MainControlador (VistaKWIC vista) {
        this.localizacion = Locale.getDefault();       
        generaMapaElementosAcciones();
        this.vista = vista;
    }
    
    /**
     * Método para generar el mapa de acciones por elementos.
     */
    private void generaMapaElementosAcciones(){
        this.elementosAcciones = new HashMap<String,String>();
        this.elementosAcciones.put(this.ELEMENTO_COMBO_IDIOMA, this.ACCION_COMBO_IDIOMA);
    }
    
    /**
     * Método que leerá los idiomas de los ficheros de configuración.
     * @return lista de idiomas
     */
    public List<String> getIdiomas(){
        List<String> idiomas = new ArrayList();
        for (Locale loc: Locale.getAvailableLocales()){
            idiomas.add(loc.getDisplayLanguage());
        }
        return idiomas;
    }
    
    /**
     * Método para devolver la localización actual de la aplicación.
     */
    public Locale getLocalizacion(){
        return localizacion;
    }
    
    public Map<String,String> getMapaElementosAcciones() {
        return this.elementosAcciones;
    }
    
    /**
     * Método que controlará los eventos que sucedan en la ventana que controlamos.
     * @param e evento acontecido.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
