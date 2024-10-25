/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;


import Proyecto.Grafo.Vertice;        
import Proyecto.Grafo.Arco;        
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author rdbae
 */

public class MostrarGrafo {

    public void mostrar(Grafo grafo) {
        Graph graphStream = new SingleGraph("MiGrafo");

        
        for (int i = 0; i < grafo.getMaxVert(); i++) {
            try {
                String nombreNodo = grafo.getVerticeI(i).getNombre();
                if (graphStream.getNode(nombreNodo) == null) {
                    graphStream.addNode(nombreNodo).setAttribute("ui.label", nombreNodo);
                } else {
                    System.out.println("Nodo ya existente: " + nombreNodo);
                }
            } catch (Exception e) {
                System.out.println("Error al agregar nodo: " + e.getMessage());
            }
        }

        
        for (int i = 0; i < grafo.getMaxVert(); i++) {
            try {
                String origen = grafo.getVerticeI(i).getNombre();
                ListaSimple adyacentes = grafo.getListaAdy(i);// obtiene lista de adyacencia del primer vertice
                Nodo current = adyacentes.getpFirst();
                while (current != null) {
                    String destino = ((Grafo.Arco) current.getValor()).getDestino();
                    String edgeId = origen + "-" + destino;
                    // Verifica si la arista ya existe y los nodos existen en el grafo
                    if (graphStream.getEdge(edgeId) == null && graphStream.getNode(destino) != null && graphStream.getNode(origen) != null) {
                        graphStream.addEdge(edgeId, origen, destino);
                    } else {
                        if (graphStream.getEdge(edgeId) != null) {
                            System.out.println("Arista ya existente: " + edgeId);
                        } else {
                            System.out.println("Nodo origen o destino no existente para la arista: " + edgeId);
                        }
                    }
                    current = current.getSiguiente();
                }
            } catch (Exception e) {
                System.out.println("Error al agregar arista: " + e.getMessage());
            }
        }

        
        graphStream.setAttribute("ui.stylesheet",
                "node {fill-color: red; size: 20px; text-size: 20;} edge {fill-color: black;}");

        
        Viewer viewer = graphStream.display();
    }    
}