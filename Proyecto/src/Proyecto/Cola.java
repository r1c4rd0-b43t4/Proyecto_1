package Proyecto;

/**
 *Clase Cola donce se crea la colección de objetos tipo cola.
 * @param <T>
 */
public class Cola <T> {

    private Nodo pFirst;
    private Nodo pLast;
    private int size;


    /**
     * Constructor de una nueva Cola.
     */
    public Cola() {
        this.size = 0;
        this.pFirst = null;
        this.pLast = null;
    }
    
    /**
     * Devuelve el primer Nodo.
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer Nodo.
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Devuelve el último Nodo.
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * Establece el último Nodo.
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * Devuelve el tamaño de la Cola.
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la Cola.
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }


    /**
     * Método que indica si una Cola está vacía o no.
     * @return True si la Cola está vacia.
     */
    public boolean EsVacio(){
        return (getpFirst() == null);   
    }
    
    
    /**
     * Método que recibe un objeto genérico y lo encola en la Cola.
     * @param <T> Tipo de valor.
     * @param value Valor.
     */
    public <T> void encolar(T value){
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        
        if (this.getpFirst() == null){
            this.setpFirst(newNodo);
            this.setpLast(newNodo);
        }
        else{
            this.getpLast().setSiguiente(newNodo);
            this.setpLast(newNodo);
            
        }
        this.setSize(this.getSize() + 1);
        
    
    }
    
    /**
     * Método que recibe un objeto genérico y busca el Nodo al cual pertenece en la Cola.
     * @param <T> Tipo de valor.
     * @param value Valor.
     * @return Nodo del objeto genérico deseado.
     */
    public <T> Nodo getValue( T value){
        Nodo aux = this.getpFirst();
        while (aux != null){
            if (aux.getValor().equals(value))
                return aux;
            else
                aux = aux.getSiguiente();
        } 
        return aux;        
    }
    

    /**
     * Método que permite desencolar una Cola.
     */
    public Nodo desencolar(){
        Nodo aux = this.pFirst;
        if (!this.EsVacio()){
            this.setpFirst(this.getpFirst().getSiguiente());
            aux.setSiguiente(null);
            this.setSize(this.getSize() - 1);
            if (this.getpFirst() == null)
                this.setpLast(null);  
        }
        return aux;
    }  
}
