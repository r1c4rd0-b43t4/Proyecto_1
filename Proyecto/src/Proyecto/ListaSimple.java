package Proyecto;

import Proyecto.Grafo.Vertice;
import javax.swing.JOptionPane;
 
/**
 * Clase ListaSimple donde se crea una colección de objetos agrupadas en una lista.
 */
public class ListaSimple {
    private Nodo pFirst;
    private Nodo pLast;
    private int size;

    /**
     * Constructor de una ListaSimple vacía.
     */
    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Método que indica si una ListaSimple está vacía o no.
     * @return True si la ListaSimple está vacía.
     */
    public boolean EsVacio(){
        return (getpFirst() == null);   
    }
    
    /**
     * Método que vacía la lista simple.
     */
    public void limpiar() {
        pFirst = null;
    }

    
     /**
     * Devuelve el primer Nodo de la ListaSimple.
     * @return the pFirst.
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Devuelve el último Nodo de la ListaSimple.
     * @return the pLast.
     */
    public Nodo getpLast() {
        return pLast;
    }

    
    /**
     * Devuelve el tamaño de la ListaSimple.
     * @return the size.
     */
    public int getSize() {
        return size;
    }
    
    
    /**
     * Método que recibe un valor genérico y devuelve el nodo al que pertenece.
     * @param <T> Tipo de valor.
     * @param value Valor.
     * @return Nodo al que pertenece.
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
     * Método que inserta un objeto genérico al final de la ListaSimple.
     * @param <T> Tipo de valor.
     * @param value Valor.
     */
    public <T> void insertarAlFinal(T value){
        
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        if (this.EsVacio()){
            this.pFirst = newNodo;
        }
        else{
            Nodo aux = this.getpLast();
            aux.setSiguiente(newNodo);
        
        }
        this.pLast = newNodo;
        this.size += 1;
    }
    
    
    /**
     * Método que inserta un objeto genérico al principio de la ListaSimple.
     * @param <T> Tipo de valor.
     * @param value Valor.
     */
    public <T> void insertarAlPrincipio(T value){
        Nodo newNodo = new Nodo();
        newNodo.setValor(value);
        if (this.EsVacio()){
            this.pLast = newNodo;
        }
        newNodo.setSiguiente(this.getpFirst());
        this.pFirst = newNodo;
        this.size += 1;
    }
    
