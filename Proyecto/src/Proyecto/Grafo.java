package Proyecto;


class Grafo {
    
    private int nVert;
    private Vertice[] tablAd;
    private int maxVert;

    public Grafo(int maxVert) {
        this.maxVert = maxVert;
        this.tablAd=new Vertice[maxVert];
        this.nVert=0;
    }
    
    
    
    public int getNumVertice(String nombre){
        Vertice v=new Vertice(nombre);
        boolean encontrado = false;
        int i=0;
        for(;(i<this.nVert)&& !encontrado;){
            encontrado=this.tablAd[i].equals(v);
            if(!encontrado){
                i++;
            }
        }
        return (i<this.nVert)? i:-1;
        
    }
    
    public Vertice getVertice(int i)throws Exception{
        if (i>this.nVert){
            throw new Exception("Vertice fuera de rango");
        }
        else{
            for(int index=0;index<i;index++){
                
            }
            return this.tablAd[i];
        }
    }
    
    public void nuevoVertice(String nombre){
        boolean existe= this.getNumVertice(nombre)>=0;
        if(!existe){
            if(nombre.contains(":")){
                nombre=nombre.replaceAll("[{}\"]", "");
                String[] partes = nombre.split(":");
                String key = partes[0];
                String value = partes[1];
              
                Vertice v = new Vertice(key);
                v.setIndice(nVert);
                this.tablAd[nVert]=v;
            }
            else{
                Vertice v = new Vertice(nombre);
                v.setIndice(nVert);
                this.tablAd[nVert]=v;
            }
            nVert++;
        }
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
                throw new Exception ("El vertie no existe");
            }
            
            Arco ab= new Arco(b);
            this.tablAd[v1].lad.insertarAlPrincipio(ab);
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
    
    public class Vertice{
        String nombre;
        int indice;
        ListaSimple lad;

        public Vertice(String nombre) {
            this.nombre = nombre;
            this.indice = -1;
            this.lad= new ListaSimple();
        }

        public String getNombre(){
            return nombre;
        }
        
        public void setIndice(int i){
            this.indice= i;
        }
        
        public boolean nIgual(String d){
            Vertice temp= new Vertice(d);
            return this.nombre.equals(temp.nombre);
        }
        
        public String aStr(){
            return this.nombre + "("+this.indice+")";
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
       
}
