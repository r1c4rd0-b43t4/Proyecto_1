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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author rdbae
 */
public class Reader {
    
    public void Read(){
        
        String Caracas = "";
        ListaSimple lineas_caracas = new ListaSimple();
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
                    
                if(!"".equals(Caracas)){
                    
                    Caracas = Caracas.replace("{", "");
                    Caracas = Caracas.replace("}", "");
                    Caracas = Caracas.replace("[", "");
                    Caracas = Caracas.replace("]", "");
                    Caracas = Caracas.replace(",", "");
                    Caracas = Caracas.replace(" ", "");
                    
                    Caracas = Caracas.replace("\n\n", "\n");
                    String[] array = Caracas.split("\n");
                    array[1] = "";
                    for(int  i = 2; i<array.length; i++){
                        array[i] = array[i].trim();
                        System.out.println(array[i]);
                    }
                    
                    Linea_Caracas linea = new Linea_Caracas();
                    
                    for(int  i = 1; i<array.length; i++){
                        if(array[i].equals("")){
                           if(!linea.getLista_paradas().EsVacio()){ //si la lista de paradas de la linea no esta vacia
                               lineas_caracas.insertarAlFinal(linea); //colocoa la linea en la lista de lineas
                               linea.getLista_paradas().empty();//vacia la lista de paradas
                               linea.setNombre_linea(array[i+1].replace(":", " "));//coloca el nombre de la linea
                           }
                           else{// en caso de que la lista de paradas de linea este vacia                           
                                linea.setNombre_linea(array[i+1].replace(":", " "));//coloca el nombre de la linea
                                
                           }   
                          i += 2; 
                        }
                        
                    linea.getLista_paradas().insertarAlFinal(array[i]);    
                    }
                    
                    lineas_caracas.showList();

                        
                        

                    


 


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
