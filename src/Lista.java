import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
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
        //Contenedor html
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditorKit(new HTMLEditorKit());
        editorPane.setSize(1300, 700);
        editorPane.setLocation(50, 50);
        editorPane.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(editorPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1300, 700));
        //Jframe
        JFrame frame = new JFrame("Lista");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();

        //Encabezado y Estilo
        String html = /*Definicion*/"<html><head>" +
                /*Estilos*/"<style>.container{display:flex;overflow-x:scroll;}\n" +
                "table{border-collapse:collapse;width:auto;margin:10px;}\n" +
                "td{border:1px solid #000;padding:10px;}\n" +
                ".transparent{border:transparent;font-size:12px;}\n" +
                ".green{background-color:green;color:#fff;font-size:12px;}\n" +
                ".yellow{background-color:yellow;color:#000;font-size:30px;}\n" +
                ".flecha{width:50px;height:100px;font-size:24px;border-color:#000;font-weight:bold;display:flex;align-items:center;justify-content:center;}</style>"+
                /*Head*/"</head><body><div class=\"container\">";

        Nodo P=this.Punta;
        boolean Spin=true;
        while (Spin && Punta!=null){
            html += "<table>"+
                        "<tr>"+
                            "<td class=\"transparent\">"+P+"</td>"+
                        "</tr>"+
                        "<tr>"+
                            "<td class=\"green\">"+P.getLigaI()+"</td>"+
                            "<td class=\"yellow\">"+P.getDato()+"</td>"+
                            "<td class=\"green\">"+P.getLigaD()+"</td>"+
                        "</tr>"+
                    "</table>"+
                    "<div class=\"flecha\">&#8693;</div>";
            P=P.getLigaD();
            if(P==Punta){
                Spin=false;
            }
        }
        html += "</div></body></html>";
        //Creacion de Panel
        editorPane.setText(html);
        frame.setVisible(true);
    }
}
