/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import KWIC.KWIC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.VistaKWIC;

/**
 *
 * @author josea
 */
public class ControladorKWIC implements ActionListener {

    // Acciones que vamos a manejar en este controlador:
    public static final String ACCION_BOTON_INSERTAR_NS = "accionBotonInsertarNS";
    public static final String ACCION_BOTON_CALCULAR_KWIC = "accionBotonCalcularKwic";

    // Vista que vamos a controlar:
    private VistaKWIC vista;

    // KWIC que vamos a crear, modificar y guardar:
    private KWIC kwic;

    /**
     * Contructor que recive la vista a controlar y crea el kwic que vamos a
     * gestionar:
     *
     * @param v
     */
    public ControladorKWIC(VistaKWIC v) {
        this.vista = v;
        kwic = new KWIC();
    }

    /**
     * Método que recogerá y controlará los eventos que sucedan en las pestañas
     * de la vista:
     *
     * @param e evento acontecido
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.ACCION_BOTON_INSERTAR_NS)) {
            botonInsertarNSPulsado();
        } else if (e.getActionCommand().equals(this.ACCION_BOTON_CALCULAR_KWIC)) {
            botonCalcularKwicPulsado();
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private void botonInsertarNSPulsado() {
        String noSignificativas = this.vista.getPalabraNS();
        this.kwic.setNoSignificativas(noSignificativas);
        String resultado = this.kwic.getNoSignificativasString();
        this.vista.setPalabrasNS(resultado);
    }
    
    private void botonCalcularKwicPulsado(){
        String titulos = this.vista.getTitulos();
        this.kwic.setPeliculas(titulos);
        String resultado = this.kwic.toString();    
        System.out.println(resultado);
        this.vista.setKWIC(resultado);
    }

}
