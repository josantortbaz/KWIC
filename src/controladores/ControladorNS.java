/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.VistaKWIC;

/**
 *
 * @author josea
 */
public class ControladorNS implements ActionListener {

    private VistaKWIC vista;
    
    public ControladorNS (VistaKWIC v) {
        this.vista = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
