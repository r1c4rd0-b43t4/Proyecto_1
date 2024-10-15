package Proyecto;

import java.util.*;
import javax.swing.*;

class Grafo {
    private Map<String, List<String>> listaAd; // Adyacencia

    public Grafo() {
        listaAd = new HashMap<>();
    }

    // Agregar Nodo
    public void agregarEstacion(String estacion) {
        listaAd.putIfAbsent(estacion, new ArrayList<>());
    }

    // Agregar Arista
    public void agregarConexion(String estacion1, String estacion2) {
        listaAd.get(estacion1).add(estacion2);
        listaAd.get(estacion2).add(estacion1); 
    }

    // Método para mostrar el grafo usando JOptionPane
    public void mostrarGrafo() {
        StringBuilder sb = new StringBuilder();
        for (String estacion : listaAd.keySet()) {
            sb.append("Estación ").append(estacion).append(" conectada con: ").append(listaAd.get(estacion)).append("\n");
        }
        // Mostrar el resultado en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, sb.toString(), "Conexiones del Grafo", JOptionPane.INFORMATION_MESSAGE);   
    }
}
