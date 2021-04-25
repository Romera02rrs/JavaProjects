import java.util.Iterator;
import java.util.Scanner;


public class cTienda {

    //Declaracion de la matriz para el menu
    private String[][] menu;
    //Declaracion de los objetos para acceder a los metodos de las clases
    static Scanner sc;
    static cAgenda a = new cAgenda();
    static cStock s = new cStock();
    static cCompra c = new cCompra();

    public cTienda(){

        //Inicializacion de la matriz
        menu = new String[4][6];
        sc = new Scanner(System.in);
        inicializarMenu();
    }

    public static void main(String[] args) {

        cTienda t = new cTienda();
        int opcionMenu1, opcionMenu2;
        //Titulo decorativo al inicio del programa
        t.mostrarTitulo();
        //Bucle que se ejecutara hasta salir del programa
        do{
            //Primera parte del menu
            t.mostrarMenu1();
            opcionMenu1 = t.leerOpcionMenu1();
            while (opcionMenu1 != 0){
                do {
                    //Segunda parte del menu
                    t.mostrarMenu2(opcionMenu1);
                    opcionMenu2 = t.leerOpcionMenu2();
                    t.ejecutarOpcionMenu(opcionMenu1, opcionMenu2);
                }while (opcionMenu2 != 0);
                break;
            }
        }while(opcionMenu1 != 0);
        t.mostrarDespedida();
    }

    private void inicializarMenu(){

        menu [0][0] = "[1] Agenda";
        menu [0][1] = "[2] Stock";
        menu [0][2] = "[3] Compras";
        menu [0][3] = "[0] Salir de la tienda";

        menu [1][0] = "[1] Mostrar Clientes";
        menu [1][1] = "[2] Editar Clientes";
        menu [1][2] = "[3] Borrar Cliente";
        menu [1][3] = "[4] Alta Cliente";
        menu [1][4] = "[0] <- Atras";

        menu [2][0] = "[1] Mostrar Stock";
        menu [2][1] = "[2] Editar Electrodomestico";
        menu [2][2] = "[3] Borrar Electrodomestico";
        menu [2][3] = "[4] Alta Electrodomestico";
        menu [2][4] = "[0] <- Atras";

        menu [3][0] = "[1] Mostrar Compras";
        menu [3][1] = "[2] Nueva Compra";
        menu [3][2] = "[0] <- Atras";
    }

    //Correccion de errores a la hora de escoger la opcion de los menus
    private int leerOpcionMenu1(){
        int opcion;
        do{
            System.out.print("Opcion -> ");
            opcion = sc.nextInt();
            for (int i = 0; i < 4; i++) {
                if (opcion == i) {
                    return opcion;
                }
            }
        }while (true);
    }

    private int leerOpcionMenu2(){
        int opcion;
        do{
            System.out.print("Opcion -> ");
            opcion = sc.nextInt();
            for (int i = 0; i < 4; i++){
                if (opcion == i){
                    return opcion;
                }
            }
        }while (true);
    }

    //Principal Switchcase del programa donde se ejecutan todas las opciones
    private void ejecutarOpcionMenu(int opcion1, int opcion2){

        switch (opcion1) {

            case 1 -> {
                switch (opcion2) {
                    case 1 -> mostrarClientes();
                    case 2 -> a.editarClientes();
                    case 3 -> a.borrarCliente();
                    case 4 -> a.altaCliente();
                }
            }
            case 2 -> {
                switch (opcion2) {
                    case 1 -> mostrarStock();
                    case 2 -> s.editarElectrodomestico();
                    case 3 -> s.borrarElectrodomestico();
                    case 4 -> s.altaElectrodomestico("null"); //no introducir un numeoro de ref que ya este
                }
            }
            case 3 -> {
                switch (opcion2) {
                    case 1 -> mostrarTickets();
                    case 2 -> {
                        mostrarClientes();
                        cCliente comprador = a.dameCliente();
                        cElectrodomestico ele = s.dameElectrodomestico();
                        c.nuevaCompra(comprador, ele);
                        System.out.println("Ticket creado correctamente");
                    }
                }
            }
        }
    }

