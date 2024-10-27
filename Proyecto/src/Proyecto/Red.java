package Proyecto;

/**
 *Clase Red donde se crea un objeto que contiene las líneas de la Red de transporte.
 */
public class Red {
    private String nombre_red;
    private  ListaSimple lista_lineas;
    
    /**
     * Constructor clase Red.
     * @param nombre_red Nombre de la Red creada.
     * @param lista_lineas <code>ListaSimple</code> donde se encuentran las líneas asociadas a la red.
     */
    public Red(String nombre_red, ListaSimple lista_lineas) {
        this.nombre_red = nombre_red;
        this.lista_lineas = lista_lineas;
    }
    
    /**
     * Constructor Red nueva.
     */
    public Red() {
        this.nombre_red = nombre_red;
        this.lista_lineas = new ListaSimple();
    }

    /**
     * Devuelve el nombre de la red.
     * @return the nombre_red.
     */
    public String getNombre_red() {
        return nombre_red;
    }

    /**
     * Establece el nombre de la red.
     * @param nombre_red the nombre_red to set.
     */
    public void setNombre_red(String nombre_red) {
        this.nombre_red = nombre_red;
    }

    /**
     * Devuelve la lista de líneas.
     * @return the lista_lineas.
     */
    public ListaSimple getLista_lineas() {
        return lista_lineas;
    }

    /**
     * Establece la ListaSimple de líneas.
     * @param lista_lineas the lista_líneas to set.
     */
    public void setLista_lineas(ListaSimple lista_lineas) {
        this.lista_lineas = lista_lineas;
    }

}
