import javax.swing.*;

public class Lista {
    //Atributos
    private Nodo Punta;
    private Nodo Cola;
    public String Name, Method;

    public Lista(String Name) {
        this.Punta = null;
        this.Cola = null;
        this.Name = Name;
        this.Method = "empty";
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

    public void InsertEnd(int Dato) {
        if (this.Punta == null) {
            Nodo X = new Nodo(Dato);
            X.setLigaI(X);
            X.setLigaD(X);
            Punta = X;
            Cola = X;
        } else {
            Nodo X = new Nodo(Dato, Cola, Punta);
            Punta.setLigaI(X);
            Cola.setLigaD(X);
            Cola = X;
        }
    }

    public void InsertBegin(int Dato) {
        if (this.Punta == null) { 
            //Insertar en medio cuando no existe lista
            Nodo X = new Nodo(Dato);
            X.setLigaI(X);
            X.setLigaD(X);
            Punta = X;
            Cola = X;
        } else { 
            //Insertar en medio cuando ya existe una lista
            Nodo X = new Nodo(Dato, Cola, Punta);
            Punta.setLigaI(X); 
            Cola.setLigaD(X);
            Punta = X;
        }
    }

    public void InsertAsc(int Dato) {
        SortAsc();
        if (Punta == null) {
            InsertEnd(Dato);
        } else if (Dato <= Punta.getDato()) {
            InsertBegin(Dato);
        } else if (Dato >= Cola.getDato()) {
            InsertEnd(Dato);
        } else {
            Nodo P = Punta, A = P.getLigaD();
            Boolean ins = true;
            do {
                if (P.getDato() <= Dato && Dato <= A.getDato()) {
                    Nodo X = new Nodo(Dato, P, A);
                    P.setLigaD(X);
                    A.setLigaI(X);
                    ins = false;
                }
                P = P.getLigaD();
                A = P.getLigaD();
            } while (P != Cola && ins);
        }
    }

    public void InsertDsc(int Dato) {
        SortDsc();
        if (Punta == null) {
            InsertEnd(Dato);
        } else if (Dato >= Punta.getDato()) {
            InsertBegin(Dato);
        } else if (Dato <= Cola.getDato()) {
            InsertEnd(Dato);
        } else {
            Nodo P = Punta, A = P.getLigaD();
            Boolean ins = true;
            do {
                if (P.getDato() >= Dato && Dato >= A.getDato()) {
                    Nodo X = new Nodo(Dato, P, A);
                    P.setLigaD(X);
                    A.setLigaI(X);
                    ins = false;
                }
                P = P.getLigaD();
                A = P.getLigaD();
            } while (P != Cola && ins);
        }
    }

    public void SortAsc() {
        int cont = 0;
        int len = Length();
        Nodo P = Punta;
        while (cont != (len * len)) {
            if (P.getDato() > (P.getLigaD()).getDato() && P.getLigaD() != Punta) {
                Swap(P, P.getLigaD());
            }
            P = P.getLigaD();
            cont++;
        }
    }

    public void SortDsc() {
        int cont = 0;
        int len = Length();
        Nodo P = Punta;
        while (cont != (len * len)) {
            if (P.getDato() < (P.getLigaD()).getDato() && P.getLigaD() != Punta) {
                Swap(P, P.getLigaD());
            }
            P = P.getLigaD();
            cont++;
        }
    }

    //Operaciones
    public void Sum(Lista L, Lista S) {
        Nodo PL = L.getPunta();
        Nodo PS = S.getPunta();
        int DL, DS;
        do {
            DL = 0;
            DS = 0;
            //Obtener Digito de Lista L
            if (PL != null) {
                DL = PL.getDato();
                if (PL.getLigaD() == L.getPunta()) {
                    PL = null;
                } else {
                    PL = PL.getLigaD();
                }
            }

            //Obtener Digito de Lista S
            if (PS != null) {
                DS = PS.getDato();
                if (PS.getLigaD() == S.getPunta()) {
                    PS = null;
                } else {
                    PS = PS.getLigaD();
                }
            }
            //Realiza la operación:
            if (L.getPunta() != null || S.getPunta() != null) {
                InsertEnd(DL + DS);
            }
        } while (PL != null || PS != null);
    }

    public void Sub(Lista L, Lista S) {
        Nodo PL = L.getPunta();
        Nodo PS = S.getPunta();
        int DL, DS;
        do {
            DL = 0;
            DS = 0;
            //Obtener Digito de Lista L
            if (PL != null) {
                DL = PL.getDato();
                if (PL.getLigaD() == L.getPunta()) {
                    PL = null;
                } else {
                    PL = PL.getLigaD();
                }
            }

            //Obtener Digito de Lista S
            if (PS != null) {
                DS = PS.getDato();
                if (PS.getLigaD() == S.getPunta()) {
                    PS = null;
                } else {
                    PS = PS.getLigaD();
                }
            }
            if (L.getPunta() != null || S.getPunta() != null) {
                InsertEnd(DL - DS);
            }
        } while (PL != null || PS != null);
    }

    public void Mult(Lista L, Lista S) {
        Nodo PL = L.getPunta();
        Nodo PS = S.getPunta();
        int DL, DS;
        do {
            DL = 0;
            DS = 0;
            //Obtener Digito de Lista L
            if (PL != null) {
                DL = PL.getDato();
                if (PL.getLigaD() == L.getPunta()) {
                    PL = null;
                } else {
                    PL = PL.getLigaD();
                }
            }

            //Obtener Digito de Lista S
            if (PS != null) {
                DS = PS.getDato();
                if (PS.getLigaD() == S.getPunta()) {
                    PS = null;
                } else {
                    PS = PS.getLigaD();
                }
            }
            if (L.getPunta() != null || S.getPunta() != null) {
                InsertEnd(DL * DS);
            }
        } while (PL != null || PS != null);
    }

    public void Div(Lista L, Lista S) {
        Nodo PL = L.getPunta();
        Nodo PS = S.getPunta();
        int DL, DS;
        do {
            DL = 0;
            DS = 0;

            // Obtener Dígito de lista L
            if (PL != null) {
                DL = PL.getDato();
                if (PL.getLigaD() == L.getPunta()) {
                    PL = null;
                } else {
                    PL = PL.getLigaD();
                }
            }

            // Obtener Dígito de lista S
            if (PS != null) {
                DS = PS.getDato();
                if (PS.getLigaD() == S.getPunta()) {
                    PS = null;
                } else {
                    PS = PS.getLigaD();
                }
            }
            if (L.getPunta() != null || S.getPunta() != null) {
                if (DS != 0) {
                    InsertEnd(DL / DS);
                }
            }
        } while (PL != null || PS != null);
    }

    public int Length() {
        int cont = 0;
        if (Punta != null) {
            Nodo P = Punta;
            do {
                P = P.getLigaD();
                cont++;
            } while (P != Punta);
        }

        return cont;
    }

    //utilities

    public Boolean Include(int Dato) {
        boolean find = false;
        if (Punta != null) {
            Nodo P = Punta;
            do {
                if (P.getDato() == Dato) {
                    find = true;
                }
                P = P.getLigaD();
            } while (P != Punta && !find);
        } else {
            System.out.println("Lista Vacia.");
            JOptionPane.showMessageDialog(null, "Lista Vacia.");
        }
        return find;
    }

    public void Delete(int Dato) {
        Nodo P = Punta;
        boolean chg=false;
        do {
            chg=false;
            if (P.getDato() == Dato) {
                //Llama al método que elimina el nodo cuando apunta a si mismo osea que es cabeza y cola al mismo tiempo
                if (Punta == Cola) {
                    Truncate(); 
                } else if (P == Punta) { //Cuando el nodo a eliminar es el primero.
                    Punta = P.getLigaD();
                    Cola.setLigaD(Punta);
                    Punta.setLigaI(Cola);
                    chg=true;
                } else if (P == Cola) { //Cuando el dato a eliminar es el último
                    Cola = P.getLigaI();
                    Punta.setLigaI(Cola);
                    Cola.setLigaD(Punta);
                } else { //Cuando el dato se encuentra en medio
                    (P.getLigaI()).setLigaD(P.getLigaD());
                    (P.getLigaD()).setLigaI(P.getLigaI());
                }
                System.gc();
            }
            P = P.getLigaD();
        } while (chg || P != Punta && Punta!=null);

    }

    public void Replace(int Dato, int newDato) {
        Nodo P = Punta;
        do {
            if (P.getDato() == Dato) {
                P.setDato(newDato); //se le asigna el nuevo dato a reemplazar
            }
            P = P.getLigaD();
        } while (P != Punta);
    }

    public void Truncate() {
        this.Punta = null;
        this.Cola = null;
        this.Method = "empty";
        System.gc();
    }

    public void Swap(Nodo P, Nodo S) {
        int aux = P.getDato();
        P.setDato(S.getDato());
        S.setDato(aux);
    }

    public void ShowListDetails() {
        String msj = Clr.BG_BL + "\n" + this.Name + ": [ ";
        Nodo P = this.Punta;
        if (Punta != null) {
            do {
                msj += "{ " + Clr.BG_G + P.getLigaI() + Clr.BG_BL + " | " + Clr.BG_Y + " " + P.getDato() + " " + Clr.BG_BL + " | " + Clr.BG_G + P.getLigaD() + Clr.BG_BL + " }  => ";
                P = P.getLigaD();
            } while (P != Punta);
        }
        msj += " ]\n\n" + Clr.RT;
        System.out.println(msj);
    }

    public void ShowDataDetails(int Dato) {
        String msj = Clr.BG_BL + "\n" + this.Name + ": [ ";
        Nodo P = this.Punta;
        if (Punta != null) {
            do {
                if (P.getDato() == Dato) {
                    msj += Clr.BG_G + "{ " + P.getLigaI() + " | " + P.getDato() + " | " + P.getLigaD() + " }" + Clr.BG_BL + "  => ";
                } else {
                    msj += "{ " + P.getLigaI() + " | " + P.getDato() + " | " + P.getLigaD() + " }  => ";
                }
                P = P.getLigaD();
            } while (P != Punta);
        }
        msj += " ]\n\n" + Clr.RT;
        System.out.println(msj);
    }

    public void ShowList() {
        String msj = this.Name + ": [ ";
        Nodo P = this.Punta;
        if (Punta != null) {
            do {
                msj += "{ " + P.getDato() + " }  => ";
                P = P.getLigaD();
            } while (P != Punta);
        }
        msj += " ]";
        JOptionPane.showMessageDialog(null, msj);
    }

    public void ShowData(int Dato) {
        String msj = this.Name + ": [ ";
        Nodo P = this.Punta;
        if (Punta != null) {
            do {
                if (P.getDato() == Dato) {
                    msj += "{ " + P.getDato() + " }  => ";
                }
                P = P.getLigaD();
            } while (P != Punta);
        }
        msj += " ]";
        JOptionPane.showMessageDialog(null, msj);
    }

    public void ShowListOpe(Lista L, Lista S) {
        String msjL = L.Name + ": [ ";
        String msjS = S.Name + ": [ ";
        String msj = this.Name + ": [ ";
        Nodo P = this.Punta;
        Nodo PL = L.getPunta();
        Nodo PS = S.getPunta();
        if (Punta != null) {
            do {
                msj += "{ " + P.getDato() + " }  => ";
                P = P.getLigaD();
            } while (P != Punta);
        }
        if (L.getPunta() != null) {
            do {
                msjL += "{ " + PL.getDato() + " }  => ";
                PL = PL.getLigaD();
            } while (PL != L.getPunta());
        }
        if (S.getPunta() != null) {
            do {
                msjS += "{ " + PS.getDato() + " }  => ";
                PS = PS.getLigaD();
            } while (PS != S.getPunta());
        }
        msj += " ]";
        msjL += " ]";
        msjS += " ]";
        JOptionPane.showMessageDialog(null, msjL + "\n" + msjS + "\n" + Method + ":\n" + msj);
    }

    public void ShowListDetOpe(Lista L, Lista S) {
        String msjL = L.Name + ": [ ";
        String msjS = S.Name + ": [ ";
        String msj = this.Name + ": [ ";
        Nodo P = this.Punta;
        Nodo PL = L.getPunta();
        Nodo PS = S.getPunta();
        if (Punta != null) {
            do {
                msj += "{ " + Clr.B + P.getLigaI() + Clr.RT + " | " + P.getDato() + " | " + Clr.B + P.getLigaD() + Clr.RT + " }  => ";
                P = P.getLigaD();
            } while (P != Punta);
        }
        if (L.getPunta() != null) {
            do {
                msjL += "{ " + Clr.B + PL.getLigaI() + Clr.RT + " | " + PL.getDato() + " | " + Clr.B + PL.getLigaD() + Clr.RT + " }  => ";
                PL = PL.getLigaD();
            } while (PL != L.getPunta());
        }
        if (S.getPunta() != null) {
            do {
                msjS += "{ " + Clr.B + PS.getLigaI() + Clr.RT + " | " + PS.getDato() + " | " + Clr.B + PS.getLigaD() + Clr.RT + " }  => ";
                PS = PS.getLigaD();
            } while (PS != S.getPunta());
        }
        msj += " ]";
        msjL += " ]";
        msjS += " ]";
        System.out.println(msjL + "\n" + msjS + "\n" + Method + ":\n" + msj);
    }

    public void ShowListHtml() {
        Nodo P = this.Punta;
        String list = "<div class=\"container\">" +
                "<div class=\"container-title\">" +
                "<div class=\"title\">" + Name + "</div>" +
                "<div class=\"text\">" + Method + "</div>" +
                "</div>";
        if (Punta != null) {
            do {
                list += "<table>" +
                        "<tr>" +
                        "<td class=\"transparent\">" + P + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class=\"green\">" + P.getLigaI() + "</td>" +
                        "<td class=\"yellow\">" + P.getDato() + "</td>" +
                        "<td class=\"green\">" + P.getLigaD() + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "<div class=\"flecha\">&#8646;</div>";
                P = P.getLigaD();
            } while (P != Punta);
        }
        list += "</div>";
        Html File = new Html();
        File.AddBody(list);
        File.Export(Name);
    }

    public void ShowDataHtml(int Dato) {
        Nodo P = this.Punta;
        String list = "<div class=\"container\">" +
                "<div class=\"container-title\">" +
                "<div class=\"title\">" + Name + "</div>" +
                "<div class=\"text\">" + Method + "</div>" +
                "</div>";
        if (Punta != null) {
            do {
                if (P.getDato() == Dato) {
                    list += "<table>" +
                            "<tr>" +
                            "<td class=\"transparent\">" + P + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td class=\"green\">" + P.getLigaI() + "</td>" +
                            "<td class=\"yellow\">" + P.getDato() + "</td>" +
                            "<td class=\"green\">" + P.getLigaD() + "</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class=\"flecha\">&#8646;</div>";
                } else {
                    list += "<table>" +
                            "<tr>" +
                            "<td class=\"transparent\">" + P + "</td>" +
                            "</tr>" +
                            "<tr>" +
                            "<td class=\"white node\">" + P.getLigaI() + "</td>" +
                            "<td class=\"white data\">" + P.getDato() + "</td>" +
                            "<td class=\"white node\">" + P.getLigaD() + "</td>" +
                            "</tr>" +
                            "</table>" +
                            "<div class=\"flecha\">&#8646;</div>";
                }
                P = P.getLigaD();
            } while (P != Punta);
        }
        list += "</div>";
        Html File = new Html();
        File.AddBody(list);
        File.Export(Name);
    }

    public String ExportListHtml() {
        Nodo P = this.Punta;
        String html = "<div class=\"container\">" +
                "<div class=\"container-title\">" +
                "<div class=\"title\">" + Name + "</div>" +
                "<div class=\"text\">" + Method + "</div>" +
                "</div>";
        if (Punta != null) {
            do {
                html += "<table>" +
                        "<tr>" +
                        "<td class=\"transparent\">" + P + "</td>" +
                        "</tr>" +
                        "<tr>" +
                        "<td class=\"green\">" + P.getLigaI() + "</td>" +
                        "<td class=\"yellow\">" + P.getDato() + "</td>" +
                        "<td class=\"green\">" + P.getLigaD() + "</td>" +
                        "</tr>" +
                        "</table>" +
                        "<div class=\"flecha\">&#8646;</div>";
                P = P.getLigaD();
            } while (P != Punta);
        }
        html += "</div>";
        return html;
    }
}