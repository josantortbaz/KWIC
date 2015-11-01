/*
 * Clase para encapsular un String y poder realizar operaciones de comparación sin
 * que afecte las mayúsculas o minúsculas del la misma.
 */
package poo;

import java.util.Objects;

/**
 *
 * @author Jortizbazaga
 */
public class TituloKWIC implements Comparable {
    
    private String titulo;  // Cadena siempre en mayúsculas

    /**
     * Constructor sin parámetros. Sólo inicializa la variable.
     */
    public TituloKWIC() {
        this.titulo = "";
    }
    
    /**
     * Constructo al que se le pasa una cadena que se pasa a mayúsculas y se asigna a la variable de clase.
     * @param s cadena original
     */
    public TituloKWIC (String s) {
        this.titulo = s.toUpperCase();
    }

    /**
     * Método que devuelve el título contenido en la clase
     * @return título encapsulado en la clase (en mayúsculas)
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Modifica el titulo contenido en la clase.
     * @param titulo cadena para modificar el título contenido en la clase
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    /**
     * Método que compara un objeto de esta clase con otro.
     * @param o objeto para compararlo con this.
     * @return < 0 - esta cadena es menor que la que nos pasan.
     *         > 0 - esta cadena es mayor que la que nos pasan.
     *         = 0 - esta cadena es igual a la que nos pasan.
     */
    @Override
    public int compareTo(Object o) { 
        try {
            TituloKWIC tk = (TituloKWIC)o;
            return this.getTitulo().compareTo(tk.getTitulo());                
        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    /**
     * Método que indica si un objeto de esta clase es igual a otro.
     * @param o objeto para compara el nuestro con este.
     * @return true  - son iguales.
     *         false - son diferentes.
     */
    @Override
    public boolean equals (Object o) {
        return this.compareTo(o) == 0;
    }

    /**
     * Metodo para calcular el hashcode de un objeto de nuestra clase
     * @return entero con el valor del hashcode.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.titulo);
        return hash;
    }
    
    /**
     * Método para convertir un objeto de nuestra clase en cadena de caracteres para que se pueda imprimir.
     * @return String para que se pueda imprimir un objeto de nuestra clase.
     */
    @Override
    public String toString () {
        return this.titulo;
    }
}
