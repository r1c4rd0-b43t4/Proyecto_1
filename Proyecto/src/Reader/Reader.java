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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonToken;




/**
 *
 * @author rdbae
 */
public class Reader {
    
    public void Read(){
        
        String Caracas = "";
        String Bogota = "";
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
                    System.out.println(Caracas);
   
                    if(!"".equals(Caracas)){
                        JsonParser  parser = new JsonParser();
                        JsonObject gsonObjt = parser.parse(Caracas).getAsJsonObject();
                        
//                        
//                        
//                        String nombre_red = gsonOb
//                                
//                        
//                        for(JsonElement jsonArray : gsonObjt){
                            
                            
                        
                                
                        
                        

                    }
                        fr.close();
                        br.close();
                }   
            } 
            catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error durante la seleccion");
            }
        }
    
            
            
//        fc = new JFileChooser();
//        fc.setCurrentDirectory(new File("Packages"));
//        fc.setDialogTitle("Seleccione el archivo respectivo a las lineas de Bogota");
//        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
//            doc_data = fc.getSelectedFile();
//            try{
//                if(!doc_data.exists()){
//                    doc_data.createNewFile();
//                }
//                else{
//                    BufferedReader br;
//                    try(FileReader fr = new FileReader(doc_data);){
//                            br = new BufferedReader(fr);
//                            while((line = br.readLine()) != null){
//                            if (!line.isEmpty()){
//                                Bogota += line + "\n";
//                            }
//                        }
//                        if(!"".equals(Bogota)){
//                            String[] Bogo = Bogota.split("\n");
//                            for (String Bogo1 : Bogo){
//                                String[] data = Bogo1.split(",");
//
//                            }      
//                        }    
//                    }
//                    br.close();
//                } 
//            } catch (IOException | NumberFormatException e){
//                JOptionPane.showMessageDialog(null, "Error durante la seleccion");
//            }
//        }
//
    }
}