    //Salida por pantalla del menu y sus opciones
    private void mostrarMenu1(){

        System.out.println("""
                
                ******************
                * Menu principal *
                ******************
                """);
        for (int i = 0; i < 1; i++) {
            for(int j = 0; j < 4; j++){
                System.out.println(menu[i][j]);
            }
        }
    }

    private void mostrarMenu2(int opcion1){
        switch (opcion1){
         case 1 -> System.out.println("""
                
                ***************
                * Menu Agenda *
                ***************
                """);
         case 2 -> System.out.println("""
                
                **************
                * Menu Stock *
                **************
                """);
         case 3 -> System.out.println("""
                
                ****************
                * Menu Compras *
                ****************
                """);
        }
        for (int i = opcion1; i < opcion1+1; i++){
            for(int j = 0; j < 6; j++){
                if(menu[i][j] == null){
                    return;
                }
                System.out.println(menu[i][j]);
            }
        }
    }

    //Metodo que muestra los tickets en la array de items de las compras
    public void mostrarTickets(){

        Iterator<cTicket> iter = c.listaTickets().listIterator();
        while (iter.hasNext()){
            cTicket t = iter.next();
            System.out.println(t.toString());
        }
    }

    //Metodo que mueestra todos los clientes
    public void mostrarClientes(){

        Iterator<cCliente> iter = a.listaClientes().listIterator();
        while (iter.hasNext()){
            cCliente c = iter.next();
            System.out.println(c.toString());
        }
    }

    //Metodo que muestra todos los electrodomesticos
    public void mostrarElectrodomesticos(){

        Iterator<cElectrodomestico> iter = s.listaElectrodomesticos().listIterator();
        while (iter.hasNext()){
            cElectrodomestico e = iter.next();
            System.out.println(e.toString(e));
        }
    }

    //Metodo que permite escoger entre mostrar un tipo de electrodomestico o todos
    public void mostrarStock(){

        String opcion2;
        cElectrodomestico opcion;
        String id;
        do{
            System.out.println("Qieres consultar un electrodomestico o todos?");
            System.out.print("Escriba \"u\" o \"t\": ");
            opcion2 = sc.next();
        }while (!(opcion2.equalsIgnoreCase("u") || opcion2.equalsIgnoreCase("t")));
        if(opcion2.equalsIgnoreCase("t")){
            mostrarElectrodomesticos();
        }else{
            id = s.dameID();
            Iterator<cElectrodomestico> iter = s.listaElectrodomesticos().listIterator();
            while (iter.hasNext()){
                cElectrodomestico ele = iter.next();
                if(ele.nombre.equals(id)){
                    System.out.println(ele.toString(ele));
                }
            }
        }
    }

    //Metodo que muestra el electrodomestico que le pases
    public void mostrarUnElectrodomestico(String id){

        Iterator<cElectrodomestico> iter = s.listaElectrodomesticos().listIterator();
        while (iter.hasNext()){
            cElectrodomestico ele = iter.next();
            if(ele.nombre.equals(id)){
                System.out.println(ele.toString(ele));
            }
        }
    }

    //Metodo que muestra el titulo decorativo al inicio del programa
    public void mostrarTitulo(){

        System.out.println("""
                 
                 
                 /$$$$$$$$ /$$                           /$$         \s
                |__  $$__/|__/                          | $$         \s
                   | $$    /$$  /$$$$$$  /$$$$$$$   /$$$$$$$  /$$$$$$\s
                   | $$   | $$ /$$__  $$| $$__  $$ /$$__  $$ |____  $$
                   | $$   | $$| $$$$$$$$| $$  \\ $$| $$  | $$  /$$$$$$$
                   | $$   | $$| $$_____/| $$  | $$| $$  | $$ /$$__  $$
                   | $$   | $$|  $$$$$$$| $$  | $$|  $$$$$$$|  $$$$$$$
                   |__/   |__/ \\_______/|__/  |__/ \\_______/ \\_______/
                                                                    
                """);
    }

