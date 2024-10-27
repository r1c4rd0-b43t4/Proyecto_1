package Proyecto;

import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;


/**
 *Clase MostrarGrafo donde se muestra el Grafo en pantalla utilizando la librería Graphstream.
 */
public class MostrarGrafo {
    
    /**
     * El método consiste en recibir un objeto de tipo Grafo el cuál sera iterado para que sus parámetros sean llevados a un objeto tipo grafo de Graphstream, con el fín de cumplir el funcionamiento correcto de la librería.
     * @param grafo Recibe un objeto Grafo.
     * @throws Exception Al fallar la creación de un nodo o arista del grafo Graphstream.
     */
    public void mostrar(Grafo grafo) throws Exception {
       System.setProperty("org.graphstream.ui", "swing");
        Graph graphStream = new SingleGraph("MiGrafo");


        for (int i = 0; i < grafo.getMaxVert(); i++) {
            try {
                String nombreNodo = grafo.getVerticeI(i).getNombre();
                if (graphStream.getNode(nombreNodo) == null) {
                    graphStream.addNode(nombreNodo).setAttribute("ui.label", nombreNodo);
                } 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al agregar nodo");
            }
        }

        for (int i = 0; i < grafo.getMaxVert(); i++) {
            try {
                String origen = grafo.getVerticeI(i).getNombre();
                ListaSimple adyacentes = grafo.getListaAdy(i);
                Nodo current = adyacentes.getpFirst();
                while (current != null) {
                    String destino = ((Grafo.Arco) current.getValor()).getDestino();
                    String edgeId = origen + "-" + destino;
                    String reverseEdgeId = destino + "-" + origen; 
                    if (graphStream.getEdge(edgeId) == null && graphStream.getEdge(reverseEdgeId) == null) {
                        if (graphStream.getNode(destino) != null && graphStream.getNode(origen) != null) {
                            graphStream.addEdge(edgeId, origen, destino);
                        } 
                    } 
                    current = current.getSiguiente();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al agregar arista"); 
            }
        }

        graphStream.setAttribute("ui.stylesheet",
                "node {fill-color: Green; size: 20px; text-size: 10;} edge {fill-color: black;}");
        
        graphStream.display();

    }
}