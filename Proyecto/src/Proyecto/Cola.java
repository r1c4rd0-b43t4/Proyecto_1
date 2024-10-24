/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Proyecto;

/**
 *
 * @author HP
 */
public class Cola {

    Nodo pFirst;
    Nodo pLast;
    int size;

    public Cola() {
        this.size = 0;
        this.pFirst = null;
        this.pLast = null;
    }

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }
    
    public boolean EsVacio(){
        return (pFirst == null);   
    }
    
    public <T> void encolar(T value){
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        
        if (this.pFirst == null){
            this.pFirst = newNodo;
            this.pLast = newNodo;
        }
        else{
            this.pLast.setSiguiente(newNodo);
            this.pLast = newNodo;
            
        }
        this.size++;
        
    
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
    
    public void desencolar(){
        Nodo aux = this.pFirst;
        if (!this.EsVacio()){
            this.pFirst = this.pFirst.getSiguiente();
            aux.setSiguiente(null);
            this.size--;
            if (this.pFirst == null)
                this.pLast = null;  
        }
    }  
}
