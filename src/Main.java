import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        boolean app = true, action = true;
        String OptionP, Option, OptionSort, OptionOpe[], OptionAct, OptionShow;


        //Listas
        Lista ListA = new Lista("ListA");
        Lista ListB = new Lista("ListB");
        Lista ListC = new Lista("ListC");
        Lista ListD = new Lista("ListD");
        Lista ListAns = new Lista("ListAns");

        //Mapa
        Map<String, Lista> Variables = new HashMap<>();
        Variables.put("ListA", ListA);
        Variables.put("ListB", ListB);
        Variables.put("ListC", ListC);
        Variables.put("ListD", ListD);
        Variables.put("ListAns", ListAns);

        //Puntero
        Lista L = null;
        Lista S = null;

        do {
            action = true;
            OptionP = MenuVal();
            switch (OptionP) {
                case "ListA":
                    L = ListA;
                    break;
                case "ListB":
                    L = ListB;
                    break;
                case "ListC":
                    L = ListC;
                    break;
                case "ListD":
                    L = ListD;
                    break;
                case "ListAns":
                    L = ListAns;
                    break;
                case "Operacion entre Listas":
                    OptionOpe = MenuOpe();
                    ListAns.Truncate();

                    L=Variables.get(OptionOpe[0]);
                    S=Variables.get(OptionOpe[2]);

                    switch (OptionOpe[1]) {
                        case "+":
                            ListAns.Sum(L, S);
                            break;
                        case "-":
                            ListAns.Sub(L, S);
                            break;
                        case "*":
                            ListAns.Mult(L, S);
                            break;
                        case "/":
                            ListAns.Div(L, S);
                            break;
                    }

                    ListAns.Method = OptionOpe[0] + OptionOpe[1] + OptionOpe[2];
                    OptionShow = MenuShow(ListAns.Method);
                    switch (OptionShow) {
                        case "Consola":
                            ListAns.ShowListDetOpe(L, S);
                            break;
                        case "Panel":
                            ListAns.ShowListOpe(L, S);
                            break;
                        case "Web":
                            Export(new Lista[]{L,S, ListAns});
                            break;
                    }
                    action = false;
                    break;
                case "Salir":
                    System.out.println("Hasta luego, vuelva pronto");
                    //Exportacion
                    Export(new Lista[]{ListA, ListB, ListC, ListD, ListAns});
                    action = false;
                    app = false;
                    break;
            }
            while (action) {
                Option = Menu(L.Name);
                switch (Option) {
                    case "Insertar Ordenado":

                        OptionSort = MenuSort(Option,L.Name);
                        switch (OptionSort) {
                            case "Ascendente":
                                L.InsertAsc(GetNum());
                                break;
                            case "Descendente":
                                L.InsertDsc(GetNum());
                                break;
                        }
                        L.Method = Option + " " + OptionSort;
                        break;
                    case "Insertar al Final":
                        L.Method = Option;
                        L.InsertEnd(GetNum());
                        break;
                    case "Insertar al Inicio":
                        L.Method = Option;
                        L.InsertBegin(GetNum());
                        break;
                    case "Buscar Dato":
                        int Dato=GetNum();
                        if(L.Include(Dato)){
                            OptionAct=MenuActions(L.Name,Dato);
                            switch (OptionAct){
                                case "Eliminar":
                                    L.Delete(Dato);
                                    break;
                                case "Reemplazar":
                                    L.Replace(Dato,GetNum());
                                    break;
                                case "Mostrar":
                                    OptionShow=MenuShow(L.Name);
                                    switch (OptionShow){
                                        case "Consola": L.ShowDataDetails(Dato); break;
                                        case "Panel": L.ShowData(Dato); break;
                                        case "Web": L.ShowDataHtml(Dato); break;
                                    }
                                    break;
                            }
                        }else{
                            System.out.println("Elemento no encontrado");
                        }
                        break;
                    case "Ordenar Lista":
                        OptionSort = MenuSort(Option,L.Name);
                        switch (OptionSort) {
                            case "Ascendente":
                                L.SortAsc();
                                break;
                            case "Descendente":
                                L.SortDsc();
                                break;
                        }
                        L.Method = Option + " " + OptionSort;
                        break;
                    case "Mostrar Lista":
                        OptionShow = MenuShow(L.Name);
                        switch (OptionShow) {
                            case "Consola":
                                L.ShowListDetails();
                                break;
                            case "Panel":
                                L.ShowList();
                                break;
                            case "Web":
                                L.ShowListHtml();
                                break;
                        }
                        break;
                    case "Volver":
                        action = false;
                        break;
                }

            }

        } while (app);
    }

    public static String Menu(String Lista) {
        String[] Options = {"Insertar Ordenado",
                "Insertar al Final",
                "Insertar al Inicio",
                "Ordenar Lista",
                "Buscar Dato",
                "Mostrar Lista",
                "Volver"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Menu "+Lista,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuVal() {
        String[] Options = {"ListA",
                "ListB",
                "ListC",
                "ListD",
                "ListAns",
                "Operacion entre Listas",
                "Salir"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la lista: ",
                "Variables",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuSort(String Metodo,String List) {
        String[] Options = {"Ascendente",
                "Descendente"
        };

        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                Metodo+" "+List,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String MenuActions(String List,int Dato) {
        String[] Options = {"Eliminar",
                "Reemplazar",
                "Mostrar"
        };
        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Acciones en "+List+" para Dato: "+Dato,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static String[] MenuOpe() {
        JComboBox<String> Var1 = new JComboBox<>(new String[]{"ListA", "ListB", "ListC", "ListD"});
        JComboBox<String> Var2 = new JComboBox<>(new String[]{"ListA", "ListB", "ListC", "ListD"});
        JComboBox<String> Ope = new JComboBox<>(new String[]{"+", "-", "*", "/"});

        Object[] msj = {Var1, Ope, Var2};
        JOptionPane.showConfirmDialog(null, msj, "Operacion a realizar:", JOptionPane.DEFAULT_OPTION);
        String[] Option = {(String) Var1.getSelectedItem(), (String) Ope.getSelectedItem(), (String) Var2.getSelectedItem()};
        return Option;
    }

    public static String MenuShow(String List) {
        String[] Options = {"Consola",
                "Panel",
                "Web"
        };
        String Option = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una Opcion: ",
                "Mostrar "+List,
                JOptionPane.QUESTION_MESSAGE,
                null,
                Options,
                Options[0]);
        return Option;
    }

    public static int GetNum() {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Numero a Insertar: "));
                return num;
            } catch (NumberFormatException ex) {
                System.out.println("No ha insertado un numero, error" + ex);
            }
        }
    }

    public static void Export(Lista[] Elems) {
        //Archivo
        Html FileProyect = new Html();
        for (int i = 0; i < Elems.length; i++) {
            FileProyect.AddBody(Elems[i].ExportListHtml());
        }
        FileProyect.Export("Memory");
    }

}