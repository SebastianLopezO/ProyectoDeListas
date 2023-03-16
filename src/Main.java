import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean app=true,action=true;
        String OptionP,Option,OptionOrder,OptionOpe,OptionAct;

        //Archivo
        Html FileProyect=new Html();

        //Listas
        Lista ListA=new Lista("ListA");
        Lista ListB=new Lista("ListB");
        Lista ListC=new Lista("ListC");
        Lista ListD=new Lista("ListD");
        Lista ListAns=new Lista("ListAns");

        //Puntero
        Lista L=null;

        do {
            action=true;
            OptionP=MenuVal();
            switch (OptionP){
                case "ListA":
                    L=ListA;
                    break;
                case "ListB":
                    L=ListB;
                    break;
                case "ListC":
                    L=ListC;
                    break;
                case "ListD":
                    L=ListD;
                    break;
                case "ListAns":
                    L=ListAns;
                    break;
                case "Salir":
                    System.out.println("Hasta luego, vuelva pronto");
                    //Exportacion
                    FileProyect.AddBody(ListA.ExportListHtml());
                    FileProyect.AddBody(ListB.ExportListHtml());
                    FileProyect.AddBody(ListC.ExportListHtml());
                    FileProyect.AddBody(ListD.ExportListHtml());
                    FileProyect.AddBody(ListAns.ExportListHtml());
                    FileProyect.Export("Memory");
                    action=false;
                    app=false;
                    break;
                default:
                    System.out.println("Variable no reconocida");
                    action=false;
                    break;
            }
            while (action){
                Option=Menu();
                switch (Option){
                    case "Insertar Ordenado":
                        break;
                    case "Insertar al Final":
                        L.InsertEnd(GetNum());
                        break;
                    case "Insertar al Inicio":
                        break;
                    case "Ordenar Lista":
                        break;
                    case "Mostrar Lista":
                        L.ShowListDetails();
                        L.ShowList();
                        L.ShowListHtml();
                        break;
                    case "Volver":
                        action=false;
                        break;
                    default:
                        System.out.println("Opcion Incorrecta");
                        break;
                }
            }

        }while (app);
    }

    public static String Menu(){
        String[] Options = {    "Insertar al Final",
                                "Insertar Ordenado",
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

    public static String MenuOrder(){
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

    public static String MenuOperate(){
        String[] Options = {    "Suma",
                                "Resta",
                                "Multiplicación",
                                "División"
                            };
        String Option =  (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la Opcion: ",
                "Operaciones",
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

}