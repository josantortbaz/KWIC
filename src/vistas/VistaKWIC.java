/*
 * Vista del proyecto KWIC.
 */
package vistas;

import controladores.ControladorKWIC;
import controladores.ControladorIdiomas;
import java.awt.*;
import javax.swing.*;
import java.util.List;

/**
 *
 * @author Jortizbazaga
 */
public class VistaKWIC extends JFrame {
    
    // Texto para mostrar en los labels:
    private String txtLabelInsertado,
            txtLabelCalculado, 
            txtLabelNS;

    // Texto que mostrarán los botones:
    private String txtBtnKWIC,
            txtBtnNS;

    // Texto por defecto en los JTextAreas:
    private String txtDefectoKWIC,
            txtDefectoNS;
    
    // Texto para mostrar en los tabs:
    private String txtLabKWIC,
            txtLabNS;
    
    // Título de la ventana:
    private String tituloVentana;

    // INTERNACIONALIZACIÓN:
    private List<String> idiomas;
    
    // ELEMENTOS VISUALES:
    private JComboBox comboIdiomas;  // Combo para seleccionar el idioma.
    private JTabbedPane tabs;   // Pestañas que contendrán las distintas vistas.
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
    
    //  CONTROLADORES:
    private ControladorIdiomas controladorIdiomas;
    private ControladorKWIC controladorKWIC;

    /**
     * Constructor que inicializará las variables y creará los elementos de la vista
     * y los montará en la misma:
     * @param lang lista de idiomas que debemos tener en cuenta en nuestra interfaz.
     */
    public VistaKWIC() {
        // Creamos los controladores:
        this.controladorIdiomas = new ControladorIdiomas(this);
        this.controladorKWIC = new ControladorKWIC(this);
        
        // Inicializamos los idiomas de la aplicación:
        this.idiomas = this.controladorIdiomas.getIdiomas();
        inicializaCadenas();
        
        // Inciamos los elementos:
        this.montaVistaKWIC();
        this.montaVistaNS();
        this.montaTabs();
        this.montaMenus();        
        this.abreVentana();
    }
    
    /**
     * Método para inicializar las cadenas de texto según con qué idioma queramos
     * que se muestren:
     */
    private void inicializaCadenas(){
        this.txtLabelInsertado = "Títulos";//this.mainControlador.getTextDeElemento("txtLabelInsertado");
        this.txtLabelCalculado = "Calculado"; //this.mainControlador.getTextDeElemento("txtLabelCalculado");
        this.txtLabelNS = "No significativas"; //this.mainControlador.getTextDeElemento("txtLabelNS");
        this.txtBtnKWIC = "KWIC"; //this.mainControlador.getTextDeElemento("txtBtnKWIC");
        this.txtBtnNS = "Insertar"; //this.mainControlador.getTextDeElemento("txtBtnNS");
        this.txtDefectoKWIC = "Inserte títulos de películas"; //this.mainControlador.getTextDeElemento("txtDefectoKWIC");
        this.txtDefectoNS = "Inserte palabras no significativas"; //this.mainControlador.getTextDeElemento("txtDefectoNS");
        this.txtLabKWIC = "KWIC"; //this.mainControlador.getTextDeElemento("txtLabKWIC");
        this.txtLabNS = "No significativas"; //this.mainControlador.getTextDeElemento("txtLabNS");
        this.tituloVentana = "GUI de KWIC"; //this.mainControlador.getTextDeElemento("tituloVentana");
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
        this.texto_kwic.setToolTipText(this.txtDefectoKWIC);
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
        this.btn_kwic = new JButton(this.txtBtnKWIC);
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
        this.label_insertado = new JLabel(this.txtLabelInsertado);
        this.ch_calculado = new JCheckBox();
        this.label_calculado = new JLabel(this.txtLabelCalculado);
        this.ch_ns = new JCheckBox();
        this.label_ns = new JLabel(this.txtLabelNS);
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
        
        // Añadimos el controlador para gestionar los eventos de la pestaña.
        creaControladorKWIC();
    }
    
    /** 
     * Método para añadir el controlador a la pestaña de KWIC:
     */
    private void creaControladorKWIC (){
        this.btn_kwic.addActionListener(this.controladorKWIC);
        this.btn_kwic.setActionCommand(ControladorKWIC.ACCION_BOTON_CALCULAR_KWIC);
    }
    
