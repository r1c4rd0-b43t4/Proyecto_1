package Proyecto;



public class Grafo {
    
    private String nombre;
    private int nVert;
    private int t;
    private Vertice[] tablAd;
    private int maxVert;

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

    public int getMaxVert() {
        return maxVert;
    }

    public int getnVert() {
        //return nVert;
        return this.nVert;
    }

    public void setnVert(int nVert) {
        this.nVert = nVert;
    }

    public String getNombre() {
        return nombre;
    }

    public Vertice[] getTablAd() {
        return tablAd;
    }
    
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
    //buscar con el indice1
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
    //buscar con el indice2
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
                //si ya existe no tiene que crear nada, pero igual al final de este metodo siempre se suma 1 al nVert
                }
            }
            // no compuestos
            else{
                Vertice v = new Vertice(nombre);
                v.setIndice(getnVert());
                this.getTablAd()[getnVert()]=v;
                v.setLinea1(linea);
            }
            
            setnVert(getnVert() + 1);
        
    }

    public ListaSimple getListaAdy(int v)throws Exception{
        if (v<0||v>this.getnVert()){
            throw new Exception("vertice fuera de rango");
        }
        return this.getTablAd()[v].getLad();
    }
    
    //Comprueba si dos vertices son adyacentes.
    public boolean isAdyc(String a, String b)throws Exception{
        int v1,v2;
        v1 = this.getNumVertice(a);
        v2 = this.getNumVertice(b);
        if(v1<0||v2<0){
            throw new Exception("El vertice no existe");
        }
        if(this.getTablAd()[v1].getLad().contiene(new Arco(b))){
            return true;
        }
        else{
            return false;
        }
    }
    
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
    
    public void borrarArco(String a, String b)throws Exception{
        int v1=this.getNumVertice(a);
        int v2=this.getNumVertice(b);
        if(v1<0||v2<0){
            throw new Exception ("El vertie no existe");
        }
        Arco ab=new Arco(b);
        this.getTablAd()[v1].getLad().eliminar(ab);
    }
    
    
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

                            //ListaSimpleparada = ListaSimplecompuesto;

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
            return false; //Lo pongo porque sino sale error
        }
    }
    
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

    
    
    
    public class Vertice{
        private String nombre;
        private String linea1;
        private String linea2;
        private String compuesto;
        private int indice1;
        private int indice2;
        private ListaSimple lad;
        private boolean sucursal;
        
        //añadir parametro linea1 
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

        public boolean isSucursal() {
            return sucursal;
        }

        public void setSucursal(boolean sucursal) {
            this.sucursal = sucursal;
        }

        

                
        public String getNombre(){
            return nombre;
        }

        public int getIndice1() {
            return indice1;
        }
        
        

        public void setLinea1(String linea) {
            this.linea1 = linea;
        }

        public String getLinea1() {
            return linea1;
        }

        public void setLinea2(String linea2) {
            this.linea2 = linea2;
        }

        public String getLinea2() {
            return linea2;
        }
        
        
        
        public void setIndice(int i){
            this.setIndice1(i);
        }

        public void setIndiceComplementario(int indice2) {
            this.setIndice2(indice2);
        }

        public int getIndiceComplementario() {
            return getIndice2();
        }
        
        
        
        public boolean nIgual(String d){
            Vertice temp= new Vertice(d);
            return this.getNombre().equals(temp.getNombre());
        }
        
        public String aStr(){
            return this.getNombre() + "("+this.getIndice1()+")";
        }

        public String getCompuesto() {
            return compuesto;
        }

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

        public Arco(String destino) {
            this.destino = destino;
        }

        public String getDestino() {
            return destino;
        }          
        
        
        public boolean equals(Object n){
            Arco a = (Arco)n;
            return destino.equals(a.destino);
        }
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
}
