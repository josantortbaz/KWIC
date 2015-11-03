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

    public static final String ACCION_BOTON_INSERTAR_NS = "accionBotonInsertarNS";
    public static final String ACCION_BOTON_CALCULAR_KWIC = "accionBotonCalcularKwic";
    
    private VistaKWIC vista;
    private KWIC kwic;
    
    public ControladorKWIC (VistaKWIC v) {
        this.vista = v;
        kwic = new KWIC();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.ACCION_BOTON_INSERTAR_NS)){
            String noSignificativas = this.vista.getPalabraNS();
            this.kwic.setNoSignificativas(noSignificativas);
            String resultado = this.kwic.getNoSignificativasString();
            this.vista.setPalabrasNS(resultado);
        } else {
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
    
}
