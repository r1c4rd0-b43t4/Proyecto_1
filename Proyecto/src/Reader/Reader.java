/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reader;
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
 *
 * @author rdbae
 */
public class Reader {
      
        
    
    public void Read(){
        
        String Caracas = "";
        String Bogota = "";
        Red Red_Caracas = new Red();
        Red Red_Bogota = new Red();
        
        
        

        String line;
        
        File doc_data;
 
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro_json = new FileNameExtensionFilter(".json", "json");
        fc.setFileFilter(filtro_json);
        fc.setCurrentDirectory(new File("Packages"));
        fc.setDialogTitle("Seleccione el archivo respectivo a las lineas de Caracas");
        
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
                                Caracas += line + "\n";
                            }
                        }   if(!"".equals(Caracas)){
                            
                            JsonParser  parser = new JsonParser();
                            JsonObject gsonObjt = parser.parse(Caracas).getAsJsonObject();
                            gsonObjt.keySet().forEach(keyStr ->{
                                 Red red_Caracas = proccessObject(keyStr, gsonObjt);
                                 Red_Caracas.setNombre_red(red_Caracas.getNombre_red());
                                 Red_Caracas.setLista_lineas(red_Caracas.getLista_lineas());
                            });
                        }
                    }
                        br.close();
                    }
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error durante la seleccion");
            }
        }else{
            System.out.println("No se ha seleccionado ningun archivo");
        }
        
        System.out.println(Red_Caracas.getNombre_red());//imprime el nombre de la red
        Red_Caracas.getLista_lineas().showParadas(Red_Caracas.getLista_lineas());//para ver las paradas por linea

    
            
        fc = new JFileChooser();       
        filtro_json = new FileNameExtensionFilter(".json", "json");
        fc.setFileFilter(filtro_json);
        fc.setCurrentDirectory(new File("Packages"));
        fc.setDialogTitle("Seleccione el archivo respectivo a las lineas de Bogota");
        
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
                                Bogota += line + "\n";
                            }
                        }   if(!"".equals(Bogota)){
                            
                            JsonParser  parser = new JsonParser();
                            JsonObject gsonObjt = parser.parse(Bogota).getAsJsonObject();
                            gsonObjt.keySet().forEach(keyStr ->{
                                 Red red_Bogota = proccessObject(keyStr, gsonObjt);
                                 Red_Bogota.setNombre_red(red_Bogota.getNombre_red());
                                 Red_Bogota.setLista_lineas(red_Bogota.getLista_lineas());
                            });
                        }
                    }
                        br.close();
                    }
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error durante la seleccion");
            }
        }else{
            System.out.println("No se ha seleccionado ningun archivo");
        }
        
        System.out.println(Red_Bogota.getNombre_red());//imprime el nombre de la red
        Red_Bogota.getLista_lineas().showParadas(Red_Bogota.getLista_lineas());//para ver las paradas por linea

    }
    
    
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
