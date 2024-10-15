/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author rdbae
 */
public class Red_Caracas{
    private Linea Linea;

    public Red_Caracas(Linea Linea) {
        this.Linea = Linea;
    }

    /**
     * @return the Linea
     */
    public Linea getLinea() {
        return Linea;
    }

    /**
     * @param Linea the Linea to set
     */
    public void setLinea(Linea Linea) {
        this.Linea = Linea;
    }

    @Override
    public String toString() {
        return "Red_Caracas{" + "Linea=" + Linea + '}';
    }
    
    
}
