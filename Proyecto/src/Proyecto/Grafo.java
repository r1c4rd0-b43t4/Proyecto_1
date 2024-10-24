package Proyecto;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;


public class Grafo {
    
    private String nombre;
    private int nVert;
    private Vertice[] tablAd;
    private int maxVert;

    public Grafo(int maxVert, String nombreRed) {
        this.nombre= nombreRed;
        this.maxVert = maxVert;
        this.tablAd=new Vertice[maxVert];
        this.nVert=0;
    }

    public int getnVert() {
        //return nVert;
        return this.tablAd.length;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    public int getNumVertice(String nombre){

        boolean encontrado = false;
        
        for(int i=0;(i<this.tablAd.length-1)&& !encontrado;i++){
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
    //buscar con el indice1
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
    //buscar con el indice2
    public Vertice getVerticeJ(int i)throws Exception{
        if (i>this.nVert){
            throw new Exception("Vertice fuera de rango");
        }
        else{
            for(int index=0;index<i;index++){
                if(this.getVerticeI(index).indice2==i){
                   break;
                }
            }
            return this.tablAd[i];
        }
    }
    //poner que regresa un vertice
    public Vertice gerVerticeN(String parada){
        int indice=0;
        try{
            while(indice<nVert){
                if(parada.equals(this.getVerticeI(indice).nombre)){
                    return this.getVerticeI(indice);
                }
                indice++;
            }
            return null;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public void nuevoVertice(String nombre){
            if(nombre.contains(":")){
                nombre=nombre.replaceAll("[{}\"]", "");
                String[] partes = nombre.split(":");
                String key = partes[0];
                String value = partes[1];
              
                Vertice v = new Vertice(key);
                v.setIndice(nVert);
                v.setCompuesto(value);
                
                this.tablAd[nVert]=v;
            }
            else{
                Vertice v = new Vertice(nombre);
                v.setIndice(nVert);
                this.tablAd[nVert]=v;
            }
            
            nVert++;
        
    }

    public ListaSimple getListaAdy(int v)throws Exception{
        if (v<0||v>this.nVert){
            throw new Exception("vertice fuera de rango");
        }
        return this.tablAd[v].lad;
    }
    
    //Comprueba si dos vertices son adyacentes.
    public boolean isAdyc(String a, String b)throws Exception{
        int v1,v2;
        v1 = this.getNumVertice(a);
        v2 = this.getNumVertice(b);
        if(v1<0||v2<0){
            throw new Exception("El vertice no existe");
        }
        if(this.tablAd[v1].lad.contiene(new Arco(b))){
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
            
            this.tablAd[v1].lad.insertarAlPrincipio(ab);
            this.tablAd[v2].lad.insertarAlPrincipio(ba);
            
            
            
        }
    }
    
    public void borrarArco(String a, String b)throws Exception{
        int v1=this.getNumVertice(a);
        int v2=this.getNumVertice(b);
        if(v1<0||v2<0){
            throw new Exception ("El vertie no existe");
        }
        Arco ab=new Arco(b);
        this.tablAd[v1].lad.eliminar(ab);
    }
    
    
    public boolean Contiene(Vertice parada){
        try{
            


                int contador =0;
                while(contador<this.tablAd.length -1){
                    Vertice vertCompuesto = this.getVerticeI(contador);
                    if(parada.nombre.equals(vertCompuesto.compuesto) && vertCompuesto.compuesto != ""){
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
                while(contador<this.tablAd.length -1){
                    Vertice vertCompuesto = this.getVerticeI(contador);
                    if (vertCompuesto != null)
                    {
                        if(parada.nombre.equals(vertCompuesto.compuesto) && vertCompuesto.compuesto != ""){

                            ListaSimple ListaSimpleparada = parada.lad;
                            ListaSimple ListaSimplecompuesto = vertCompuesto.lad;

                            Nodo nodoArco = ListaSimpleparada.getpFirst();
                            while (nodoArco != null)
                            {
                                ListaSimplecompuesto.insertarAlFinal(nodoArco.getValor());
                                nodoArco=nodoArco.getSiguiente();
                            }

                            //ListaSimpleparada = ListaSimplecompuesto;

                            nodoArco = ListaSimplecompuesto.getpFirst();
                            while (nodoArco != null)
                            {
                                if (!ListaSimpleparada.contiene(nodoArco.getValor()))
                                    ListaSimpleparada.insertarAlFinal(nodoArco.getValor());

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
            for(contador=0;contador<this.nVert-1;contador++){
                if(parada.nombre.equals(this.getVerticeI(contador).compuesto)){
                    Nodo temp= this.getVerticeI(contador).lad.getpFirst();
                    for(int i=0;i<this.getVerticeI(contador).lad.getSize()-1;i++){
                        parada.lad.insertarAlPrincipio(temp);
                        temp=temp.getSiguiente();
                    }
                    
                }
            }
            this.getVerticeI(contador).lad=parada.lad;
            
        }
        catch(Exception e){
            System.out.println("Error");
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
        
        //añadir parametro linea1 
        public Vertice(String nombre) {
            this.nombre = nombre;
            this.linea1="";
            this.linea2="";
            this.compuesto = "";
            this.indice1 = -1;
            this.indice2=-1;
            this.lad= new ListaSimple();
        }

        public String getNombre(){
            return nombre;
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
            this.indice1= i;
        }

        public void setIndiceComplementario(int indice2) {
            this.indice2 = indice2;
        }
        
        
        
        public boolean nIgual(String d){
            Vertice temp= new Vertice(d);
            return this.nombre.equals(temp.nombre);
        }
        
        public String aStr(){
            return this.nombre + "("+this.indice1+")";
        }

        public String getCompuesto() {
            return compuesto;
        }

        public void setCompuesto(String compuesto) {
            this.compuesto = compuesto;
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
        return "Grafo{" + "nombre=" + nombre + ", nVert=" + nVert + ", tablAd=" + tablAd + ", maxVert=" + maxVert + '}';
    }
    
    
       
}
