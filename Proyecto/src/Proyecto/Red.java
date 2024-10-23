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
    private  ListaSimple lista_lineas;

    public Red(String nombre_red, ListaSimple lista_lineas) {
        this.nombre_red = nombre_red;
        this.lista_lineas = lista_lineas;
    }
    
    public Red() {
        this.nombre_red = nombre_red;
        this.lista_lineas = new ListaSimple();
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
     * @return the lista_lineas
     */
    public ListaSimple getLista_lineas() {
        return lista_lineas;
    }

    /**
     * @param lista_lineas the lista_lineas to set
     */
    public void setLista_lineas(ListaSimple lista_lineas) {
        this.lista_lineas = lista_lineas;
    }

    @Override
    public String toString() {
        return "Red{" + "nombre_red=" + nombre_red + ", lista_lineas=" + lista_lineas + '}';
    }
    
    

    
 
    
    
    
}
