/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author rdbae
 */
public class Linea_Caracas{
    private String nombre_linea;
    private ListaSimple lista_paradas;
    private String red;

    public Linea_Caracas(String nombre_linea, ListaSimple lista_paradas, String red) {
        this.nombre_linea = nombre_linea;
        this.lista_paradas = lista_paradas;
        this.red = red;
    }
    
    public Linea_Caracas() {
        this.nombre_linea = nombre_linea;
        this.lista_paradas = new ListaSimple();
        this.red = "Metro de Caracas";
    }

    /**
     * @return the nombre_linea
     */
    public String getNombre_linea() {
        return nombre_linea;
    }

    /**
     * @param nombre_linea the nombre_linea to set
     */
    public void setNombre_linea(String nombre_linea) {
        this.nombre_linea = nombre_linea;
    }

    /**
     * @return the lista_paradas
     */
    public ListaSimple getLista_paradas() {
        return lista_paradas;
    }

    /**
     * @param lista_paradas the lista_paradas to set
     */
    public void setLista_paradas(ListaSimple lista_paradas) {
        this.lista_paradas = lista_paradas;
    }

    /**
     * @return the red
     */
    public String getRed() {
        return red;
    }

    /**
     * @param red the red to set
     */
    public void setRed(String red) {
        this.red = red;
    }

    @Override
    public String toString() {
        return "Linea_Caracas{" + "nombre_linea=" + nombre_linea + ", lista_paradas=" + lista_paradas + ", red=" + red + '}';
    }
    
    

    
    

    
    
    


    
}
