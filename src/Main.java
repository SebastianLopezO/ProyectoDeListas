import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean app=true,action=true;
        String OptionP,Option,OptionSort,OptionOpe[],OptionAct,OptionShow;


        //Listas
        Lista ListA=new Lista("ListA");
        Lista ListB=new Lista("ListB");
        Lista ListC=new Lista("ListC");
        Lista ListD=new Lista("ListD");
        Lista ListAns=new Lista("ListAns");

        //Puntero
        Lista L=null;
        Lista S=null;

        do {
            action=true;
            OptionP=MenuVal();
            switch (OptionP){
                case "ListA": L=ListA;break;
                case "ListB": L=ListB;break;
                case "ListC": L=ListC;break;
                case "ListD": L=ListD;break;
                case "ListAns":
                    L=ListAns;
                    break;
                case "Operacion entre Listas":
                    OptionOpe=MenuOpe();
                    ListAns.Truncate();
                    switch (OptionOpe[0]){
                        case "ListA": L=ListA;break;
                        case "ListB": L=ListB;break;
                        case "ListC": L=ListC;break;
                        case "ListD": L=ListD;break;
                    }
                    switch (OptionOpe[2]){
                        case "ListA": S=ListA;break;
                        case "ListB": S=ListB;break;
                        case "ListC": S=ListC;break;
                        case "ListD": S=ListD;break;
                    }
                    switch (OptionOpe[1]){
                        case "+": ListAns.Sum(L,S);break;
                        case "-": ListAns.Sub(L,S);break;
                        case "*": ListAns.Mult(L,S);break;
                        case "/": ListAns.Div(L,S);break;
                    }
                    ListAns.Method=OptionOpe[0]+OptionOpe[1]+OptionOpe[2];
                    OptionShow=MenuShow();
                    switch (OptionShow){
                        case "Consola": ListAns.ShowListDetOpe(L,S);break;
                        case "Panel": ListAns.ShowListOpe(L,S);break;
                        case "Web": Export(new Lista[]{ListA,ListB,ListC,ListD,ListAns});break;
                    }
                    action=false;
                    break;
                case "Salir":
                    System.out.println("Hasta luego, vuelva pronto");
                    //Exportacion
                    Export(new Lista[]{ListA,ListB,ListC,ListD,ListAns});
                    action=false;
                    app=false;
                    break;
            }
            while (action){
                Option=Menu();
                switch (Option){
                    case "Insertar Ordenado":

                        OptionSort=MenuSort();
                        switch (OptionSort){
                            case "Ascendente":
                                L.InsertAsc(GetNum());
                                break;
                            case "Descendente":
                                L.InsertDsc(GetNum());
                                break;
                        }
                        L.Method=Option+" "+OptionSort;
                        break;
                    case "Insertar al Final":
                        L.Method=Option;
                        L.InsertEnd(GetNum());
                        break;
                    case "Insertar al Inicio":
                        L.Method=Option;
                        L.InsertBegin(GetNum());
                        break;
                    case "Ordenar Lista":
                        OptionSort=MenuSort();
                        switch (OptionSort){
                            case "Ascendente":
                                L.SortAsc();
                                break;
                            case "Descendente":
                                L.SortDsc();
                                break;
                        }
                        L.Method=Option+" "+OptionSort;
                        break;
                    case "Mostrar Lista":
                        OptionShow=MenuShow();
                        switch (OptionShow){
                            case "Consola": L.ShowListDetails();break;
                            case "Panel": L.ShowList();break;
                            case "Web": L.ShowListHtml();break;
                        }
                        break;
                    case "Volver":
                        action=false;
                        break;
                }

            }

        }while (app);
    }

    public static String Menu(){
        String[] Options = {    "Insertar Ordenado",
                                "Insertar al Final",
                                "Insertar al Inicio",
                                "Ordenar Lista",
                                "Mostrar Lista",
                                "Volver"
                            };

        String Option =  (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuVal(){
        String[] Options = {    "ListA",
                "ListB",
                "ListC",
                "ListD",
                "ListAns",
                "Operacion entre Listas",
                "Salir"
        };

        String Option =  (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la lista: ",
                "Variables",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuSort(){
        String[] Options = {    "Ascendente",
                                "Descendente"
                            };

        String Option =  (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Ordenar",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuActions(){
        String[] Options = {    "Eliminar",
                                "Reemplazar",
                                "Mostrar"
                            };
        String Option =  (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Acciones",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String[] MenuOpe(){
        JComboBox<String> Var1 = new JComboBox<>(new String[]{"ListA", "ListB","ListC", "ListD"});
        JComboBox<String> Var2 = new JComboBox<>(new String[]{"ListA", "ListB","ListC", "ListD"});
        JComboBox<String> Ope = new JComboBox<>(new String[]{"+", "-", "*", "/"});

        Object[] msj ={Var1,Ope,Var2};
        JOptionPane.showConfirmDialog(null,msj,"Operacion a realizar:",JOptionPane.DEFAULT_OPTION);
        String[] Option={(String) Var1.getSelectedItem(),(String) Ope.getSelectedItem(),(String) Var2.getSelectedItem()};
        return Option;
    }

    public static String MenuShow(){
        String[] Options = {    "Consola",
                                "Panel",
                                "Web"
        };
        String Option =  (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una Opcion: ",
                "Impresion",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static int GetNum(){
        int num;
        while (true){
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero a Insertar: "));
                return num;
            } catch (NumberFormatException ex) {
                System.out.println("No ha insertado un numero, error"+ex);
            }
        }
    }

    public static void Export(Lista[] Elems){
        //Archivo
        Html FileProyect=new Html();
        for(int i=0;i<Elems.length;i++){
            FileProyect.AddBody(Elems[i].ExportListHtml());
        }
        FileProyect.Export("Memory");
    }

}