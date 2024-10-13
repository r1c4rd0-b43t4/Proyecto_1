
package Reader;
import Listas.ListaDoble;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Readerv2 {

    

    public void Reader() {
        
    }

    // Método para leer el archivo con JFileChooser y procesar los datos
    public void Read() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona el archivo de datos (JSON)");

        // Mostrar el diálogo de selección de archivo
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            try {
                // Leer el archivo como una cadena de texto
                String content = new String(Files.readAllBytes(Paths.get(filePath)));

                // Determinar si es el archivo de Caracas o Bogotá y procesarlo
                if (content.contains("Metro de Caracas")) {
                    procesarCaracas(content);
                } else if (content.contains("Transmilenio")) {
                    procesarBogota(content);
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Parece que este archivo no contiene datos reconocidos del sistema de transporte. Asegúrate de que sea el archivo correcto.", 
                        "Archivo no reconocido", 
                        JOptionPane.WARNING_MESSAGE);
                }

                // Mostrar el resultado del grafo en un cuadro de diálogo
                grafo.mostrarGrafo();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, 
                    "Hubo un error al intentar leer el archivo. Por favor, verifica el archivo e inténtalo de nuevo.\nDetalles: " + e.getMessage(), 
                    "Error al leer el archivo", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, 
                "No seleccionaste ningún archivo. Si deseas cargar un archivo, por favor intenta de nuevo.", 
                "No se seleccionó archivo", 
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para procesar el archivo JSON de Caracas
    private void procesarCaracas(String content) {
        String[] lineas = content.split("\\{");

        for (String linea : lineas) {
            if (linea.contains("Linea")) {
                String[] estaciones = linea.split("\":\\[|,|\\]");
                procesarEstaciones(estaciones);
            }
        }
    }

    // Método para procesar el archivo JSON de Bogotá
    private void procesarBogota(String content) {
        String[] lineas = content.split("\\{");

        for (String linea : lineas) {
            if (linea.contains("Av.")) {
                String[] estaciones = linea.split("\":\\[|,|\\]");
                procesarEstaciones(estaciones);
            }
        }
    }

    // Método para procesar las estaciones y agregarlas al grafo
    private void procesarEstaciones(String[] estaciones) {
        for (int i = 1; i < estaciones.length; i++) {
            String estacionActual = estaciones[i].trim().replaceAll("\"", "");
            grafo.agregarEstacion(estacionActual);

            // Conectar la estación con la anterior (para formar las aristas)
            if (i > 1) {
                String estacionAnterior = estaciones[i - 1].trim().replaceAll("\"", "");
                grafo.agregarConexion(estacionAnterior, estacionActual);
            }
        }
    }
}
