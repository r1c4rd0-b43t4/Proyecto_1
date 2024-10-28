package Proyecto;

import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;


/**
 *Clase MostrarGrafo donde se muestra el Grafo en pantalla utilizando la librería Graphstream.
 */
public class MostrarGrafo {
    
    Graph red=new SingleGraph("MiGrafo"); 
    
    /**
     * El método consiste en recibir un objeto de tipo Grafo el cuál sera iterado para que sus parámetros sean llevados a un objeto tipo grafo de Graphstream, con el fín de cumplir el funcionamiento correcto de la librería.
     * @param grafo Recibe un objeto Grafo.
     * @throws Exception Al fallar la creación de un nodo o arista del grafo Graphstream.
     */
    public Graph mostrar(Grafo grafo) throws Exception {
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
        
        red=graphStream;
        return graphStream;
        

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
    
    /**
     * retorna la clase Graph
     * @return 
     */
    public Graph getGraph(){
        return red;
    }
    
}