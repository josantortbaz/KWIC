/*
 * Vista del proyecto KWIC.
 */
package vistas;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Jortizbazaga
 */
public class VistaKWIC {
    
    // Texto para mostrar en los labels:
    public final String TXT_LABEL_INSERTADO = "Títulos";
    public final String TXT_LABEL_CALCULADO = "Calculado";
    public final String TXT_LABEL_NS = "No significativas";

    // Texto que mostrarán los botones:
    public final String TXT_BTN_KWIC = "KWIC";
    public final String TXT_BTN_INSERTAR_NS = "Insertar";

    // Texto por defecto en los JTextAreas:
    public final String TXT_DEFECTO_KWIC = "Inserte títulos....";
    public final String TXT_DEFECTO_NS = "Inserte palabras no significativas";
    
    // Texto para mostrar en los tabs:
    public final String TXT_LAB_KWIC = "KWIC";
    public final String TXT_LAB_NS = "No significativas";

    
    private JMenuBar menu;      // Menú para la ventana.
    private JComboBox idiomas;  // Combo para seleccionar el idioma.
    private JTabbedPane tabs;   // Pestañas que contendrán las distintas vistas.
    private JFrame ventana;     // Ventana Principal.
    private JPanel super_panel, // Panel que incorporará tanto los tabs como los box para seleccionar el idioma.
            contenedor_kwic, // Área donde incluir todos los elementos de la pestaña kwic.
            contenedor_ns;  // Área donde incluir todos los elementos de la pestaña ns.
    private JTextArea texto_kwic, // Área del textoKWIC donde se introducirán los títulos.
            campo_kwic,  // 
            campo_ns;    // Área para añadir las palabras no significativas.
    private JTextField nueva_ns;    // Campo para añadir nuevas palabras no significativas.
    private JButton btn_kwic,   // Botón para calcular el KWIC del textoKWIC cargado.
            btn_insertar_ns;    // Botón para guardar el textoKWIC calculado en otro fichero.
    private JCheckBox ch_insertado, // CheckBox para exportar los títulos insertados.
            ch_calculado,   // CheckBox para exportar el KWIC calculado.
            ch_ns;          // CheckBox para exportar las palabras no significativas.
    private JLabel label_insertado, // Label para el checkBox cb_insertado.
            label_calculado,        // Label para el checkBox cb_calculado.
            label_ns;               // Label para el checkBox cb_ns.

    /**
     * Constructor que creará los elementos de la vista y los montará en la
     * vista:
     * @param lang lista de idiomas que debemos tener en cuenta en nuestra interfaz.
     */
    public VistaKWIC(ArrayList<String> lang) {
        this.creaCadenas();
        this.montaVistaKWIC();
        this.montaVistaNS();
        this.montaTabs();
        this.montaIdiomas(lang);
        this.abreVentana();
    }
    
    private void creaCadenas() {
        
    }

    /**
     * Método para crear los botones y el área que incluirá la botonera.
     */
    private void montaVistaKWIC() {     
        // Creamos el panel contenedor y las restricciones:
        this.contenedor_kwic = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Creamos el área de textoKWIC donde introduciremos los títulos:
        this.texto_kwic = new JTextArea();
        JScrollPane jsp1 = new JScrollPane(this.texto_kwic);
        // Especificamos las restricciones:
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;       // Para el escalado
        gbc.insets = new Insets(10,10,10,10);   // Para los margenes
        gbc.weightx = 100.0;    // % que se escala en x
        gbc.weighty = 100.0;    // % que se escala en y
        // Insertamos el texto en el panel con las restricciones:
        this.contenedor_kwic.add(jsp1, gbc);
                
        // Creamos el botón:
        this.btn_kwic = new JButton(this.TXT_BTN_KWIC);
        // Especificamos las restricciones:
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;       // Para el escalado
        gbc.insets = new Insets(10,10,10,10);   // Para los margenes
        gbc.weightx = 5.0;    // % que se escala en x
        gbc.weighty = 5.0;    // % que se escala en y
        // Insertamos el botón en el panel:        
        this.contenedor_kwic.add(this.btn_kwic, gbc);
        
        // Creamos checkboxs y sus labels:
        this.ch_insertado = new JCheckBox();
        this.label_insertado = new JLabel(this.TXT_LABEL_INSERTADO);
        this.ch_calculado = new JCheckBox();
        this.label_calculado = new JLabel(this.TXT_LABEL_CALCULADO);
        this.ch_ns = new JCheckBox();
        this.label_ns = new JLabel(this.TXT_LABEL_NS);
        // Los CheckBoxs y sus labels los vamos a introducir en un panel GridLayout:
        JPanel panel_check_boxs = new JPanel(new GridLayout(3,2));
        panel_check_boxs.add(this.label_insertado);
        panel_check_boxs.add(this.ch_insertado);
        panel_check_boxs.add(this.label_calculado);
        panel_check_boxs.add(this.ch_calculado);
        panel_check_boxs.add(this.label_ns);
        panel_check_boxs.add(this.ch_ns);
        // Especificamos las restricciones:
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;       // Para el escalado
        gbc.insets = new Insets(10,10,10,10);   // Para los margenes
        gbc.weightx = 0.0;    // % que se escala en x
        gbc.weighty = 0.0;    // % que se escala en y
        // Insertamos el panel de los checkboxs en el panel principal:        
        this.contenedor_kwic.add(panel_check_boxs, gbc);
       
        
        // Creamos el campo donde se mostraran los resultados:
        this.campo_kwic = new JTextArea();
        this.campo_kwic.setEnabled(false);
        // Los textos irán en paneles con scroll:            
        JScrollPane jsp2 = new JScrollPane(this.campo_kwic);
        // Especificamos las restricciones:
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;       // Para el escalado
        gbc.insets = new Insets(10,10,10,10);   // Para los margenes
        gbc.weightx = 100.0;    // % que se escala en x
        gbc.weighty = 100.0;    // % que se escala en y    
        // Añadimos los componentes al contenedor:
        this.contenedor_kwic.add(jsp2,gbc);        
    }

