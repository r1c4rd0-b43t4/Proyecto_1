
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import Proyecto.Grafo.Vertice;
import Proyecto.Grafo.Arco;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray; 
/**
 *
 * @author HP
 */
public class ListaSimple {
    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public boolean EsVacio(){
        return (pFirst == null);   
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public int getSize() {
        return size;
    }
    
    public <T> Nodo getValue( T value){
        Nodo aux = this.pFirst;
        while (aux != null){
            if (aux.getValor().equals(value))
                return aux;
            else
                aux = aux.getSiguiente();
        } 
        return aux;        
    }
    
    public <T> void insertarAlFinal(T value){
        
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        if (this.EsVacio()){
            this.pFirst = newNodo;
        }
        else{
            Nodo aux = this.pLast;
            aux.setSiguiente(newNodo);
        
        }
        this.pLast = newNodo;
        this.size += 1;
    }
    
    public <T> void insertarAlPrincipio(T value){
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        if (this.EsVacio()){
            this.pLast = newNodo;
        }
        newNodo.setSiguiente(this.pFirst);
        this.pFirst = newNodo;
        this.size += 1;
    }
    
    public <T> void eliminar (T value){
        Nodo ant = null;
        Nodo aux = this.pFirst;
        while (aux != null){
            if (aux.getValor().equals(value)){
                if (ant == null){
                    this.pFirst = aux.getSiguiente();
                    break;
                }
                ant.setSiguiente(aux.getSiguiente());
                break;
            }
            else{
                ant = aux;
                aux = aux.getSiguiente();
            }    
        }  
    }
    
    public void showList(){
        Nodo aux = this.pFirst;
        while (aux != null){
            System.out.println(aux.getValor().toString());
            aux = aux.getSiguiente();
        }

    }
    
    public <T> boolean contiene(T value){
        Nodo temp=pFirst;
        while(temp!=null){
            if(temp.getValor().equals(value)){
                return true;
            }
            temp=temp.getSiguiente();
        }
        return false;
    }
    
       
    
//public void showParadas(ListaSimple lista_lineas) {
//    Nodo aux_1 = lista_lineas.pFirst;
//
//    while (aux_1 != null) {
//        if (aux_1.getValor() instanceof Linea) {
//            Linea linea1 = (Linea) aux_1.getValor();
//            ListaSimple lista_p = linea1.getLista_paradas();  // Supongamos que tienes un método para obtener las paradas
//            Nodo aux_2 = lista_p.pFirst;
//            System.out.println(linea1.getNombre_linea());
//
//            while (aux_2 != null) {
//                System.out.println(aux_2.getValor());
//                aux_2 = aux_2.getSiguiente();
//            }
//        }
//
//        aux_1 = aux_1.getSiguiente();
//    }
//}
    //nombreRed llamar red.getNombreRed
    public Grafo CrearGrafo(ListaSimple lista_lineas,String nombreRed) {
    Nodo aux_1 = lista_lineas.pFirst;
    int maxVert=0;
    maxVert=this.MaxParadas(lista_lineas);
    Grafo red = new Grafo(maxVert,nombreRed);
    aux_1 = lista_lineas.pFirst;
    int indice = 0;
    while (aux_1 != null) {
        if (aux_1.getValor() instanceof Linea) {
            Linea linea = (Linea) aux_1.getValor();
            ListaSimple lista_p = linea.getLista_paradas();  
            Nodo aux_2 = lista_p.pFirst;
            int contador = 0;
            System.out.println(linea.getNombre_linea());
            System.out.println(red.getMaxVert());
            while (aux_2 != null) {
                System.out.println(aux_2.getValor());
                System.out.println(red.getnVert());
                //si No existe el vertice hace esto.
                boolean existe= red.getNumVertice(aux_2.getValor().toString())>=0;
                if(!existe){
                    red.nuevoVertice(aux_2.getValor().toString());
                    try{
                        red.getVerticeI(indice).setLinea1(linea.getNombre_linea());
                    }
                    catch(Exception e){
                        
                    }
                    
                    
                    if(contador>0){
                        try{
                            if(red.getVerticeJ(indice-1).indice2>0){
                        red.nuevoArco(red.getVerticeI(indice-1).getNombre(), red.getVerticeI(indice).nombre);
                            }
                            else if(red.getVerticeI(indice).getLinea1().equals(red.getVerticeJ(indice-1).linea2)){
                                red.nuevoArco(red.getVerticeI(indice).getNombre(), red.getVerticeJ(indice-1).nombre);
                            }
                            else{
                                red.nuevoArco(red.getVerticeJ(indice-1).getNombre(), red.getVerticeI(indice).nombre);
                            }
                        }
                        catch(Exception e){
                            
                        }
                    }
                }
                //si existe combina las lineas y adyacencias
                else{
                    Vertice vertice=red.getVerticeN(aux_2.getValor().toString());
                    vertice.setIndiceComplementario(indice);
                    vertice.setLinea2(linea.getNombre_linea());
                    try{
                        //poner un if que revise si el que está en ambas tiene la conexion con el anterior de la linea
                        //si lo tiene no se hace nada y sino se le agrega la conexion
                        if(!vertice.getLinea2().equals(red.getVerticeI(indice-1).getLinea2())){
                            red.nuevoArco(vertice.nombre, red.getVerticeI(indice-1).nombre);
                        }
                    }
                    catch(Exception e){
                    
                    }
                    //esto en teoria no se usa porque ya estan conectados
//                    if(contador>0){
//                        try{
//                            
//                        red.nuevoArco(red.getVerticeI(indice-1).getNombre(), red.getVerticeI(indice).nombre);
//                        }
//                        catch(Exception e){
//                            
//                        }
//                    }
                }
                
                
                
                contador++;
                indice++;
                
                aux_2 = aux_2.getSiguiente();
                
            }
        }

        aux_1 = aux_1.getSiguiente();
    }
    
    try
    {
        for(int i=0;i<red.getnVert();i++){
            /*if(red.Contiene(red.getVertice(i))){
                red.Conecta(red.getVertice(i));
                }
            else{}
            }*/
            red.ContieneConecta(red.getVerticeI(i));
        }
    }
    catch(Exception e){
        System.out.println("Error");
    }
    System.out.println("llega");   
    return red;
}
    
    public int MaxParadas(ListaSimple ln){
        Nodo aux_1 = ln.pFirst;
        int contador = 0;
        ListaSimple listaparadasSinR= new ListaSimple();
    while (aux_1 != null) {
        if (aux_1.getValor() instanceof Linea) {
            Linea linea1 = (Linea) aux_1.getValor();
            ListaSimple lista_p = linea1.getLista_paradas();  
            Nodo aux_2 = lista_p.pFirst;

            while (aux_2 != null) {
                if(!listaparadasSinR.contiene(aux_2.getValor().toString())){
                    listaparadasSinR.insertarAlPrincipio(aux_2.getValor().toString());
                }
                aux_2=aux_2.getSiguiente();
                
            }
        }

        aux_1 = aux_1.getSiguiente();
    }
        return listaparadasSinR.getSize()+1;
    }


}
