import javax.swing.*;
import java.awt.*;

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

    public void ShowListDetails(){
        String msj = "[ ";
        Nodo P=this.Punta;
        boolean Spin=true;
        while (Spin && Punta!=null){
            msj += "{ "+BColors.BLUE+P.getLigaI()+BColors.RESET +" | "+ P.getDato() + " | " +BColors.BLUE+ P.getLigaD()+BColors.RESET + " }  => ";
            P=P.getLigaD();
            if(P==Punta){
                Spin=false;
            }
        }
        msj += " ]";
        System.out.println(msj);
    }

    public void ShowList(){
        String msj = "[ ";
        Nodo P=this.Punta;
        boolean Spin=true;
        while (Spin && Punta!=null){
            msj += "{ " + P.getDato() + " }  => ";
            P=P.getLigaD();
            if(P==Punta){
                Spin=false;
            }
        }
        msj += " ]";
        JOptionPane.showMessageDialog(null, msj);
    }

    public void ShowListHtml(){
        //Contenedor Html
        JEditorPane editorPane = new JEditorPane();
        editorPane.setSize(500, 500);
        editorPane.setLocation(50, 50);
        editorPane.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setPreferredSize(new Dimension(400, 400));
        //Jframe
        JFrame frame = new JFrame("Lista");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();

        //Encabezado y Estilo
        String html = /*Definicion*/"<!DOCTYPE html><html><head>" +
                /*Estilos*/"<style>.body{display:flex;justify-content: center;width: 100%;}.nodo{display:flex;align-items:center;justify-content:space-between;width:100px;height:50px;border:2px solid black;border-radius:5px;padding:5px;font-size:20px;font-weight:bold;}.liga-izquierda{display:flex;align-items:center;justify-content:center;width:20px;height:20px;background-color:yellow;border-radius:5px;}.liga-derecha{display:flex;align-items:center;justify-content:center;width:20px;height:20px;background-color:green;border-radius:5px;}.flecha{width: 50px;height: 50px;border: 2px solid black;border-radius: 50%;font-size: 24px;font-weight: bold;display: flex;align-items: center;justify-content: center;}</style>"+
                /*Head*/"</head><body>";

        Nodo P=this.Punta;
        boolean Spin=true;
        while (Spin && Punta!=null){
            html += "<div class=\"nodo\">"+
                        "<div class=\"liga-izquierda\">"+P.getLigaI()+"</div>"+
                        "<div class=\"dato\">"+P.getDato()+"</div>"+
                        "<div class=\"liga-derecha\">"+P.getLigaD()+"</div>"+
                    "</div>"+
                    "<div class=\"flecha\">&#10140;</div>";

            P=P.getLigaD();
            if(P==Punta){
                Spin=false;
            }
        }
        html += " </body></html>";
        //Creacion de Panel
        editorPane.setText(html);
        frame.setVisible(true);
    }
}
