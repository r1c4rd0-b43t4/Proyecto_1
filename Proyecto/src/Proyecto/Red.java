/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author rdbae
 */
public class Red {
    private String nombre_red;
    private Linea linea;

    public Red(String nombre_red, Linea linea) {
        this.nombre_red = nombre_red;
        this.linea = linea;
    }
    
    public Red() {
        this.nombre_red = nombre_red;
        this.linea = linea;
    }

    /**
     * @return the nombre_red
     */
    public String getNombre_red() {
        return nombre_red;
    }

    /**
     * @param nombre_red the nombre_red to set
     */
    public void setNombre_red(String nombre_red) {
        this.nombre_red = nombre_red;
    }

    /**
     * @return the linea
     */
    public Linea getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "Red{" + "nombre_red=" + nombre_red + ", linea=" + linea + '}';
    }
    
    

            
    
    
    
}
