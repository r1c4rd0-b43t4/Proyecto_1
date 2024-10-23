
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;
 
import Proyecto.Grafo.Vertice;
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
//            Linea linea = (Linea) aux_1.getValor();
//            ListaSimple lista_p = linea.getLista_paradas();  // Supongamos que tienes un método para obtener las paradas
//            Nodo aux_2 = lista_p.pFirst;
//            System.out.println(linea.getNombre_linea());
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
    while (aux_1 != null) {
        if (aux_1.getValor() instanceof Linea) {
            Linea linea = (Linea) aux_1.getValor();
            ListaSimple lista_p = linea.getLista_paradas();
            maxVert=+lista_p.getSize();
        }
    }
    Grafo red = new Grafo(maxVert,nombreRed);
    aux_1 = lista_lineas.pFirst;
    while (aux_1 != null) {
        if (aux_1.getValor() instanceof Linea) {
            Linea linea = (Linea) aux_1.getValor();
            ListaSimple lista_p = linea.getLista_paradas();  // Supongamos que tienes un método para obtener las paradas
            Nodo aux_2 = lista_p.pFirst;
            int contador = 0;
            int conector = 0;
            int indice = 0;
            System.out.println(linea.getNombre_linea());

            while (aux_2 != null) {
                System.out.println(aux_2.getValor());
                red.nuevoVertice(aux_2.getValor().toString());
                try{
                    red.getVertice(indice).setLinea(linea.getNombre_linea());
                }
                catch(Exception e){
                    System.out.println("Error");
                }
                
                
                if(0<contador && conector>0){
                    try{
                    red.nuevoArco(red.getVertice(indice-1).getNombre(), red.getVertice(indice).nombre);
                    }
                    catch(Exception e){
                        System.out.println("error");
                    }
                }
                conector++;
                contador++;
                indice++;
                
                if(aux_2.getSiguiente()==null){
                    conector=0;
                    contador=0;
                }
                
                aux_2 = aux_2.getSiguiente();
                
            }
        }

        aux_1 = aux_1.getSiguiente();
    }
    
    try{
    for(int i=0;i<red.getnVert();i++){
        if(red.Contiene(red.getVertice(i))){
            red.Conecta(red.getVertice(i));
            }
        else{}
        }
    
    }
    catch(Exception e){
        
    }
        
    return red;
}
    
//    public int MaxParadas(ListaSimple ln){
//        Nodo aux_1 = ln.pFirst;
//        int contador = 0;
//
//    while (aux_1 != null) {
//        if (aux_1.getValor() instanceof Linea) {
//            Linea linea = (Linea) aux_1.getValor();
//            ListaSimple lista_p = linea.getLista_paradas();  
//            Nodo aux_2 = lista_p.pFirst;
//
//            while (aux_2 != null) {
//                contador++;
//                aux_2 = aux_2.getSiguiente();
//            }
//        }
//
//        aux_1 = aux_1.getSiguiente();
//    }
//        return contador;
//    }


}
