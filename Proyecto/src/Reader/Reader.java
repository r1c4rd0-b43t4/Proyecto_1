/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reader;
import Listas.ListaDoble;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


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
        
        
        
        
        JFileChooser seleccionar = new JFileChooser();
        seleccionar.setCurrentDirectory(new File("Packages"));
        seleccionar.setDialogTitle("Seleccione el archivo respectivo a las lineas de Caracas");
        if(seleccionar.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            doc_data = seleccionar.getSelectedFile();
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
                        String[] Cara = Caracas.split("\n");
                        for (String Cara1 : Cara){
                            String[] data = Cara1.split(",");
                            L_Caracas.insertarAlFinal(data);
                        
                        }
                        fr.close();
                        br.close();
                    }
                } 
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error durante la seleccion");
            }
        }
    
            
            
        seleccionar = new JFileChooser();
        seleccionar.setCurrentDirectory(new File("Packages"));
        seleccionar.setDialogTitle("Seleccione el archivo respectivo a las lineas de Bogota");
        if(seleccionar.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            doc_data = seleccionar.getSelectedFile();
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
//        Grafo grafo = new Grafo();
//        return grafo
    }
}
