/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author HP
 * @param <T>
 */
public class NodoDoble <T> {
    private T valor;
    private NodoDoble <T> siguiente;
    private NodoDoble <T> anterior;

    public NodoDoble(T valor, NodoDoble<T> siguiente, NodoDoble<T> anterior) {
        this.valor = valor;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public NodoDoble() {
        this.valor = null;
        this.siguiente = null;
        this.anterior = null;   
    }
    
    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }
    
    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble <T> siguiente) {
        this.siguiente = siguiente;
    }
    
}
