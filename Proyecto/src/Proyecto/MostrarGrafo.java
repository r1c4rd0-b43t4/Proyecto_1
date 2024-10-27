/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import Proyecto.Grafo.Vertice;        
import Proyecto.Grafo.Arco;        
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.springbox.implementations.SpringBox;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author rdbae
 */

public class MostrarGrafo {

    public void mostrar(Grafo grafo) throws Exception {
       System.setProperty("org.graphstream.ui", "swing");
        Graph graphStream = new SingleGraph("MiGrafo");

        // Añadir nodos
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

        // Añadir aristas
        for (int i = 0; i < grafo.getMaxVert(); i++) {
            try {
                String origen = grafo.getVerticeI(i).getNombre();
                ListaSimple adyacentes = grafo.getListaAdy(i);
                Nodo current = adyacentes.getpFirst();
                while (current != null) {
                    String destino = ((Grafo.Arco) current.getValor()).getDestino();
                    String edgeId = origen + "-" + destino;
                    String reverseEdgeId = destino + "-" + origen; // Verifica la arista en sentido inverso
                    if (graphStream.getEdge(edgeId) == null && graphStream.getEdge(reverseEdgeId) == null) {
                        // Verificar si los nodos de origen y destino existen antes de agregar la arista
                        if (graphStream.getNode(destino) != null && graphStream.getNode(origen) != null) {
                            graphStream.addEdge(edgeId, origen, destino);
                            System.out.println("Arista agregada: " + edgeId);
                        } else {
                            System.out.println("Nodo origen o destino no existente para la arista: " + edgeId);
                        }
                    } else {
                        System.out.println("Arista ya existente: " + edgeId);
                    }
                    current = current.getSiguiente();
                }
            } catch (Exception e) {
                System.out.println("Error al agregar arista: " + e.getMessage());
            }
        }

        
        graphStream.setAttribute("ui.stylesheet",
                "node {fill-color: red; size: 20px; text-size: 10;} edge {fill-color: black;}");
        
//        for (int i = 0; i < grafo.getMaxVert(); i++) {
//            String nombreNodo = grafo.getVerticeI(i).getNombre();
//            graphStream.getNode(nombreNodo).setAttribute("xy", Math.random() * 100, Math.random() * 100);
//        }

        

        
//        
//        // Aplicar el algoritmo de diseño SpringBox para organizar el grafo
//        SpringBox layout = new SpringBox();
//        layout.setStabilizationLimit(0.9);
//        graphStream.addAttributeSink(layout);

        // Mostrar el grafo con el algoritmo de diseño
        Viewer viewer = graphStream.display();

    }
 
    //recibe el grafo a trabajar y el nombre de la parada a poner sucursal
    public void ColocarSucursal(Grafo red,Graph grafo, String nombre) {
        Node nodo = grafo.getNode(nombre);
        if (nodo != null) {
            String colorActual = nodo.getAttribute("ui.style").toString();
            

            // Verificar si el nodo no está en rojo
            if (colorActual.contains("fill-color: red")) {
                System.out.println("Nodo " + nombre + " ya está en rojo.");
            }
            else {
                // Cambiar el color del nodo a rojo
                nodo.setAttribute("ui.style", "fill-color: red;");
                red.getVerticeN(nombre).setSucursal(true);
                System.out.println("Nodo " + nombre + " cambiado a rojo.");
            }
        }
        else {
            System.out.println("Nodo " + nombre + " no existe.");
        }
    }

}