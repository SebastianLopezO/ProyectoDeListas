import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;

public class Lista {
    //Atributos
    private Nodo Punta;
    private Nodo Cola;
    public String Name,Method;

    public Lista(String Name){
        this.Punta=null;
        this.Cola=null;
        this.Name=Name;
        this.Method="empty";
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
        //Encabezado y Estilo
        String list = "";

        Nodo P=this.Punta;
        boolean Spin=true;
        list+="<div class=\"container\">" +
                "<div class=\"container-title\">"+
                "<div class=\"title\">"+Name+"</div>"+
                "<div class=\"text\">"+Method+"</div>"+
                "</div>";

        while (Spin && Punta!=null){
            list += "<table>"+
                    "<tr>"+
                    "<td class=\"transparent\">"+P+"</td>"+
                    "</tr>"+
                    "<tr>"+
                    "<td class=\"green\">"+P.getLigaI()+"</td>"+
                    "<td class=\"yellow\">"+P.getDato()+"</td>"+
                    "<td class=\"green\">"+P.getLigaD()+"</td>"+
                    "</tr>"+
                    "</table>"+
                    "<div class=\"flecha\">&#8646;</div>";
            P=P.getLigaD();
            if(P==Punta){
                Spin=false;
            }
        }
        list += "</div>";
        Html File=new Html();
        File.AddBody(list);
        File.Export(Name);

    }

    public String ExportListHtml(){
        String html = "";

        Nodo P=this.Punta;
        boolean Spin=true;
        html+="<div class=\"container\">" +
                    "<div class=\"container-title\">"+
                        "<div class=\"title\">"+Name+"</div>"+
                        "<div class=\"text\">"+Method+"</div>"+
                    "</div>";

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
                    "<div class=\"flecha\">&#8646;</div>";
            P=P.getLigaD();
            if(P==Punta){
                Spin=false;
            }
        }
        html += "</div>";
        return html;
    }
}
