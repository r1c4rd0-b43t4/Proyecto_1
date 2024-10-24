/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

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

        for (int i = 0; i < grafo.getnVert(); i++) {
            try {
                String nombreNodo = grafo.getVertice(i).getNombre();
                graphStream.addNode(nombreNodo).setAttribute("ui.label", nombreNodo);
            } catch (Exception e) {
                System.out.println("Error al agregar nodo: " + e.getMessage());
            }
        }

        for (int i = 0; i < grafo.getnVert(); i++) {
            try {
                String origen = grafo.getVertice(i).getNombre();
                ListaSimple adyacentes = grafo.getListaAdy(i);

                Nodo current = adyacentes.getpFirst();
                while (current != null) {
                    String destino = ((Grafo.Arco) current.getValor()).getDestino();
                    String edgeId = origen + "-" + destino;

                    if (graphStream.getEdge(edgeId) == null) {
                        graphStream.addEdge(edgeId, origen, destino);
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
        viewer.enableAutoLayout();
    }
   
    
    
}