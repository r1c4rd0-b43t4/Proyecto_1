package Proyecto;

/**
 *Clase Nodo para ListaSimple donde se admite cualquier valor genérico.
 * @param <T>
 */
public class Nodo <T> {
    private T valor;
    private Nodo <T> siguiente;

    /**
     * Constructor de la clase Nodo con parámetros.
     * @param valor Valor del nodo.
     * @param siguiente Apuntador al siguiente nodo.
     */
    public Nodo(T valor, Nodo<T> siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }

    /**
     * Constructor de Nodo sin parámetros.
     */
    public Nodo() {
        this.valor = null;
        this.siguiente = null;
        
    }

    /**
     * Devuelve el valor del Nodo.
     * @return the valor
     */
    public T getValor() {
        return valor;
    }

    /**
     * Establece el valor del Nodo.
     * @param valor the valor to set
     */
    public void setValor(T valor) {
        this.valor = valor;
    }

    /**
     * Devuelve el siguiente Nodo.
     * @return the siguiente
     */
    public Nodo <T> getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el siguiente Nodo.
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo <T> siguiente) {
        this.siguiente = siguiente;
    }
 
    
}
