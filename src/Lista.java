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

    public void Insert(int Dato,String Option){
        if(this.Punta==null){
            Nodo X=new Nodo(Dato);
            X.setLigaI(X); X.setLigaD(X);
            Punta=X; Cola=X;
        } else{
            Nodo X=new Nodo(Dato,Cola,Punta);
            Punta.setLigaI(X); Cola.setLigaD(X);
            if(Option=="End"){
                Cola=X;
            } else if (Option=="Begin") {
                Punta=X;
            }
        }

    }

    public void InsertSortAsc(int Dato){
        if(Punta==null){
            Insert(Dato,"End");
        }else if (Dato<=Punta.getDato()){
            Insert(Dato,"Begin");
        }else if(Dato>= Cola.getDato()){
            Insert(Dato,"End");
        }else{

        }
    }

    public void InsertSortDsc(int Dato){
        if(Punta==null){
            Insert(Dato,"End");
        }else if (Dato >= Punta.getDato()){
            Insert(Dato,"Begin");
        }else if(Dato <= Cola.getDato()){
            Insert(Dato,"End");
        }else{
            for(int i=0;i<Length();i++){
                Nodo P=Punta;
                do{

                }while (P!=Punta);
            }
        }
    }

    public int Length(){
        int cont=0;
        if(Punta!=null){
            Nodo P=Punta;
            do{
                P=P.getLigaD();
                cont++;
            }while (P!=Punta);
        }

        return cont;
    }

    //utilities

    public void Swap(Nodo P,Nodo S){
        int aux=P.getDato();
        P.setDato(S.getDato());
        S.setDato(aux);
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