    /**
     * Método para crear el área donde introducir el textoKWIC cargado y
     * calculado.
     */
    private void montaVistaNS() {
        // Creamos el contenedor y sus restricciones:
        this.contenedor_ns = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Creamos el campo de texto donde se añadirán las palabras no significativas:
        this.campo_ns = new JTextArea();
        this.campo_ns.setEnabled(false);
        JScrollPane panelScroll = new JScrollPane(this.campo_ns);
        // Especificamos las restricciones:
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;       // Para el escalado
        gbc.insets = new Insets(10,10,10,10);   // Para los margenes
        gbc.weightx = 100.0;    // % que se escala en x
        gbc.weighty = 100.0;    // % que se escala en y
        // Lo añadimos al contenedor con las restricciones especificadas:
        this.contenedor_ns.add(panelScroll, gbc);
               
        // Creamos el campo para añadir nuevas palabras no significativas:
        this.nueva_ns = new JTextField();
        // Especificamos las restricciones:
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;       // Para el escalado
        gbc.insets = new Insets(10,10,10,10);   // Para los margenes
        gbc.weightx = 5.0;    // % que se escala en x
        gbc.weighty = 0.0;    // % que se escala en y
        // Añadimos el campo con las especificaciones:
        this.contenedor_ns.add(this.nueva_ns, gbc);
        
        // Creamos el botón para añadir nuevas palabras no significativas:
        this.btn_insertar_ns = new JButton(this.TXT_BTN_INSERTAR_NS);
        // Especificamos las restricciones:
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;       // Para el escalado
        gbc.insets = new Insets(10,10,10,10);   // Para los margenes
        gbc.weightx = 2.0;    // % que se escala en x
        gbc.weighty = 0.0;    // % que se escala en y        
        // Añadimos el botón al panel:
        this.contenedor_ns.add(this.btn_insertar_ns, gbc);
    }

    /**
     * Crea los tabs y añade el contenido de cada uno.
     */
    private void montaTabs() {
        this.tabs = new JTabbedPane();
        this.tabs.add(this.TXT_LAB_KWIC, this.contenedor_kwic);
        this.tabs.add(this.TXT_LAB_NS, this.contenedor_ns);
    }
    
    /**
     * Creamos un panel superior para los tabs y un panel inferior para seleccionar 
     * el idioma:
     */
    private void montaIdiomas(ArrayList<String> languages) {
        // Creamos el super panel que incluirá todo y las restricciones del mismo:
        this.super_panel = new JPanel (new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Creamos el Combo para los idiomas:
        this.idiomas = new JComboBox();
        for (String idioma: languages){
            this.idiomas.addItem(idioma);
        }
        
        //Creamos las restricciones para el combo de idiomas:
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;       // Para el escalado
        gbc.insets = new Insets(0,0,0,0);   // Para los margenes
        gbc.weightx = 0.0;    // % que se escala en x
        gbc.weighty = 0.0;    // % que se escala en y
        gbc.anchor = GridBagConstraints.LINE_END;
        // Añadimos el combo al panel:
        this.super_panel.add(idiomas, gbc);
        
        //Creamos las restricciones para las pestañas:
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;       // Para el escalado
        gbc.insets = new Insets(10,10,10,10);   // Para los margenes
        gbc.weightx = 100.0;    // % que se escala en x
        gbc.weighty = 100.0;    // % que se escala en y
        // Insertamos las pestañas al panel:
        this.super_panel.add(this.tabs, gbc);
        
        
    }

    /**
     * Crea, configura y abre la ventana
     */
    private void abreVentana() {
        // Creamos la ventana:
        this.ventana = new JFrame();
        // Añadimos los elementos:
        this.ventana.add(this.super_panel);
        // Configura la ventana:
        this.ventana.setTitle("GUI de KWIC");
        this.ventana.pack();
        // Abre la ventana:
        this.ventana.setVisible(true);
        // Configura la salida de la ventana y de la aplicación:
        this.ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
