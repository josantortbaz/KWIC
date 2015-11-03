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
public class ControladorIdiomas implements ActionListener {

    public static final String ACCION_COMBO_IDIOMA = "accionComboIdioma";

    private VistaKWIC vista;    // Vista que vamos a controlar.
    private Locale localizacion;   // Ubicación para saber que idioma tenemos que usar. 

    /**
     * Constructor que creará la ventana y le pasará los idiomas que se van a
     * controlar.
     */
    public ControladorIdiomas(VistaKWIC vista) {
        this.localizacion = Locale.getDefault();
        this.vista = vista;
    }

    /**
     * Método que leerá los idiomas de los ficheros de configuración.
     *
     * @return lista de idiomas
     */
    public List<String> getIdiomas() {
        List<String> idiomas = new ArrayList();
        for (Locale loc : Locale.getAvailableLocales()) {
            idiomas.add(loc.getDisplayCountry() + " " + loc.getDisplayLanguage());
        }
        return idiomas;
    }

    /**
     * Método para devolver la localización actual de la aplicación.
     */
    public Locale getLocalizacion() {
        return localizacion;
    }

    public String getTextoDeElemento(String elemento) {
        String retorno = "";
        try {
            ResourceBundle rb = ResourceBundle.getBundle("i18n/idioma", this.localizacion);
            retorno = rb.getString(elemento);
        } catch (Exception e) {
            System.out.println("No se encontró el idioma descrito.");
        }
        return retorno;
    }

    /**
     * Método que controlará los eventos que sucedan en la ventana que
     * controlamos.
     *
     * @param e evento acontecido.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.ACCION_COMBO_IDIOMA)) {
            String idiomaSeleccionado = this.vista.getIdiomaCombo();
            String idioma = "";
            String pais = "";
            for (Locale loc : Locale.getAvailableLocales()) {
                String id = (loc.getDisplayCountry() + " " + loc.getDisplayLanguage());
                if (id.equals(idiomaSeleccionado)) {
                    idioma = loc.getISO3Language();
                    pais = loc.getISO3Country();
                }
            }
            System.out.println(pais + "_" + idioma);
            System.out.println(idiomaSeleccionado);
            this.localizacion = new Locale(idioma,pais);
            this.vista.repaint();
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}
