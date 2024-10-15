/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author rdbae
 */
public class Linea {
    private String Linea;
    private String Parada;

    public Linea(String Linea, String Parada) {
        this.Linea = Linea;
        this.Parada = Parada;
    }

    /**
     * @return the Linea
     */
    public String getLinea() {
        return Linea;
    }

    /**
     * @param Linea the Linea to set
     */
    public void setLinea(String Linea) {
        this.Linea = Linea;
    }

    /**
     * @return the Parada
     */
    public String getParada() {
        return Parada;
    }

    /**
     * @param Parada the Parada to set
     */
    public void setParada(String Parada) {
        this.Parada = Parada;
    }
    
}
