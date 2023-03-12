import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean app=true;
        String Option,OptionOrder,OptionOpe,OptionAct;

        Lista ListA=new Lista();
        Lista ListB=new Lista();
        Lista ListC=new Lista();
        Lista ListD=new Lista();
        Lista ListAns=new Lista();

        do {
            Option=Menu();
            switch (Option){
                case "Ingresar Ordenado":
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;
            }
        }while (app);
    }

    public static String Menu(){
        String[] Options = {    "Ingresar Ordenado",
                                "Ingresar al Final",
                                "Ingresar al Inicio",
                                "Ordenar Lista",
                                "Mostrar Lista",
                                "Operacion Con Listas",
                                "Salir"
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

}