    /**
     * Método que retorna los títulos que hemos insertado en el campo de títulos.
     * @return títulos insertados.
     */
    public String getTitulos () {
        return this.texto_kwic.getText();
    }

    /**
     * Método que inserta el resultado del diccionario de títulos kwic en el campo
     * habilitado para ello.
     * @param kwic diccionario de títulos kwic resultante.
     */
    public void setKWIC (String kwic){
        this.campo_kwic.setText(kwic);
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
        this.nueva_ns.setToolTipText(this.txtDefectoNS);
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
        this.btn_insertar_ns = new JButton(this.txtBtnNS);
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
        
        // Isertamos el controlador de la pestaña:
        creaControladorNS();
    }
    
    /**
     * Método para configurar el controlador de la pestaña de palabras no Significativas. 
     */
    private void creaControladorNS(){
        this.btn_insertar_ns.addActionListener(this.controladorKWIC);
        this.btn_insertar_ns.setActionCommand(ControladorKWIC.ACCION_BOTON_INSERTAR_NS);
    }
    
    /** 
     * Método que devuelve el contenido añadido en el campo para introducir palabras no
     * Significativas.
     * @return palabras no significativas insertadas.
     */
    public String getPalabraNS () {
        String retorno = this.nueva_ns.getText();
        this.nueva_ns.setText("");
        return retorno;
    }
    
    public void setPalabrasNS(String s) {
        this.campo_ns.setText(s);
    }

    /**
     * Crea los tabs y añade el contenido de cada uno.
     */
    private void montaTabs() {
        this.tabs = new JTabbedPane();
        this.tabs.add(this.txtLabKWIC, this.contenedor_kwic);
        this.tabs.add(this.txtLabNS, this.contenedor_ns);
    }
    
    /**
     * Creamos un panel superior para los tabs y un panel inferior para seleccionar 
     * el idioma:
     */
    private void montaMenus() {           
        // Creamos el super panel que incluirá todo y las restricciones del mismo:
        this.super_panel = new JPanel (new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
       
        // Creamos el Combo para los idiomas:
        this.comboIdiomas = new JComboBox();
        // Añadimos los idiomas al comboBox
        for (String idioma: idiomas){
            this.comboIdiomas.addItem(idioma);
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
        this.super_panel.add(comboIdiomas, gbc);
        
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
        
        this.creaControladorMenus();
    }

    /**
     * Método para crear y añadir el controlador del combo de idiomas : 
     */
    private void creaControladorMenus () {        
        this.comboIdiomas.addActionListener(this.controladorIdiomas);
        this.comboIdiomas.setActionCommand(ControladorIdiomas.ACCION_COMBO_IDIOMA);
    }
    
    /**
     * Crea, configura y abre la ventana
     */
    private void abreVentana() {
        // Añadimos los elementos:
        this.add(this.super_panel);
        // Configura la ventana:
        this.setTitle(this.tituloVentana);
        this.pack();
        // Abre la ventana:
        this.setVisible(true);
        // Configura la salida de la ventana y de la aplicación:
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    /**
     * Método que devuelve el item que se ha seleccionado.
     * @return String con el ítem seleccionado del combo
     */
    public String getIdiomaCombo(){
        return (String)this.comboIdiomas.getSelectedItem();
    }
    
    /**
     * Método que define cómo se va a hacer el repaint de la ventana.
     */
    @Override
    public void repaint(){
        inicializaCadenas2();
        super.repaint();
        // Inciamos los elementos:
        this.montaVistaKWIC();
        this.montaVistaNS();
        this.montaTabs();
        this.montaMenus();        
        this.abreVentana();
        System.out.println("Repaint realizado");
    }
    
    /**
     * Método para comprobar que el repaint funciona correctamente.
     */
    public void inicializaCadenas2(){
        this.txtLabelInsertado = "Títulos2";
        this.txtLabelCalculado = "Calculado2";
        this.txtLabelNS = "No significativas2";
        this.txtBtnKWIC = "KWIC2";
        this.txtBtnNS = "Insertar2";
        this.txtDefectoKWIC = "Insertar2";
        this.txtDefectoNS = "Insertar2";
        this.txtLabKWIC = "KWIC2";
        this.txtLabNS = "No significativas2";
        this.tituloVentana = "GUI de KWIC2"; 
    }

}
