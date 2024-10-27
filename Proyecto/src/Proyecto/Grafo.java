package Proyecto;

public class Grafo {
    private String nombre;
    private int nVert;
    private Vertice[] tablAd;
    private int maxVert;

    /**
     * Constructor del Grafo.
     * @param maxVert Cantidad máxima de vértices que tendrá el grafo.
     * @param nombreRed Nombre de la Red a la cual pertenece el grafo.
     */
    public Grafo(int maxVert, String nombreRed) {
        this.nombre= nombreRed;
        this.maxVert = maxVert;
        this.tablAd=new Vertice[maxVert];
        this.nVert=0;
    }

    /**
     * Devuelve el máximo de vértices del Grafo.
     * @return the maxVert
     */
    public int getMaxVert() {
        return maxVert;
    }

    /**
     * Devuelve el número de vértices del Grafo.
     * @return the nVert
     */
    public int getnVert() {
        //return nVert;
        return this.nVert;
    }
    
    /**
     * Devuelve el nombre del Grafo.
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Devuelve la tabla de adyacencia del Grafo.
     * @return the tablAd
     */
    public Vertice[] getTablAd() {
        return tablAd;
    }
    
    
    
    /**
     * Método que recibe Key/Value donde indíca el número en que se encuentra un vertice compuesto en el grafo.
     * @param key llave.
     * @param value valor de la llave.
     * @return número del vértice donde se encuentra el compuesto.
     */
    public int getNumverticeCompuesto(String key,String value){
     boolean encontrado = false;
        
        for(int i=0;(i<this.tablAd.length-1)&& !encontrado;i++){
            if (this.tablAd[i] != null)
            {
                encontrado=this.tablAd[i].getNombre().equals(key);
                if(encontrado){
                    encontrado=this.tablAd[i].getCompuesto().equals(value);
                    if(encontrado){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    
    /**
     * Método que devuelve el número de la posición donde se encuentra un vértice.
     * @param nombre Nombre del vértice.
     * @return Número del vértice donde esta ubicado.
     */
    public int getNumVertice(String nombre){

        boolean encontrado = false;
        
        for(int i=0;(i<this.tablAd.length)&& !encontrado;i++){
            if (this.tablAd[i] != null)
            {
                encontrado=this.tablAd[i].getNombre().equals(nombre);
                if(encontrado){
                    return i;
                }
            }
        }
        return -1;
        
    }

    /**
     * Método que devuelve el vértice recibiendo el primer índice.
     * @param i índice.
     * @return vértice.
     * @throws Exception 
     */
    public Vertice getVerticeI(int i)throws Exception{
        if (i>this.nVert){
            throw new Exception("Vertice fuera de rango");
        }
        else{
            for(int index=0;index<i;index++){
                
            }
            return this.tablAd[i];
        }
    }
    /**
     * Método que devuelve el vértice recibiendo el segundo índice.
     * @param i índice.
     * @return vértice.
     * @throws Exception 
     */
    public Vertice getVerticeJ(int i) throws Exception {
        
    if (i >= this.nVert) {
        throw new Exception("Vertice fuera de rango");
    }
    for(int index=0;index<this.nVert;index++){
        if(this.tablAd[index].indice2==i)
            return this.tablAd[index];
    }
    return null;
}

     /**
     * Método que devuelve el vértice recibiendo el número del vértice.
     * @param i índice.
     * @return vértice.
     * @throws Exception 
     */
    public Vertice getVerticeN(String parada) {
    try {
        for (int indice = 0; indice < nVert; indice++) {
            Vertice vertice = this.getVerticeI(indice);
            if (parada.equals(vertice.nombre)) {
                return vertice;
            }
        }
    } catch (Exception e) {
        System.out.println("Error obteniendo el vértice:");
    }
    return null; // Devuelve null si no se encuentra el vértice
}

    /**
     * Método que añade un nuevo vértice al grafo.
     * @param nombre Nombre del vértice.
     * @param linea Línea a la que pertenece.
     */
    public void nuevoVertice(String nombre, String linea){
            if(nombre.contains(":")){
                nombre = nombre.replaceAll("[{}\"/\\\\]", "");
                String[] partes = nombre.split(":");
                String key = partes[0];
                String value = partes[1];
                boolean existe= this.getNumverticeCompuesto(key, value)>=0;
                if(!existe){
                    Vertice v = new Vertice(key);
                    v.setIndice(nVert);
                    v.setCompuesto(value);
                    this.tablAd[nVert]=v;
                    this.tablAd[nVert].setLinea1(linea);
                }
                else{
                this.tablAd[this.getNumVertice(key)].setIndiceComplementario(nVert);   
                try{
                this.tablAd[this.getNumVertice(key)].setLinea2(linea);
                nVert--;
                }
                catch(Exception e){
                    
                }
                }
            }
            else{
                Vertice v = new Vertice(nombre);
                v.setIndice(nVert);
                this.tablAd[nVert]=v;
                v.setLinea1(linea);
            }
            
            nVert++;
        
    }

    /**
     * Método que recibe el número de vértice y devuelve su lista de adyacencia.
     * @param v numero de vértoce
     * @return ListaSimple con la lista de adyacencia
     * @throws Exception 
     */
    public ListaSimple getListaAdy(int v)throws Exception{
        if (v<0||v>this.nVert){
            throw new Exception("vertice fuera de rango");
        }
        return this.tablAd[v].lad;
    }
    

    /**
     * Método que verifíca si dos vértices son adyacentes o no.
     * @param a Vértice 1
     * @param bVértice 2
     * @return True si son adyacentes.
     * @throws Exception 
     */
    public boolean isAdyc(String a, String b)throws Exception{
        int v1,v2;
        v1 = this.getNumVertice(a);
        v2 = this.getNumVertice(b);
        if(v1<0||v2<0){
            throw new Exception("El vertice no existe");
        }
        return this.tablAd[v1].lad.contiene(new Arco(b));
    }
    
    /**
     * Método que crea un nuevo arco entre dos vértices.
     * @param a Vértice 1
     * @param b Vértice 2
     * @throws Exception 
     */
    public void nuevoArco(String a, String b)throws Exception{
        if(!isAdyc(a,b)){
            int v1=this.getNumVertice(a);
            int v2=this.getNumVertice(b);
            if(v1<0||v2<0){
                throw new Exception ("El vertice no existe");
            }
            
            Arco ab= new Arco(b);
            Arco ba=new Arco(a);
            
            this.tablAd[v1].lad.insertarSinDuplicado(ab);
            this.tablAd[v2].lad.insertarSinDuplicado(ba);
            
            
            
        }
    }

    /**
     * Método que borra un arco entre dos vértices.
     * @param a Vértice 1
     * @param b Vértice 2
     * @throws Exception 
     */
    public void borrarArco(String a, String b)throws Exception{
        int v1=this.getNumVertice(a);
        int v2=this.getNumVertice(b);
        if(v1<0||v2<0){
            throw new Exception ("El vertie no existe");
        }
        Arco ab=new Arco(b);
        this.tablAd[v1].lad.eliminar(ab);
    }
    
    /**
     * Método que recibe una párada y revisa si el nombre de ésta es igual al nombre complementario  de alguna otra en la red, y si es igual, iguala sus listas de adyacencia.
     * @param parada parada
     * @return True si se igualan las listas de adyacencia
     */
    public boolean ContieneConecta(Vertice parada){
        try{
            int contador =0;
                while(contador<this.tablAd.length -1){
                    Vertice vertCompuesto = this.getVerticeI(contador);
                    if (vertCompuesto != null)
                    {
                        if(parada.nombre.equals(vertCompuesto.compuesto) && !"".equals(vertCompuesto.compuesto)){

                            ListaSimple ListaSimpleparada = parada.lad;
                            ListaSimple ListaSimplecompuesto = vertCompuesto.lad;

                            Nodo nodoArco = ListaSimpleparada.getpFirst();
                            while (nodoArco != null)
                            {
                                ListaSimplecompuesto.insertarSinDuplicado(nodoArco.getValor());
                                nodoArco=nodoArco.getSiguiente();
                            }

                            nodoArco = ListaSimplecompuesto.getpFirst();
                            while (nodoArco != null)
                            {
                                if (!ListaSimpleparada.contiene(nodoArco.getValor()))
                                    ListaSimpleparada.insertarSinDuplicado(nodoArco.getValor());

                                nodoArco=nodoArco.getSiguiente();
                            }

                            return true;
                        }
                        else{
                            contador++;
                        }
                    }
                }
                return false;
        }
        catch(Exception e){
            System.out.println("Error");
            return false;
        }
    }
       
   
    
    public class Vertice{
        String nombre;
        String linea1;
        String linea2;
        String compuesto;
        int indice1;
        int indice2;
        ListaSimple lad;
        
        /**
         * Constructor de la clase Vertice.
         * @param nombre nombre del vértice.
         */
        public Vertice(String nombre) {
            this.nombre = nombre;
            this.linea1="";
            this.linea2="";
            this.compuesto = "";
            this.indice1 = -1;
            this.indice2=-1;
            this.lad= new ListaSimple();
        }

        /**
        * Devuelve el nombre del vértice.
        * @return the nombre
        */
        public String getNombre(){
            return nombre;
        }

        /**
        * Devuelve el indice del vértice.
        * @return the indice1
        */
        public int getIndice1() {
            return indice1;
        }
        
        
        /**
        * Establece la primera linea.
        * @param linea the linea to set
        */
        public void setLinea1(String linea) {
            this.linea1 = linea;
        }

        /**
        * Devuelve una línea a la que pertenece el vértice.
        * @return the linea1
        */
        public String getLinea1() {
            return linea1;
        }
        
        /**
        * Establece la segunda linea.
        * @param linea2 the linea2 to set
        */
        public void setLinea2(String linea2) {
            this.linea2 = linea2;
        }

        /**
        * Devuelve una línea a la que pertenece el vértice.
        * @return the linea2
        */
        public String getLinea2() {
            return linea2;
        }
        
        
        /**
        * Establece el índice del vértice.
        * @param i the i to set
        */
        public void setIndice(int i){
            this.indice1= i;
        }
        /**
        * Establece el índice de ser complementario.
        * @param indice2 the indice2 to set
        */
        public void setIndiceComplementario(int indice2) {
            this.indice2 = indice2;
        }

        /**
        * Devuelve el índice del vértice complementario.
        * @return the indice2
        */
        public int getIndiceComplementario() {
            return indice2;
        }
               

        /**
        * Devuelve el vértice compuesto.
        * @return the compuesto.
        */
        public String getCompuesto() {
            return compuesto;
        }
        
        /**
        * Establece el vértice compuesto.
        * @param compuesto the compuesto to set
        */
        public void setCompuesto(String compuesto) {
            this.compuesto = compuesto;
        }
        
        
        
    }
    
    public class Arco{
        String destino;

        /**
         * Constructor de la clase Arco.
         * @param destino a donde se dirige.
         */
        public Arco(String destino) {
            this.destino = destino;
        }

        /**
        * Devuelve el vértice al que se dirige.
        * @return the destino.
        */ 
        public String getDestino() {
            return destino;
        }          
        
        /**
        * Método que devuelve True si los destinos son iguales.
        * @return True si los destinos son iguales.
        */ 
        @Override
        public boolean equals(Object n){
            Arco a = (Arco)n;
            return destino.equals(a.destino);
        }
    }       
}
