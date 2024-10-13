import java.util.*;
import javax.swing.*;

class Grafo {
    private Map<String, List<String>> adjList; // Lista de adyacencia para las conexiones

    public Grafo() {
        adjList = new HashMap<>();
    }

    // Método para agregar una estación (nodo)
    public void agregarEstacion(String estacion) {
        adjList.putIfAbsent(estacion, new ArrayList<>());
    }

    // Método para agregar una conexión entre dos estaciones (arista)
    public void agregarConexion(String estacion1, String estacion2) {
        adjList.get(estacion1).add(estacion2);
        adjList.get(estacion2).add(estacion1); // Si el grafo es dirigido, elimina esta línea
    }

    // Método para mostrar el grafo usando JOptionPane
    public void mostrarGrafo() {
        StringBuilder sb = new StringBuilder();
        for (String estacion : adjList.keySet()) {
            sb.append("Estación ").append(estacion).append(" conectada con: ").append(adjList.get(estacion)).append("\n");
        }
        // Mostrar el resultado en un cuadro de diálogo
        JOptionPane.showMessageDialog(null, sb.toString(), "Conexiones del Grafo", JOptionPane.INFORMATION_MESSAGE);
    }
}
