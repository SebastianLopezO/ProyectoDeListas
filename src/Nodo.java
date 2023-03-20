public class Nodo {
    //Atributos
    private int Dato;
    private Nodo LigaI;
    private Nodo LigaD;


    public Nodo(int Dato) {
        this.Dato = Dato;
        this.LigaI = null;
        this.LigaD = null;
    }

    public Nodo(int Dato, Nodo LigaI, Nodo LigaD) {
        this.Dato = Dato;
        this.LigaI = LigaI;
        this.LigaD = LigaD;
    }
    //Getters and Setters

    public int getDato() {
        return Dato;
    }

    public void setDato(int dato) {
        Dato = dato;
    }

    public Nodo getLigaI() {
        return LigaI;
    }

    public void setLigaI(Nodo ligaI) {
        LigaI = ligaI;
    }

    public Nodo getLigaD() {
        return LigaD;
    }

    public void setLigaD(Nodo ligaD) {
        LigaD = ligaD;
    }

    //Metodos
}
