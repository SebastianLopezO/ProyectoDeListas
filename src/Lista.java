import javax.swing.*;

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

    public void InsertEnd(int Dato){
        Nodo P,X=new Nodo(Dato);
        
        if(this.Punta==null){
            Punta=X;
            Cola=X;
            Punta.setLigaI(Cola);
            Cola.setLigaD(Punta);
        } else{
            Punta.setLigaI(X);
            Cola.setLigaD(X);
            X.setLigaI(Cola);
            Cola=X;
            Cola.setLigaD(Punta);
        }

    }

    public void ShowList(){
        String msj = "[ ";
        Nodo P=this.Punta;
        boolean Spin=true;
        while (Spin && Punta!=null){
            msj += "{ "+P.getLigaI() +" | "+ P.getDato() + " | " + P.getLigaD() + " }  => ";
            P=P.getLigaD();
            if(P==Punta){
                Spin=false;
            }
        }
        msj += " ]";
        JOptionPane.showMessageDialog(null, msj);


    }
}
