package Proyecto;

/**
 *Clase Linea donde se crea un objeto tipo Linea, que contiene una ListaSimple de paradas, a las cuales se le hace una relación con una Línea en específico, siendo el nombre de la Línea el parámetro nombre_linea.
 */
public class Linea {
    private String nombre_linea;
    private ListaSimple lista_paradas;

    /**
     * Constructor de la clase Línea.
     * @param nombre_linea Nombre de la línea.
     * @param lista_paradas ListaSimple de las paradas las cuales respectan a la Línea específica.
     */
    public Linea(String nombre_linea, ListaSimple lista_paradas) {
        this.nombre_linea = nombre_linea;
        this.lista_paradas = lista_paradas;
    }
    
    /**
     * Constructor de nueva Linea.
     */
    public Linea() {
        this.nombre_linea = nombre_linea;
        ListaSimple lista = new ListaSimple();
        this.lista_paradas = lista;
    }

    /**
     * Devuelve el nombre de la línea.
     * @return the nombre_linea
     */
    public String getNombre_linea() {
        return nombre_linea;
    }

    /**
     * Establece el nombre de la línea.
     * @param nombre_linea the nombre_linea to set
     */
    public void setNombre_linea(String nombre_linea) {
        this.nombre_linea = nombre_linea;
    }

    /**
     * Devuelve la ListaSimple con las paradas de la línea.
     * @return the lista_paradas
     */
    public ListaSimple getLista_paradas() {
        return lista_paradas;
    }

    /**
     * Establece la lista de paradas.
     * @param lista_paradas the lista_paradas to set
     */
    public void setLista_paradas(ListaSimple lista_paradas) {
        this.lista_paradas = lista_paradas;
    }
   
}
