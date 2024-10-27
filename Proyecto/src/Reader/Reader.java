package Reader;
import Proyecto.Grafo;
import Proyecto.Linea;
import Proyecto.ListaSimple;
import Proyecto.Red;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray; 


/**
 * Clase Reader donde se realiza la lectura de los archivos .JSON con el uso de la libreria gson.
 * @author rdbae
 */
public class Reader {  
    
    /**
     * Método que guia al usuario a la selección de los archivos .JSON que serán usados para el funcionamiento del programa, verificando que se cumpla todo lo necesario para crear el grafo con la Red de transporte.
     * @return Grafo
     */
    public Grafo Read(){
        
        String Texto = "";

        Red red = new Red();

        String line;
        
        File doc_data;
 
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro_json = new FileNameExtensionFilter(".json", "json");
        fc.setFileFilter(filtro_json);
        fc.setCurrentDirectory(new File("Packages"));
        fc.setDialogTitle("Seleccione el archivo para cargar la red de transporte");
        
        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            doc_data = fc.getSelectedFile();
            try{
                if(!doc_data.exists()){
                    doc_data.createNewFile();
                }
                else{
                    BufferedReader br;
                    try (FileReader fr = new FileReader(doc_data)) {
                        br = new BufferedReader(fr);
                        while((line = br.readLine()) != null){
                            if (!line.isEmpty()){
                                Texto += line + "\n";
                            }
                        }   if(!"".equals(Texto)){
                            
                            JsonParser  parser = new JsonParser();
                            JsonObject gsonObjt = parser.parse(Texto).getAsJsonObject();
                            gsonObjt.keySet().forEach(keyStr ->{
                                 Red red_ = proccessObject(keyStr, gsonObjt);
                                 red.setNombre_red(red_.getNombre_red());
                                 red.setLista_lineas(red_.getLista_lineas());
                            });
                        }
                    }
                        br.close();
                    }
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error durante la seleccion");
                return null;
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se selecciono ningun archivo");
            return null;
        }
        
        System.out.println(red.toString());
        Grafo grafo = new Grafo(0, "");
        grafo = red.getLista_lineas().CrearGrafo(red.getLista_lineas(), red.getNombre_red());
        
        System.out.println(grafo.toString());


        return grafo;

    }
    
    /**
     * Método que procesa los objetos dentro del archivo .JSON, para que sea llevado a un objeto de tipo Red, permitiendo así la facilidad de crear el grafo a partir de este objeto.
     * @param keyStr key
     * @param gsonObjt value
     * @return Objeto Red con sus respectivas líneas y paradas.
     */
    public Red proccessObject(String keyStr, JsonObject gsonObjt)
    {
        Red red = new Red();
        String nombre_red = keyStr;

        ListaSimple lista_lineas = new ListaSimple();
        red.setNombre_red(nombre_red);//sout1
        
        
        if (gsonObjt.get(keyStr).isJsonArray())
        {
            JsonArray arreglo = gsonObjt.get(keyStr).getAsJsonArray();
            
            for(int i = 0; i < arreglo.size(); i++)
            {

                
                if (arreglo.get(i).isJsonObject())
                {
                    JsonObject lineas = arreglo.get(i).getAsJsonObject();
                    lineas.keySet().forEach(keyStr2 ->{
                        Linea linea = new Linea();
                        linea.setNombre_linea(keyStr2);//sout3
                        
                        if (lineas.get(keyStr2).isJsonObject())
                        {
                            JsonObject keyvalue = lineas.get(keyStr2).getAsJsonObject();

                        }
                        
                        if (lineas.get(keyStr2).isJsonArray())
                        {
                            JsonArray arregloParadas = lineas.get(keyStr2).getAsJsonArray();
                            ListaSimple lista_paradas = new ListaSimple();
                            for(int j = 0; j < arregloParadas.size(); j++)
                            {

                                
                                lista_paradas.insertarAlFinal(arregloParadas.get(j));
                            }
                            linea.setLista_paradas(lista_paradas);
                        }
                        
                        lista_lineas.insertarAlFinal(linea);
                    });
                }
                    
            }  

        }
        red.setLista_lineas(lista_lineas);
        return red;
    }
}
