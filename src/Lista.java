public class Lista {
    //Atributos
    private Nodo Punta;
    private Nodo Cola;

    public Lista(){
        this.Punta=null;
        this.Cola=null;
    }

    //Getters and Setters

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

    public Nodo getCola() {
        return Cola;
    }

    public void setCola(Nodo cola) {
        Cola = cola;
    }

    //Metodos
}
