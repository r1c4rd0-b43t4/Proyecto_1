/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reader;
import Proyecto.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.Gson;
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
        ListaDoble L_Caracas = new ListaDoble();
        ListaDoble L_Bogota = new ListaDoble();
        String line;
        
        File doc_data;
 
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".json", "json");
        fc.setFileFilter(filtro);
        fc.setCurrentDirectory(new File("Packages"));
        fc.setDialogTitle("Seleccione el archivo respectivo a las lineas de Caracas");
        
        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            doc_data = fc.getSelectedFile();
            try{
                if(!doc_data.exists()){
                    doc_data.createNewFile();
                }
                else{
                    FileReader fr = new FileReader(doc_data);
                    BufferedReader br = new BufferedReader(fr);
                    while((line = br.readLine()) != null){
                        if (!line.isEmpty()){
                            Caracas += line + "\n";
                        }
                    
                    }                  
                    if(!"".equals(Caracas)){
                        Gson gson = new Gson();
                        JsonParser  parser = new JsonParser();
                        JsonObject gsonObjt = parser.parse(Caracas).getAsJsonObject();
                        
                        /*gsonObjt.keySet().forEach(keyStr ->{
                            JsonObject keyvalue = gsonObjt.get(keyStr).getAsJsonObject();
                            System.out.println("key: "+ keyStr + " value: " + keyvalue);
                            
                            if (keyvalue.isJsonArray())
                            {}
                            
                            if (keyvalue.isJsonObject())
                            {}
                        });*/
                        
                        gsonObjt.keySet().forEach(keyStr ->{
                            this.proccessObject(keyStr, gsonObjt);
                        });
                        
                        
                        /*JsonArray arreglo = gsonObjt.getAsJsonArray("Metro de Caracas");
                        System.out.println(gsonObjt.keySet());
                        
                        for(int i = 0; i < arreglo.size(); i++)
                        {
                            System.out.println(arreglo.get(i));
                        }*/
                        //System.out.println(gsonObjt.get("Metro de Caracas"));
                        //gsonObjt.
                        //Red_Caracas red = gson.fromJson(Caracas, Red_Caracas.class);
                        //System.out.println(gsonObjt);
                        }
                        
                        fr.close();
                        br.close();
                    }
                 
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error durante la seleccion");
            }
        }
    
            
            
        fc = new JFileChooser();
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
                    try(FileReader fr = new FileReader(doc_data);){
                            br = new BufferedReader(fr);
                            while((line = br.readLine()) != null){
                            if (!line.isEmpty()){
                                Bogota += line + "\n";
                            }
                        }
                        if(!"".equals(Bogota)){
                            String[] Bogo = Bogota.split("\n");
                            for (String Bogo1 : Bogo){
                                String[] data = Bogo1.split(",");
                                L_Caracas.insertarAlFinal(data);
                            }      
                        }    
                    }
                    br.close();
                } 
            } catch (IOException | NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error durante la seleccion");
            }
        }

    }
    
    public void proccessObject(String keyStr, JsonObject gsonObjt)
    {
        System.out.println(keyStr);
        
        if (gsonObjt.get(keyStr).isJsonArray())
        {
            JsonArray arreglo = gsonObjt.get(keyStr).getAsJsonArray();
            
            for(int i = 0; i < arreglo.size(); i++)
            {
                System.out.println(arreglo.get(i));
                
                if (arreglo.get(i).isJsonObject())
                {
                    JsonObject lineas = arreglo.get(i).getAsJsonObject();
                    lineas.keySet().forEach(keyStr2 ->{
                        System.out.println(keyStr2);
                        
                        if (lineas.get(keyStr2).isJsonObject())
                        {
                            JsonObject keyvalue = lineas.get(keyStr2).getAsJsonObject();
                            System.out.println("key: "+ keyStr2 + " value: " + keyvalue);
                        }
                        
                        if (lineas.get(keyStr2).isJsonArray())
                        {
                            JsonArray arregloParadas = lineas.get(keyStr2).getAsJsonArray();
                            
                            for(int j = 0; j < arregloParadas.size(); j++)
                            {
                                System.out.println(arregloParadas.get(j));
                            }
                        }
                    });
                }
                    
            }
            
            /*JsonArray keyvalue = gsonObjt.get(keyStr).getAsJsonArray();
            System.out.println("key: "+ keyStr + " value: " + keyvalue);*/

            
        }

        if (gsonObjt.get(keyStr).isJsonObject())
        {}
    }
}