    public void mostrarDespedida(){

        System.out.println("""
                  
                  /$$$$$$        /$$ /$$                   \s
                 /$$__  $$      | $$|__/                   \s
                | $$  \\ $$  /$$$$$$$ /$$  /$$$$$$   /$$$$$$$
                | $$$$$$$$ /$$__  $$| $$ /$$__  $$ /$$_____/
                | $$__  $$| $$  | $$| $$| $$  \\ $$|  $$$$$$\s
                | $$  | $$| $$  | $$| $$| $$  | $$ \\____  $$
                | $$  | $$|  $$$$$$$| $$|  $$$$$$/ /$$$$$$$/
                |__/  |__/ \\_______/|__/ \\______/ |_______/\s
                                                          \s
                """);
    }

    //Metodo que crea un nuevo objeto de tipo cliente al que le inserta la informacion del cliente
    public cCliente pedirCliente(){

        cCliente c = new cCliente();

        System.out.println("Introduce el nombre del cliente");
        c.nombre = sc.next();
        System.out.println("Introduce el primer apellido del cliente");
        c.apellido1 = sc.next();
        System.out.println("Introduce el segundo apellido del cliente");
        c.apellido2 = sc.next();
        System.out.println("Introduce el NIF del cliente");
        c.NIF = sc.next();

        return c;
    }

    //Metodo que devuelve un electrodomestico ya creado y con sus valores ya definidos
    public cElectrodomestico insertarElectrodomestico(String id){

        cElectrodomestico ele = new cElectrodomestico();
        if(id.equals("null")){
            id = s.dameID();
        }
        ele.nombre = id;
        System.out.println("Introduce el numero de referencia del nuevo electrodomestico (Introduce un numero)");
        do{
            ele.numRef = sc.nextInt();
        }while (s.verificaNumRef(id, ele.numRef) == false);
        System.out.println("Introduzca la marca");
        ele.marca = sc.next();
        System.out.println("Introduzca el modelo");
        ele.modelo = sc.next();
        System.out.println("Introduzca la eficiencia energetica");
        ele.EE = sc.next();
        System.out.println("Introduzca la cantidad (Introduce un numero)");
        ele.cantidad = sc.nextInt();
        System.out.println("Introduzca el precio de venta al publico (Introduce un numero)");
        ele.PVP = sc.nextInt();
        if (id.equals("Estufa")){
            System.out.println("Introduce la potencia (Introduce un numero)");
            ele.potenciaW = sc.nextInt();
        }else if(id.equals("Television")){
            System.out.println("Introduce la definicion");
            ele.definicion = sc.next();
            System.out.println("Introduce las pulgadas (Introduce un numero)");
            ele.pulgadas = sc.nextInt();
        }else if(id.equals("Microondas")){
            System.out.println("Introduce la potencia (Introduce un numero)");
            ele.potenciaW = sc.nextInt();
            System.out.println("Introduce el volumen en litros (Introduce un numero)");
            ele.volumenLitros = sc.nextInt();
        }else if(id.equals("Nevera")){
            System.out.println("Introduce la altura (Introduce un numero)");
            ele.alturaM = sc.nextInt();
            System.out.println("Introduce la anchura (Introduce un numero)");
            ele.anchuraM = sc.nextInt();
            System.out.println("Introduce la longitud (Introduce un numero)");
            ele.longitudM = sc.nextInt();
            System.out.println("Introduce si contiene congelaror"); // solo puede ser TRUE o FALSE
            ele.congelador = sc.next();
        }else if(id.equals("Horno")){
            System.out.println("Introduce la potencia (Introduce un numero)");
            ele.potenciaW = sc.nextInt();
            System.out.println("Introduce el volumen en litros (Introduce un numero)");
            ele.volumenLitros = sc.nextInt();
        }else if(id.equals("Lavadora")){
            System.out.println("Introduce la potencia (Introduce un numero)");
            ele.potenciaW = sc.nextInt();
            System.out.println("Introduce la cantidad de programas (Introduce un numero)");
            ele.programas = sc.nextInt();
        }
        return ele;
    }

    /*public int dameInt(){

        int intValido;
        do{
            intValido = sc.nextInt();
        }
        while (intValido < -2147483648 && intValido > 2147483647);
        return intValido;
    }*/
}

//V.6