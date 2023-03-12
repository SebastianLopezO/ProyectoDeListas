public class Main {
    public static void main(String[] args) {

        Lista ListA=new Lista();
        Lista ListB=new Lista();
        Lista ListC=new Lista();
        Lista ListD=new Lista();
        Lista ListAns=new Lista();

        System.out.println("Hello world!");
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
        return "hola";
    }

    public static String MenuOrder(){
        String[] Options = {    "Ascendente",
                                "Descendente"
                            };
        return "hola";
    }

    public static String MenuActions(){
        String[] Options = {    "Eliminar",
                                "Reemplazar",
                                "Mostrar"
                            };
        return "hola";
    }

    public static String MenuOperate(){
        String[] Options = {    "Suma",
                                "Resta",
                                "Multiplicación",
                                "División"
                            };
        return "hola";
    }

}