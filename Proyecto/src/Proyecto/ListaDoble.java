/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author HP
 */
public class ListaDoble {
    private NodoDoble pFirst;
    private NodoDoble pLast;
    private int size;

    public ListaDoble() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public boolean EsVacio(){
        return (pFirst == null);   
    }

    public NodoDoble getpFirst() {
        return pFirst;
    }

    public NodoDoble getpLast() {
        return pLast;
    }

    public int getSize() {
        return size;
    }
    
    public <T> NodoDoble getValue( T value){
        NodoDoble aux = this.pFirst;
        while (aux != null){
            if (aux.getValor().equals(value))
                return aux;
            else
                aux = aux.getSiguiente();
        } 
        return aux;        
    }
    
    public <T> void insertarAlFinal(T value){
        NodoDoble newNodo = new NodoDoble();
        newNodo.setValor(value);
        if (this.EsVacio()){
            this.pFirst = newNodo;
            this.pLast = newNodo;
            this.size = 1;
            
        }
        else{
            NodoDoble aux = this.pLast;
            aux.setSiguiente(newNodo);        
            this.pLast = newNodo;
            newNodo.setAnterior(aux);
            this.size += 1; 
        
        }
    }
    
    public <T> void insertarAlPrincipio(T value){
        NodoDoble newNodoDoble = new NodoDoble();
        newNodoDoble.setValor(value);
        if (this.EsVacio()){
            this.pFirst = newNodoDoble;
            this.pLast = newNodoDoble;
        }
        else{
            newNodoDoble.setSiguiente(this.pFirst);
            this.pFirst.setAnterior(newNodoDoble);
            this.pFirst = newNodoDoble;       
        }
        this.size += 1;
    }
    
    public <T> void insertarDespuesDe(T value, T previousValue){
        if (!this.EsVacio()){
            NodoDoble newNodoDoble = new NodoDoble();
            newNodoDoble.setValor(value);
            NodoDoble aux = this.pFirst;
            while (aux != null){
                if (aux.getValor().equals(previousValue)){
                    if(aux.getSiguiente()!= null){
                        aux.getSiguiente().setAnterior(newNodoDoble);
                        newNodoDoble.setSiguiente(aux.getSiguiente());
                        aux.setSiguiente(newNodoDoble);
                        newNodoDoble.setAnterior(aux);
                    }
                    else{
                        aux.setSiguiente(newNodoDoble);
                        newNodoDoble.setAnterior(aux);
                        this.pLast = newNodoDoble;
                    }
                    this.size++;
                    break;
                }                  
                else{
                    aux = aux.getSiguiente();
                }   
            }
        }
    }
    
    public <T> void insertarAntesDe(T value, T nextValue){
        if (!this.EsVacio()){
            NodoDoble newNodoDoble = new NodoDoble();
            newNodoDoble.setValor(value);
            NodoDoble aux = this.pFirst;
            while (aux != null){
                if (aux.getValor().equals(nextValue)){
                    if(aux.getAnterior()!= null){
                        aux.getAnterior().setSiguiente(newNodoDoble);
                        newNodoDoble.setSiguiente(aux);
                        newNodoDoble.setAnterior(aux.getAnterior());
                        aux.setAnterior(newNodoDoble);
                        
                    }
                    else{
                        aux.setAnterior(newNodoDoble);
                        newNodoDoble.setSiguiente(aux);
                        this.pFirst = newNodoDoble;
                    }
                    this.size++;
                    break;
                }                  
                else{
                    aux = aux.getSiguiente();
                }   
            }
        }
    }
    
    public <T> void eliminar (T value){
        NodoDoble ant = null;
        NodoDoble aux = this.pFirst;
        while (aux != null){
            if (aux.getValor().equals(value)){
                if (ant == null){
                    this.pFirst = aux.getSiguiente();
                    this.pFirst.setAnterior(null);
                    break;
                }
                else{
                    ant.setSiguiente(aux.getSiguiente());
                    if (aux.getSiguiente() != null)
                        aux.getSiguiente().setAnterior(ant);
                    
                    break;
                }                
            }
            else{
                ant = aux;
                aux = aux.getSiguiente();
            }    
        }  
    }
    
    public void showList(){
        NodoDoble aux = this.pFirst;
        while (aux != null){
            System.out.println(aux.getValor().toString());
            aux = aux.getSiguiente();
        }
    } 
    
}
