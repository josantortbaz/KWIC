/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KWIC;

import poo.TituloKWIC;
import java.util.*;

/**
 *
 * @author Jortizbazaga
 */
public class KWIC {  
    private final String SEPARADORES_NS = " ";
    private final String SEPARADORES_T = "\n";
    
    private Set<TituloKWIC> noSignificativas;
    private Map<TituloKWIC, Set<String>> diccionario;
    
    
    public KWIC () {
        // El constructor sin parámetros sólo inicializará la estructura:
        this.noSignificativas = new TreeSet<TituloKWIC>();
        this.diccionario = new TreeMap<TituloKWIC, Set<String>>();
    }
    
    public KWIC (String titulos, String noSignificativas) {
        // Creamos el conjunto de palabras no significativas:
        this.noSignificativas = new TreeSet<TituloKWIC> ();
        this.generarNoSignificativas(noSignificativas);
        
        // Creamos el diccionario con los títulos y las palabras significativas:
        this.diccionario =
                new TreeMap<TituloKWIC, Set<String>>(generarDiccionario(titulos));
    }

    /**
     * Devuelve los separadores de las palabras no significativas
     * @return cadena con los separadores de las palabras no significativas.
     */
    public String getSEPARADORES_NS() {
        return SEPARADORES_NS;
    }

    /**
     * Devuelve los separadores de los títulos.
     * @return cadena con los separadores de los títulos.
     */
    public String getSEPARADORES_T() {
        return SEPARADORES_T;
    }

    /**
     * Devuelve el conjunto de palabras no significativas.
     * @return conjunto ordenado de palabras no significativas.
     */
    public Set<TituloKWIC> getNoSignificativas() {
        return noSignificativas;
    }
    
    public String getNoSignificativasString(){
        String retorno = "";
        for(TituloKWIC tk: this.noSignificativas)
            retorno += tk.toString() + "\n";
        return retorno;
    }

    /**
     * Devuelve el diccionario donde las claves son las palabras significativas y 
     * los valores los títulos de las películas que contienen esas claves. En esos 
     * títulos se ha sustituido la palabra clave por "...".
     * @return diccionario donde la clave es la palabra significativa y los valores 
     * son los títulos con esa clave sustituida por "...".
     */
    public Map<TituloKWIC, Set<String>> getDiccionario() {
        return diccionario;
    }

    /**
     * Modifica el conjunto de palabras no significativas.
     * @param noSignificativas conjunto ordenado de palabras no significativas.
     */
    public void setNoSignificativas(TreeSet<TituloKWIC> noSignificativas) {
        this.noSignificativas = noSignificativas;
    }
    
    public void setNoSignificativas(String noSignificativas){
        this.generarNoSignificativas(noSignificativas);
    }

    /**
     * Modifica el diccionario de películas.
     * @param diccionario diccionario para modificar el original
     */
    public void setDiccionario(Map<TituloKWIC, Set<String>> diccionario) {
        this.diccionario = diccionario;
    }
    
    /**
     * Método para modificar las películas iniciales.
     * @param titulos títulos de películas para calcular el kwic
     */
    public void setPeliculas(String titulos){
        this.diccionario =
                new TreeMap<TituloKWIC, Set<String>>(generarDiccionario(titulos));
    }
    
    /**
     * Método para generar las palabras no significativas a partir de una cadena.
     * @param noSignificativas cadena con las palabras no significativas.
     */
    private void generarNoSignificativas(String noSignificativas) {
        for (String s: dividirCadena(noSignificativas, this.SEPARADORES_NS))
            this.noSignificativas.add(new TituloKWIC(s));
    }
    
    /**
     * Divide un texto en un conjunto de cadenas de caracteres a partir de la 
     * cadena origen y de la cadena de separadores.
     * @param texto Cadena de origen
     * @param separadores Cadena con los separadores
     * @return conjunto de palabras no significativas
     */
    private Set<String> dividirCadena(String texto, String separadores) {
        Set<String> conjunto = new TreeSet<String>();
        StringTokenizer st = new StringTokenizer(texto, separadores);
        while(st.hasMoreTokens()) {
            conjunto.add(st.nextToken());
        }
        return conjunto;
    }
    
    /**
     * A partir de un texto con títulos y una cadena de separadores, genera
     * un conjunto de palabras clave (TituloKWIC) y un cojunto de títulos (String).
     * @param titulos texto con los títulos de las peliculas.
     * @param separadores cadena con los separadores para dividir el texto inicial.
     * @return diccionario donde la clave es la palbra significativa (TituloKWIC)
     * y el valor es un conjunto de los títulos de las películas (Set<String>).
     */
    private Map<TituloKWIC, Set<String>> generarDiccionario(String titulos){
        Map<TituloKWIC, Set<String>> diccionario = new TreeMap <TituloKWIC, Set<String>> ();
        // Dividimos el texto original en títulos aislados:
        Set<String> pelis = dividirCadena(titulos, this.SEPARADORES_T);
        for(String titulo: pelis) {
            // Para cada titulo dividimos la cadena en palabras (eliminando las no significativas):
            Set<String> significativas = buscarPalabrasSignificativas(titulo);
            for (String clave: significativas) {
                // Para cada palabra clave creamos su encapsulado TituloKWIC:
                TituloKWIC tk = new TituloKWIC(clave);
                // Comprobamos si dicha clave existe (si: cogemos su conjunto de valores, no: creamos un conjunto nuevo):
                Set<String> valores = (diccionario.containsKey(tk)) ? 
                        diccionario.get(tk) : new TreeSet<String>();                                
                // Creamos una nueva cadena con el título, pero sustituyendo la clave por "...":
                String valor = titulo.replace(clave, "...");
                // Añadimos la nueva cadena al conjunto de titulos:
                valores.add(valor);
                // Añadimos la dupla (clave, titulos) al diccionario:
                diccionario.put(tk, valores);
            }
        }
        return diccionario;
    }
    
    /**
     * Función que a partir de una cadena, retorna el conjunto de palabras significativas
     * que contiene la misma.
     * @param cadena cadena origen.
     * @return conjuto de palabras significativas que contiene la cadena original.
     */
    private Set<String> buscarPalabrasSignificativas (String cadena){
        Set<String> conjunto = dividirCadena(cadena, " ");
        Set<String> retorno = new TreeSet<String> ();
        for (String palabra: conjunto){
            if(! this.noSignificativas.contains(new TituloKWIC(palabra)))
                retorno.add(palabra);
        }
        return retorno;
    }
    
    /**
     * Método para convertir nuestro diccionario de películas en cadena de texto 
     * para que se pueda imprimir por pantalla.
     * @return cadena de texto con nuestro diccionario.
     */
    @Override
    public String toString (){
        String retorno = "";
        Set<TituloKWIC> claves = this.diccionario.keySet();
        for(TituloKWIC tk: claves){
            retorno += tk + "\n";
            Set<String> valores = this.diccionario.get(tk);
            for(String valor: valores){
                retorno += "\t" + valor + "\n";
            }
            retorno += "\n";
        }
        return retorno;
    }
}