    /**
     * Método que elimina un objeto genérico de la ListaSimple.
     * @param <T> Tipo de valor.
     * @param value Valor.
     */
    public <T> void eliminar (T value){
        Nodo ant = null;
        Nodo aux = this.getpFirst();
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
    
    
    /**
     * Método que muestra los objetos de la ListaSimple.
     */
    public void showList(){
        Nodo aux = this.getpFirst();
        while (aux != null){
            aux = aux.getSiguiente();
        }

    }
    
    
    /**
     * Método que devuelve True si un objeto genérico existe en la ListaSimple.
     * @param <T> Tipo de valor.
     * @param value Valor.
     * @return True si el objeto existe en la ListaSimple.
     */
    public <T> boolean contiene(T value){
        Nodo temp=getpFirst();
        while(temp!=null){
            if(temp.getValor().equals(value)){
                return true;
            }
            temp=temp.getSiguiente();
        }
        return false;
    }
    
    
    /**
     * Método que inserta un objeto al principio de la ListaSimple pero verificando si ya el objeto existe.
     * @param valor Valor.
     */
    public void insertarSinDuplicado(Object valor) {
        if (!contiene(valor)) {
            this.insertarAlPrincipio(valor);
        }
    }
    
    /**
     * Método que crea un Grafo recibiendo una lista con las lineas de la red de transporte y el nombre de la red a la cual pertenecen, donde además se establecen los vértices y aristas correctamente, de acuerdo al archivo JSON ingresado.
     * @param lista_lineas ListaSimple donde estén las paradas.
     * @param nombreRed Nombre de la red a la cual pertenecen las líneas.
     * @return Grafo con las paradas de cada linea pertenecientes a una red en específico.
     */
    public Grafo CrearGrafo(ListaSimple lista_lineas,String nombreRed) {
        Nodo aux_1 = lista_lineas.getpFirst();
        int maxVert=0;
        maxVert=this.MaxParadas(lista_lineas);
        Grafo red = new Grafo(maxVert,nombreRed);
        aux_1 = lista_lineas.getpFirst();
        int indice = 0;
        while (aux_1 != null) {
            if (aux_1.getValor() instanceof Linea linea) {
                ListaSimple lista_p = linea.getLista_paradas();  
                Nodo aux_2 = lista_p.getpFirst();
                int contador = 0;
                while (aux_2 != null) { 
                    boolean existe= red.getNumVertice(aux_2.getValor().toString())>=0;
                if(!existe){
                        red.nuevoVertice(aux_2.getValor().toString(),linea.getNombre_linea());
                        if(contador>0){
                            try{
                                Vertice actual= red.getTablAd()[indice];
                                Vertice revisar=red.getVerticeJ(indice-1);
                                String anterior=red.getTablAd()[indice-1].getNombre();
                                if(revisar!=null){
                                    if(red.getVerticeJ(indice-1).getIndiceComplementario()>0){
                                        red.nuevoArco(revisar.getNombre(), actual.getNombre());
                                    }
                                    else if(red.getVerticeI(indice).getLinea1().equals(red.getVerticeJ(indice-1).getLinea2())){
                                        red.nuevoArco(actual.getNombre(), revisar.getNombre());
                                    }
                                }
                                else{
                                    red.nuevoArco(anterior, actual.getNombre());
                                }
                            }
                            catch(Exception e){ 
                                JOptionPane.showMessageDialog(null, "Error");
                            }
                        }
                    }
                    else{
                        Vertice vertice=red.getVerticeN(aux_2.getValor().toString());
                        vertice.setIndiceComplementario(red.getnVert());
                        vertice.setLinea2(linea.getNombre_linea()); 
                        if(contador>0){
                            try{
                                
                                if(red.getVerticeI(indice-1).getIndice1()==vertice.getIndiceComplementario()-1 && !vertice.getLinea2().equals(red.getVerticeI(indice-1).getLinea2())){
                                    red.nuevoArco(vertice.getNombre(), red.getVerticeI(indice-1).getNombre());
                                }
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Error");
                            }
                        }
                    } 
                    contador++;
                    indice++;
                    aux_2 = aux_2.getSiguiente(); 
                }
            }
            aux_1 = aux_1.getSiguiente(); 
        }
        try{
            Nodo nodolinea = lista_lineas.getpFirst();
            String paradaAnterior= "";
            while (nodolinea != null) {
                if (nodolinea.getValor() instanceof Linea linea1) {
                    ListaSimple lista_p = linea1.getLista_paradas(); 
                    Nodo nodoParada = lista_p.getpFirst();
                    while (nodoParada != null) {
                        String paradaActual=nodoParada.getValor().toString();
                        if(paradaActual.contains(":")){
                            paradaActual = paradaActual.replaceAll("[{}\"/\\\\]", "");
                            String[] partes = paradaActual.split(":");
                            paradaActual = partes[0];
                        }
                        if(!"".equals(paradaAnterior)){
                            red.nuevoArco(paradaActual, paradaAnterior);
                        }
                        paradaAnterior=paradaActual;
                        nodoParada = nodoParada.getSiguiente();
                    }
                }
                paradaAnterior="";
                nodolinea = nodolinea.getSiguiente();
            }  
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        try
        {
            for(int i=0;i<red.getnVert();i++){
                red.ContieneConecta(red.getVerticeI(i));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        return red;
    }

    /**
     * Método que recibe la Lista de Líneas e indica cual es la cantidad máxima de paradas presente en la lista de Lineas, tomando en cuenta cada una.
     * @param ln ListaSimple con las líneas.
     * @return Número máximo de paradas pertenecientes a la lista simple de líneas.
     */
    public int MaxParadas(ListaSimple ln){
        Nodo aux_1 = ln.getpFirst();
        ListaSimple listaparadasSinR= new ListaSimple();
    while (aux_1 != null) {
        if (aux_1.getValor() instanceof Linea linea1) {
            ListaSimple lista_p = linea1.getLista_paradas();  
            Nodo aux_2 = lista_p.getpFirst();

            while (aux_2 != null) {
                if(!listaparadasSinR.contiene(aux_2.getValor().toString())){
                    listaparadasSinR.insertarAlPrincipio(aux_2.getValor().toString());
                }
                aux_2=aux_2.getSiguiente();   
            }
        }
        aux_1 = aux_1.getSiguiente();
    }
        return listaparadasSinR.getSize();
    } 
}
