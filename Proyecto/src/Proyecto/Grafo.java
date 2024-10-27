package Proyecto;

public class Grafo {
    private String nombre;
    private int nVert;
    private int t;
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
        this.t = 1;
        this.tablAd=new Vertice[maxVert];
        this.nVert=0;
        
        /*
        Establece t según lo indicado en la documentación
        */
        try{
            if(this.nombre.equals("Transmilenio"))
                this.t = 10;
            else if(this.nombre.equals("Metro de Caracas"))
                this.t = 3;
        }
        catch(Exception e){}
    }

    /**
     * Retorna la frecuencia
     * @return 
     */
    public int getT() {
        return t;
    }
    
    /**
     * Establece la frecuencia
     * @param t 
     */
    public void setT(int t) {
        this.t = t;
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
<<<<<<< HEAD

    public void setnVert(int nVert) {
        this.nVert = nVert;
    }

=======
    
    /**
     * Devuelve el nombre del Grafo.
     * @return the nombre
     */
>>>>>>> Ricardo
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
    
<<<<<<< HEAD
=======
    
    
    /**
     * Método que recibe Key/Value donde indíca el número en que se encuentra un vertice compuesto en el grafo.
     * @param key llave.
     * @param value valor de la llave.
     * @return número del vértice donde se encuentra el compuesto.
     */
>>>>>>> Ricardo
    public int getNumverticeCompuesto(String key,String value){
     boolean encontrado = false;
        
        for(int i=0;(i<this.getTablAd().length-1)&& !encontrado;i++){
            if (this.getTablAd()[i] != null)
            {
                encontrado=this.getTablAd()[i].getNombre().equals(key);
                if(encontrado){
                    encontrado=this.getTablAd()[i].getCompuesto().equals(value);
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
        
        for(int i=0;(i<this.getTablAd().length)&& !encontrado;i++){
            if (this.getTablAd()[i] != null)
            {
                encontrado=this.getTablAd()[i].getNombre().equals(nombre);
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
        if (i>this.getnVert()){
            throw new Exception("Vertice fuera de rango");
        }
        else{
            for(int index=0;index<i;index++){
                
            }
            return this.getTablAd()[i];
        }
    }
    /**
     * Método que devuelve el vértice recibiendo el segundo índice.
     * @param i índice.
     * @return vértice.
     * @throws Exception 
     */
    public Vertice getVerticeJ(int i) throws Exception {
        
    if (i >= this.getnVert()) {
        throw new Exception("Vertice fuera de rango");
    }
    for(int index=0;index<this.getnVert();index++){
        if( this.getTablAd()[index].getIndice2()==i)
            return this.getTablAd()[index];
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
        for (int indice = 0; indice < getnVert(); indice++) {
            Vertice vertice = this.getVerticeI(indice);
            if (parada.equals(vertice.getNombre())) {
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
                    v.setIndice(getnVert());
                    v.setCompuesto(value);
                    this.getTablAd()[getnVert()]=v;
                    this.getTablAd()[getnVert()].setLinea1(linea);
                }
                else{
                    this.getTablAd()[this.getNumVertice(key)].setIndiceComplementario(getnVert());   
                try{
                    this.getTablAd()[this.getNumVertice(key)].setLinea2(linea);
                    setnVert(getnVert() - 1);
                }
                catch(Exception e){
                    
                }
                }
            }
            else{
                Vertice v = new Vertice(nombre);
                v.setIndice(getnVert());
                this.getTablAd()[getnVert()]=v;
                v.setLinea1(linea);
            }
            
            setnVert(getnVert() + 1);
        
    }

    /**
     * Método que recibe el número de vértice y devuelve su lista de adyacencia.
     * @param v numero de vértoce
     * @return ListaSimple con la lista de adyacencia
     * @throws Exception 
     */
    public ListaSimple getListaAdy(int v)throws Exception{
        if (v<0||v>this.getnVert()){
            throw new Exception("vertice fuera de rango");
        }
        return this.getTablAd()[v].getLad();
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
<<<<<<< HEAD
        if(this.getTablAd()[v1].getLad().contiene(new Arco(b))){
            return true;
        }
        else{
            return false;
        }
=======
        return this.tablAd[v1].lad.contiene(new Arco(b));
>>>>>>> Ricardo
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
            
            this.getTablAd()[v1].getLad().insertarSinDuplicado(ab);
            this.getTablAd()[v2].getLad().insertarSinDuplicado(ba);
            
            
            
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
        this.getTablAd()[v1].getLad().eliminar(ab);
    }
    
<<<<<<< HEAD
    
    public boolean Contiene(Vertice parada){
        try{
            


                int contador =0;
                while(contador<this.getTablAd().length -1){
                    Vertice vertCompuesto = this.getVerticeI(contador);
                    if(parada.getNombre().equals(vertCompuesto.getCompuesto()) && vertCompuesto.getCompuesto() != ""){
                        return true;
                    }
                    else{
                        contador++;
                    }
                }
                return false;
            
            
        }
        catch(Exception e){
            System.out.println("Error");
            return false; //Lo pongo porque sino sale error
        }
    }
    

    
=======
    /**
     * Método que recibe una párada y revisa si el nombre de ésta es igual al nombre complementario  de alguna otra en la red, y si es igual, iguala sus listas de adyacencia.
     * @param parada parada
     * @return True si se igualan las listas de adyacencia
     */
>>>>>>> Ricardo
    public boolean ContieneConecta(Vertice parada){
        try{
            int contador =0;
                while(contador<this.getTablAd().length -1){
                    Vertice vertCompuesto = this.getVerticeI(contador);
                    if (vertCompuesto != null)
                    {
                        if(parada.getNombre().equals(vertCompuesto.getCompuesto()) && !"".equals(vertCompuesto.compuesto)){

                            ListaSimple ListaSimpleparada = parada.getLad();
                            ListaSimple ListaSimplecompuesto = vertCompuesto.getLad();

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
<<<<<<< HEAD
    
    //revisar
    public void Conecta(Vertice parada){
        try{
            int contador=0;
            for(contador=0;contador<this.getnVert()-1;contador++){
                if(parada.getNombre().equals(this.getVerticeI(contador).getCompuesto())){
                    Nodo temp= this.getVerticeI(contador).getLad().getpFirst();
                    for(int i=0;i<this.getVerticeI(contador).getLad().getSize()-1;i++){
                        parada.getLad().insertarAlPrincipio(temp);
                        temp=temp.getSiguiente();
                    }
                    
                }
            }
            this.getVerticeI(contador).setLad(parada.getLad());
            
        }
        catch(Exception e){
            System.out.println("Error");
        }
        
    }

    
    
=======
       
   
>>>>>>> Ricardo
    
    public class Vertice{
        private String nombre;
        private String linea1;
        private String linea2;
        private String compuesto;
        private int indice1;
        private int indice2;
        private ListaSimple lad;
        private boolean sucursal;
        
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
            this.sucursal=false;
        }

<<<<<<< HEAD
        public boolean isSucursal() {
            return sucursal;
        }

        public void setSucursal(boolean sucursal) {
            this.sucursal = sucursal;
        }

        

                
=======
        /**
        * Devuelve el nombre del vértice.
        * @return the nombre
        */
>>>>>>> Ricardo
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
            this.setIndice1(i);
        }
        /**
        * Establece el índice de ser complementario.
        * @param indice2 the indice2 to set
        */
        public void setIndiceComplementario(int indice2) {
            this.setIndice2(indice2);
        }

        /**
        * Devuelve el índice del vértice complementario.
        * @return the indice2
        */
        public int getIndiceComplementario() {
            return getIndice2();
        }
<<<<<<< HEAD
        
        
        
        public boolean nIgual(String d){
            Vertice temp= new Vertice(d);
            return this.getNombre().equals(temp.getNombre());
        }
        
        public String aStr(){
            return this.getNombre() + "("+this.getIndice1()+")";
        }
=======
               
>>>>>>> Ricardo

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

        /**
         * @param nombre the nombre to set
         */
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        /**
         * @param indice1 the indice1 to set
         */
        public void setIndice1(int indice1) {
            this.indice1 = indice1;
        }

        /**
         * @return the indice2
         */
        public int getIndice2() {
            return indice2;
        }

        /**
         * @param indice2 the indice2 to set
         */
        public void setIndice2(int indice2) {
            this.indice2 = indice2;
        }

        /**
         * @return the lad
         */
        public ListaSimple getLad() {
            return lad;
        }

        /**
         * @param lad the lad to set
         */
        public void setLad(ListaSimple lad) {
            this.lad = lad;
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
<<<<<<< HEAD
    }

    @Override
    public String toString() {
        return "Grafo{" + "nombre=" + getNombre() + ", nVert=" + getnVert() + ", tablAd=" + getTablAd() + ", maxVert=" + getMaxVert() + '}';
    }
    
    public boolean existeArco(int v, int j){
        try{
            Vertice verticeBase = this.getVerticeI(v);
            Vertice verticeDestino = this.getVerticeI(j);
            Nodo auxNodoBase = verticeBase.getLad().getpFirst();
            while(auxNodoBase != null){
                Arco arco = (Arco)auxNodoBase.getValor();
                if(verticeDestino.getNombre().equals(arco.getDestino()))
                    return true;
                else
                    if (auxNodoBase.getSiguiente()!=null)
                        auxNodoBase = auxNodoBase.getSiguiente();
                    else
                        return false;
            }            
        }
        catch(Exception e){
        
        }
        return false;
        
    }      
=======
    }       
>>>>>>> Ricardo
}
